package com.iteriam.calculadora.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.calculadora.dto.Calculator.Operations;
import com.iteriam.calculadora.exception.CustomException;

@SpringBootTest

public class CalculatorTest {

	@InjectMocks
	private Calculator calculator;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void calculatorEqualTest() throws CustomException {

		Calculator calculatorTWO = new Calculator();
		calculator.equals(calculator);
		calculator.equals(null);
		calculator.equals(calculatorTWO);
		calculator.toString();
		calculator.hashCode();

	}

	@Test
	public void calculatorGetOperationTest() throws CustomException {

		Operations oper = Calculator.getOperation("SUMA");
		assertTrue(oper.values()[0].name().equalsIgnoreCase("SUMA"));
	}

	@Test
	public void calculatorSumaTest() throws CustomException {

		assertTrue(Calculator.add(new BigDecimal("1"), new BigDecimal("1")).compareTo(new BigDecimal("2")) == 0);
	}

	@Test
	public void calculatorRestaTest() throws CustomException {

		assertTrue(Calculator.subtract(new BigDecimal("1"), new BigDecimal("1")).compareTo(new BigDecimal("0")) == 0);
	}

	@Test
	public void calculatorGetOperationNoSoportadaTest() throws CustomException {
		Assertions.assertThrows(CustomException.class, () -> {
			Calculator.getOperation("multiplica");
		});
	}

	@Test
	public void calculatorSumaNumberFormatExcepTest() throws CustomException {
		Assertions.assertThrows(CustomException.class, () -> {
			BigDecimal primerNumero = mock(BigDecimal.class);
			when(primerNumero.add(Mockito.any())).thenThrow(NumberFormatException.class);

			Calculator.add(primerNumero, primerNumero);

		});
	}

	@Test
	public void calculatorRestaNumberFormatExcepTest() throws CustomException {
		Assertions.assertThrows(CustomException.class, () -> {
			BigDecimal primerNumero = mock(BigDecimal.class);
			when(primerNumero.subtract(Mockito.any())).thenThrow(NumberFormatException.class);

			Calculator.subtract(primerNumero, primerNumero);
		});
	}

}

package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.calculadora.exception.CustomException;

@SpringBootTest

public class CalculatorServiceImpTest {

	@InjectMocks
	private CalculatorServiceImp calculatorServiceImp;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void calculaServiceSumaTest() throws CustomException {

		calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "suma");

	}

	@Test
	public void calculaServiceRestaTest() throws CustomException {

		calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "resta");

	}

	@Test
	public void calculaServiceOperacionNoPermitidaTest() throws CustomException {
		Assertions.assertThrows(CustomException.class, () -> {
			calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "multiplica");
		});
	}

}

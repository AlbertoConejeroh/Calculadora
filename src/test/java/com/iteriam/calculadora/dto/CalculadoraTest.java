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

import com.iteriam.calculadora.dto.Calculadora.Operations;
import com.iteriam.calculadora.exception.CustomException;

@SpringBootTest

public class CalculadoraTest {

	@InjectMocks
	private Calculadora calculadora;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void calculadoraGetOperationTest() throws CustomException {

		Operations oper = calculadora.getOperation("SUMA");
		assertTrue(oper.values()[0].name().equalsIgnoreCase("SUMA"));
	}
	@Test
	public void calculadoraSumaTest() throws CustomException {

		
		assertTrue(calculadora.suma(new BigDecimal("1"), new BigDecimal("1")).compareTo(new BigDecimal("2"))==0);
	}
	
	@Test
	public void calculadoraRestaTest() throws CustomException {

		
		assertTrue(calculadora.resta(new BigDecimal("1"), new BigDecimal("1")).compareTo(new BigDecimal("0"))==0);
	}
	
	
	@Test
	public void calculadoraGetOperationNoSoportadaTest() throws CustomException {
		Assertions.assertThrows(CustomException.class,()->{
			calculadora.getOperation("multiplica");
		});
	}
	@Test
	public void calculadoraSumaNumberFormatExcepTest() throws CustomException {
		Assertions.assertThrows(CustomException.class,()->{
			BigDecimal primerNumero  = mock(BigDecimal.class);
			when(primerNumero.add(Mockito.any())).thenThrow(NumberFormatException.class);
			
			calculadora.suma(primerNumero, primerNumero);

		});
	}
	@Test
	public void calculadoraRestaNumberFormatExcepTest() throws CustomException {
		Assertions.assertThrows(CustomException.class,()->{
			BigDecimal primerNumero  = mock(BigDecimal.class);
			when(primerNumero.subtract(Mockito.any())).thenThrow(NumberFormatException.class);
			
			calculadora.resta(primerNumero, primerNumero);
		});
	}
	

}

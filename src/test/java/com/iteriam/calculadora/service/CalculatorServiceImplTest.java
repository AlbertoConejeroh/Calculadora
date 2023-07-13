package com.iteriam.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iteriam.calculadora.dto.ResultDTO;
import com.iteriam.calculadora.exception.CustomException;

 class CalculatorServiceImplTest {

	@InjectMocks
	 CalculatorService calculatorServiceImp;

	@BeforeEach
	 void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	 void calculaServiceSumaTest() throws CustomException {

		assertTrue(calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "suma").getResult()
				.compareTo(new ResultDTO(new BigDecimal("2")).getResult()) == 0);

	}

	@Test
	 void calculaServiceRestaTest() throws CustomException {

		assertTrue(calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "resta").getResult()
				.compareTo(new ResultDTO(new BigDecimal("0")).getResult()) == 0);

	}

	@Test
	 void calculaServiceOperacionNoPermitidaTest() throws CustomException {
		Assertions.assertThrows(CustomException.class, () -> {
			calculatorServiceImp.calculate(new BigDecimal("1"), new BigDecimal("1"), "multiplica");
		});
	}

}

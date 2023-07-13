package com.iteriam.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iteriam.calculadora.dto.ResultDTO;
import com.iteriam.calculadora.exception.CustomException;
import com.iteriam.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;

 class CalculatorControllerTest {

	@Mock
	CalculatorService calcService;
	
	
	@Mock
	TracerImpl tracer;
	

	@InjectMocks
	CalculatorController calcController;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void controllerTest() throws CustomException {

		when(calcService.calculate(new BigDecimal("1"), new BigDecimal("1"), "suma"))
				.thenReturn(new ResultDTO(new BigDecimal("2")));

		assertTrue(calcController.getResult(new BigDecimal("1"), new BigDecimal("1"), "suma").getBody().getResult()
				.compareTo(new ResultDTO(new BigDecimal("2")).getResult()) == 0);
	}

}

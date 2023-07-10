package com.iteriam.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.iteriam.calculadora.exception.CustomException;
import com.iteriam.calculadora.service.ICalculatorService;

@SpringBootTest

public class CalculatorControllerTest {

	@Mock
	private ICalculatorService iCalcService;

	@InjectMocks
	private CalculatorController calcController;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void controllerTest() throws CustomException {
		when(iCalcService.calculate(new BigDecimal("1".replace(",", ".")), new BigDecimal("1".replace(",", ".")), "suma"))
				.thenReturn(new BigDecimal("2"));

		assertTrue(calcController.getResult("1", "1", "suma").getBody().compareTo(new BigDecimal("2"))==0);
	}

	@Test
	public void controllerValidateParamsEmptyTest() throws CustomException {

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult("", "1", "suma");
		});
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult("1", "", "suma");
		});
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult(null, "1", "suma");
		});
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult("1", null, "suma");
		});

	}
	@Test
	public void controllerValidateParamsCharactersNotDigitTest() throws CustomException {

		Assertions.assertThrows(NumberFormatException.class, () -> {
			calcController.getResult("1a", "1", "suma");
		});
		Assertions.assertThrows(NumberFormatException.class, () -> {
			calcController.getResult("1", "1b", "suma");
		});
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult("a", "1b", "suma");
		});
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			calcController.getResult("1", "b", "suma");
		});

	}

}

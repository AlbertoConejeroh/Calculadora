package com.iteriam.calculadora.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iteriam.calculadora.dto.ResultDTO;
import com.iteriam.calculadora.exception.CustomException;
import com.iteriam.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The Class CalculatorController.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest/calculator/")
public class CalculatorController {

	/** The i calculator service. */
	@Autowired
	private CalculatorService calculatoService;

	@Autowired
	private TracerImpl tracer;

	/**
	 * Gets the result.
	 *
	 * @param firstNumber  the first number
	 * @param secondNumber the second number
	 * @param operation    the operation
	 * @return the result
	 */
	@GetMapping("calculate")
	public ResponseEntity<ResultDTO> getResult(@RequestParam(name = "firstNumber") @NotNull BigDecimal firstNumber,
			@RequestParam(name = "secondNumber") @NotNull BigDecimal secondNumber,
			@RequestParam(name = "operation") @NotBlank @NotNull String operation) {

		ResultDTO result = calculatoService.calculate(firstNumber, secondNumber, operation);
		tracer.trace(result.getResult());
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}

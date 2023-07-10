package com.iteriam.calculadora.controller;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iteriam.calculadora.exception.CustomException;
import com.iteriam.calculadora.service.ICalculatorService;

import io.corp.calculator.TracerImpl;


/**
 * The Class CalculatorController.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/calculator/")
public class CalculatorController {

	/** The i calculator service. */
	@Autowired
	private ICalculatorService iCalculatorService;

	/** The tracer. */
	private TracerImpl tracer = new TracerImpl();

	
	/**
	 * Gets the result.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @param operation the operation
	 * @return the result
	 */
	@GetMapping("calculate")
	public ResponseEntity<BigDecimal> getResult(@RequestParam(name = "firstNumber") String firstNumber,
			@RequestParam(name = "secondNumber") String secondNumber,
			@RequestParam(name = "operation") String operation) {
		try {
			validateNumbers(firstNumber, secondNumber);
			BigDecimal result = iCalculatorService.calculate(new BigDecimal(firstNumber.replace(",", ".")),
					new BigDecimal(secondNumber.replace(",", ".")), operation);
			tracer.trace(result);
			return new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
		} catch (CustomException cExcep) {
			tracer.trace(cExcep);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Error:" + cExcep.getCodError() + ". Description: " + cExcep.getError(), cExcep);
		}

	}

	/**
	 * Validate numbers.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @throws CustomException the custom exception
	 */
	private void validateNumbers(String firstNumber, String secondNumber) throws CustomException {
		Pattern pattern = Pattern.compile("[0-9]+");
		if ((firstNumber == null || firstNumber.isEmpty()) || (secondNumber == null || secondNumber.isEmpty())) {
			throw new CustomException("CALC0001", "Numbers cannot be empty");
		}

		if (!pattern.matcher(firstNumber).find() || !pattern.matcher(secondNumber).find()) {
			throw new CustomException("CALC0002",
					"The parameters firstNumber and secondNumber must not contain alphabetic characters");
		}

	}
}

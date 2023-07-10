package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.iteriam.calculadora.dto.Calculator;
import com.iteriam.calculadora.dto.Calculator.Operations;
import com.iteriam.calculadora.exception.CustomException;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class CalculatorServiceImp.
 */
@Service

/** The Constant log. */
@Slf4j
public class CalculatorServiceImp implements ICalculatorService {

	/**
	 * Calculate.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @param operation the operation
	 * @return the big decimal
	 * @throws CustomException the custom exception
	 */
	@Override
	public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operation)
			throws CustomException {

		Operations operations = Calculator.getOperation(operation);

		switch (operations) {
		case SUMA:
			return Calculator.add(firstNumber, secondNumber);
		case RESTA:
			return Calculator.subtract(firstNumber, secondNumber);
		default:
			log.error("Operation not supported");
			throw new CustomException("CALC0003","Operation not supported");

		}

	}

}

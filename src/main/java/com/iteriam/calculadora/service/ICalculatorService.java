package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import com.iteriam.calculadora.exception.CustomException;





/**
 * The Interface ICalculatorService.
 */
public interface ICalculatorService {

	/**
	 * Calculate.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @param operation the operation
	 * @return the big decimal
	 * @throws CustomException the custom exception
	 */
	public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operation) throws CustomException;
	
}

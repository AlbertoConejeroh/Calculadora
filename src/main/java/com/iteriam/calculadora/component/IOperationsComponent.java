package com.iteriam.calculadora.component;

import java.math.BigDecimal;

import com.iteriam.calculadora.exception.CustomException;


public interface IOperationsComponent {
	/**
	 * Calculate.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @param operation the operation
	 * @return the big decimal
	 * @throws CustomException the custom exception
	 */
	public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) throws CustomException;
	
}

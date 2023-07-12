package com.iteriam.calculadora.component;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;


/**
 * The Class OperationImplSuma.
 */
@Component
public class OperationImplSuma implements IOperationsComponent {

	/**
	 * Calculate.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @return the big decimal
	 */
	@Override
	public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber)
			{
		
		return firstNumber.add(secondNumber);
	}

}

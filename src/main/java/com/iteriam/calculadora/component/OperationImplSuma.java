package com.iteriam.calculadora.component;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.iteriam.calculadora.exception.CustomException;

@Component
public class OperationImplSuma implements IOperationsComponent {

	@Override
	public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber)
			throws CustomException {
		
		return firstNumber.add(secondNumber);
	}

}

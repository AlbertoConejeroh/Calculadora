package com.iteriam.calculadora.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.iteriam.calculadora.component.IOperationsComponent;
import com.iteriam.calculadora.dto.ResultDTO;
import com.iteriam.calculadora.exception.CustomException;

/**
 * The Class CalculatorServiceImp.
 */
@Service
public class CalculatorService {

	/**
	 * Calculate.
	 *
	 * @param firstNumber  the first number
	 * @param secondNumber the second number
	 * @param operation    the operation
	 * @return the big decimal
	 * @throws CustomException           the custom exception
	 */
	public ResultDTO calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operation)
			throws CustomException {

		IOperationsComponent operacion;
		try {
			operacion = (IOperationsComponent) Class.forName("com.iteriam.calculadora.component.OperationImpl"
					+ operation.substring(0, 1).toUpperCase() + operation.substring(1).toLowerCase()).getConstructor()
					.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new  CustomException("CALC0001", "Error to instantiate method");
		} catch (ClassNotFoundException e) {
			throw new  CustomException("CALC0002", "Error unavalible operation");
		}

		return new ResultDTO(operacion.calculate(firstNumber, secondNumber));

	}

}

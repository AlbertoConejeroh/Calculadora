package com.iteriam.calculadora.dto;

import java.math.BigDecimal;

import com.iteriam.calculadora.exception.CustomException;

import lombok.Data;


/**
 * Instantiates a new calculator.
 */
@Data
public class Calculator {

	/**
	 * The Enum Operations.
	 */
	public enum Operations {

		/** The suma. */
		SUMA("+"),
		/** The resta. */
		RESTA("-");

		/** The Constant valores. */
		private static final Operations[] valores = new Operations[] { SUMA, RESTA };

		/** The operation. */
		private String operation;

		/**
		 * Instantiates a new operations.
		 *
		 * @param operation the operation
		 */
		Operations(String operation) {
			this.operation = operation;
		}

		/**
		 * Gets the operation.
		 *
		 * @return the operation
		 */
		private String getOperation() {
			return this.operation;
		}

	}

	/**
	 * Gets the operation.
	 *
	 * @param typeOperation the type operation
	 * @return the operation
	 * @throws CustomException the custom exception
	 */
	public static Operations getOperation(String typeOperation) throws CustomException {

		for (int i = 0; i < Operations.valores.length; ++i) {
			Operations opActual = Operations.valores[i];
			if (typeOperation.equalsIgnoreCase(opActual.name())
					|| typeOperation.equalsIgnoreCase(opActual.getOperation())) {
				return opActual;
			}
		}

		StringBuilder operationsDisp = new StringBuilder();
		for (int i = 0; i < Operations.valores.length; ++i) {
			operationsDisp.append( Operations.valores[i].name() + " ");
		}

		throw new CustomException("CALC0003",
				"Operation not supported. The available operations are: " + operationsDisp.toString());

	}

	/**
	 * Adds the.
	 *
	 * @param firstNumber  the first number
	 * @param secondNumber the second number
	 * @return the big decimal
	 * @throws CustomException the custom exception
	 */
	public static BigDecimal add(BigDecimal firstNumber, BigDecimal secondNumber) throws CustomException {
		try {
			return firstNumber.add(secondNumber);
		} catch (NumberFormatException | ArithmeticException mathExcep) {
			throw new CustomException("CALC0004", "Error when performing the sum of the parameters: "
					+ firstNumber.toString() + " and " + secondNumber.toString());
		}

	}

	/**
	 * Subtract.
	 *
	 * @param firstNumber  the first number
	 * @param secondNumber the second number
	 * @return the big decimal
	 * @throws CustomException the custom exception
	 */
	public static BigDecimal subtract(BigDecimal firstNumber, BigDecimal secondNumber) throws CustomException {
		try {
			return firstNumber.subtract(secondNumber);
		} catch (NumberFormatException | ArithmeticException mathExcep) {
			throw new CustomException("CALC0005", "Error when subtracting the parameters: " + firstNumber.toString()
					+ " and " + secondNumber.toString());
		}

	}

}

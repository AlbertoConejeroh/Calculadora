package com.iteriam.calculadora.dto;

import java.math.BigDecimal;

import com.iteriam.calculadora.exception.CustomException;

import lombok.Data;

@Data
public class Calculadora {

	public enum Operations {
		SUMA("+"), RESTA("-");

		private static final Operations[] valores = new Operations[] { SUMA, RESTA };

		private String operation;

		Operations(String operation) {
			this.operation = operation;
		}

		private String getOperation() {
			return this.operation;
		}

	}

	public static Operations getOperation(String typeOperation) throws CustomException {

		for (int i = 0; i < Operations.valores.length; ++i) {
			Operations opActual = Operations.valores[i];
			if (typeOperation.equalsIgnoreCase(opActual.name())
					|| typeOperation.equalsIgnoreCase(opActual.getOperation())) {
				return opActual;
			}
		}

		String operationsDisp = "";
		for (int i = 0; i < Operations.valores.length; ++i) {
			operationsDisp += Operations.valores[i].name() + " ";
		}

		throw new CustomException("CALC0003",
				"Operation not supported. The available operations are: " + operationsDisp);

	}

	public static BigDecimal suma(BigDecimal primerNumero, BigDecimal segundoNumero) throws CustomException {
		try {
			return primerNumero.add(segundoNumero);
		} catch (NumberFormatException | ArithmeticException mathExcep) {
			throw new CustomException("CALC0004", "Error when performing the sum of the parameters: "
					+ primerNumero.toString() + " and " + segundoNumero.toString());
		}

	}

	public static BigDecimal resta(BigDecimal primerNumero, BigDecimal segundoNumero) throws CustomException {
		try {
			return primerNumero.subtract(segundoNumero);
		} catch (NumberFormatException | ArithmeticException mathExcep) {
			throw new CustomException("CALC0005", "Error when subtracting the parameters: " + primerNumero.toString()
					+ " and " + segundoNumero.toString());
		}

	}

}

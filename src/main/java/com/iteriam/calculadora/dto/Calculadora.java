package com.iteriam.calculadora.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Calculadora  {

	public enum Operations {
		SUMA("+"), RESTA("-"), MULTIPLICACION("*"), DIVISION("/");

		private static final Operations[] valores = new Operations[] { SUMA, RESTA };

		private String operation;

		Operations(String operation) {
			this.operation = operation;
		}

		private String getOperation() {
			return this.operation;
		}

	}

	public static Operations getOperation(String typeOperation) {

		for (int i = 0; i < Operations.valores.length; ++i) {
			Operations opActual = Operations.valores[i];
			if (typeOperation.equalsIgnoreCase(opActual.name())
					|| typeOperation.equalsIgnoreCase(opActual.getOperation())) {
				return opActual;
			}
		}

		throw new RuntimeException("Operación no soportada para el valor: " + typeOperation);
	}


	public static BigDecimal suma(BigDecimal primerNumero, BigDecimal segundoNumero) {

		return primerNumero.add(segundoNumero);

	}


	public static BigDecimal resta(BigDecimal primerNumero, BigDecimal segundoNumero) {

		return primerNumero.subtract(segundoNumero);

	}

}

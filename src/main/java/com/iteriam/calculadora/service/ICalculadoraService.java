package com.iteriam.calculadora.service;

import java.math.BigDecimal;




public interface ICalculadoraService {

	public BigDecimal calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion);
	
}

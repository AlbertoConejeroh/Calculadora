package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import com.iteriam.calculadora.exception.CustomException;




public interface ICalculadoraService {

	public BigDecimal calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion) throws CustomException;
	
}

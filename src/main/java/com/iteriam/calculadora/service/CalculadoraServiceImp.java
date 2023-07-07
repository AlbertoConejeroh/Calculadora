package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.iteriam.calculadora.dto.Calculadora;
import com.iteriam.calculadora.dto.Calculadora.Operations;
import com.iteriam.calculadora.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculadoraServiceImp implements ICalculadoraService {

	@Override
	public BigDecimal calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion)
			throws CustomException {

		Operations operation = Calculadora.getOperation(operacion);

		switch (operation) {
		case SUMA:
			return Calculadora.suma(primerNumero, segundoNumero);
		case RESTA:
			return Calculadora.resta(primerNumero, segundoNumero);
		default:
			log.error("Operation not supported");
			throw new CustomException("CALC0003","Operation not supported");

		}

	}

}

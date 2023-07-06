package com.iteriam.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.iteriam.calculadora.dto.Calculadora;
import com.iteriam.calculadora.dto.Calculadora.Operations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculadoraServiceImp implements ICalculadoraService {



	@Override
	public BigDecimal calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion) {

		Operations operation = Calculadora.getOperation(operacion);

		switch (operation) {
		case SUMA:
			return Calculadora.suma(primerNumero, segundoNumero);
		case RESTA:
			return Calculadora.resta(primerNumero, segundoNumero);
		default:
			System.out.println("Operacion no soportada");
			break;
		}

		return null;
	}

}

package com.iteriam.calculadora.controller;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iteriam.calculadora.exception.CustomException;
import com.iteriam.calculadora.service.ICalculadoraService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/calculadora/")
@Slf4j
public class CalculadoraController {

	@Autowired
	private ICalculadoraService iCalculadoraService;

	/**
	 * 
	 * @param @return @throws
	 */
	@GetMapping("calcula")
	public ResponseEntity<BigDecimal> getSimilarProducts(@RequestParam(name = "primerNumero") String primerNumero,
			@RequestParam(name = "segundoNumero") String segundoNumero,
			@RequestParam(name = "operacion") String operacion) {
		try {
			validaNumerosEntrada(primerNumero, segundoNumero);
			return new ResponseEntity<BigDecimal>(
					iCalculadoraService.calcula(new BigDecimal(primerNumero.replace(",", ".")),
							new BigDecimal(segundoNumero.replace(",", ".")), operacion),
					HttpStatus.OK);
		} catch (CustomException cExcep) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Error:" + cExcep.getCodError() + ". Description: " + cExcep.getError(), cExcep);
		}

	}

	private void validaNumerosEntrada(String primerNumero, String segundoNumero) throws CustomException {
		Pattern pattern = Pattern.compile("[0-9]+");
		if ((primerNumero == null || primerNumero.isEmpty()) || (segundoNumero == null || segundoNumero.isEmpty())) {
			throw new CustomException("CALC0001", "Numbers cannot be empty");
		}

		
			boolean isDigit = (!pattern.matcher(primerNumero).find() || !pattern.matcher(segundoNumero).find());

	}
}

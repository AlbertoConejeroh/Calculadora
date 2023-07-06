package com.iteriam.calculadora.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		} catch (Exception cExcep) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error:"+cExcep.getLocalizedMessage(), cExcep);
		}

	}

	private void validaNumerosEntrada(String primerNumero, String segundoNumero) {
		if ((primerNumero == null || primerNumero.isEmpty()) || (segundoNumero == null || segundoNumero.isEmpty())) {
			System.out.println("Error dato vacio");
		}
		if (!primerNumero.matches("[0-9]+") || !segundoNumero.matches("[0-9]+")) {
			System.out.println("Error dato no numerico");
		}
	}
}

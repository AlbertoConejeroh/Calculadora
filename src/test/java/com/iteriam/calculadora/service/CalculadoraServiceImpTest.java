package com.iteriam.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.iteriam.calculadora.controller.CalculadoraController;
import com.iteriam.calculadora.exception.CustomException;

@SpringBootTest

public class CalculadoraServiceImpTest {


	@InjectMocks
	private CalculadoraServiceImp calculadoraServiceImp;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void calculaServiceSumaTest() throws CustomException {
		
		calculadoraServiceImp.calcula(new BigDecimal("1"), new BigDecimal("1"), "suma");
		
	}
	@Test
	public void calculaServiceRestaTest() throws CustomException {
		
		calculadoraServiceImp.calcula(new BigDecimal("1"), new BigDecimal("1"), "resta");
		
	}
	
	@Test
	public void calculaServiceOperacionNoPermitidaTest() throws CustomException {
		Assertions.assertThrows(CustomException.class,()->{
		calculadoraServiceImp.calcula(new BigDecimal("1"), new BigDecimal("1"), "multiplica");
		});
	}

	


}

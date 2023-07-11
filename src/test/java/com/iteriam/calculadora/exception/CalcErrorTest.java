package com.iteriam.calculadora.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;



public class CalcErrorTest {

	@BeforeEach
	 void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	 void utilTest() throws CustomException {
		CalcError  calc = new CalcError(1,"error");
		calc = new CalcError(1,"error","");
		assertTrue(calc.getMessage().equalsIgnoreCase("error"));
		assertTrue(calc.getStatusCode() == 1);
		assertTrue(calc.getUriRequested().equalsIgnoreCase(""));
		
		
	}

	

}

package com.iteriam.calculadora.exception;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;



public class CustomExceptionTest {
	
	@InjectMocks
	 CustomException customExceptionMock;

	@BeforeEach
	 void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	 void utilsTest() throws CustomException {

		CustomException customException = new CustomException();
		CustomException customExceptionTwo = new CustomException();
		customException = new CustomException(customExceptionTwo);
		customException = new CustomException("1", "error");
		customException.setCodError("1");
		customException.setError("error");
		assertTrue(customException.getCodError().equalsIgnoreCase("1"));
		assertTrue(customException.getError().equalsIgnoreCase("error"));
		assertFalse(customException.equals(customExceptionTwo));
		assertTrue(customException.equals(customException));
		customExceptionTwo = customException;
		assertTrue(customException.equals(customExceptionTwo));
		assertFalse(customException.equals(null));
		customException.hashCode();
		customExceptionMock.equals(customException);
		customExceptionMock.equals(null);
		customExceptionMock.equals(customExceptionMock);
		
	}

}
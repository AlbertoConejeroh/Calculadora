package com.iteriam.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;


/**
 * The Class CalcErrorHandler.
 */
@ControllerAdvice
public class CalcErrorHandler {
	
	/**
	 * Method exception.
	 *
	 * @param request the request
	 * @param e the e
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CalcError> methodException(HttpServletRequest request, Exception e) {

		CalcError errorInfo = new CalcError(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}
}

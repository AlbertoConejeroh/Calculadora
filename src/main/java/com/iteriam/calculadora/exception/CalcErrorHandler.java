package com.iteriam.calculadora.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.corp.calculator.TracerImpl;
import jakarta.servlet.http.HttpServletRequest;


/**
 * The Class CalcErrorHandler.
 */
@ControllerAdvice
public class CalcErrorHandler {
	
	@Autowired
	private TracerImpl tracer;
	
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
		tracer.trace(errorInfo.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}
	
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CalcError> methodException(HttpServletRequest request, CustomException cExcep) {

		CalcError errorInfo = new CalcError(HttpStatus.BAD_REQUEST.value(), cExcep.getCodError() + " "+ cExcep.getError(),
				request.getRequestURI());
		tracer.trace(errorInfo.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}
}

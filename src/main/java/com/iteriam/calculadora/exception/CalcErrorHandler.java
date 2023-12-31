package com.iteriam.calculadora.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import io.corp.calculator.TracerImpl;
import jakarta.servlet.http.HttpServletRequest;


/**
 * The Class CalcErrorHandler.
 */
@ControllerAdvice
public class CalcErrorHandler{
	
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
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<CalcError> methodException(HttpServletRequest request, MissingServletRequestParameterException missingExcep) {

		CalcError errorInfo = new CalcError(HttpStatus.BAD_REQUEST.value(), missingExcep.getMessage(),
				request.getRequestURI());
		tracer.trace(errorInfo.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<CalcError> methodException(HttpServletRequest request, MethodArgumentTypeMismatchException argumentExcep) {

		CalcError errorInfo = new CalcError(HttpStatus.BAD_REQUEST.value(), "FirstNumber or SecondNumber cant be letter",
				request.getRequestURI());
		tracer.trace(errorInfo.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}

	
	
}

package com.iteriam.calculadora.exception;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class CustomException.
 *
 * @author Alberto Conejero Hernandez
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {

	/**
	 * Instantiates a new custom exception.
	 *
	 * @param cExcep the c excep
	 */

	public CustomException(CustomException cExcep) {
		this.codError = cExcep.getCodError();
		this.error = cExcep.getError();

	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Variable codError. */
	private String codError;
	
	/** Variable error. */
	private String error;

}

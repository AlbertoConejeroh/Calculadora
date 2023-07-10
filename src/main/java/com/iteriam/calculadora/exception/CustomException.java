package com.iteriam.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CustomException.
 *
 * @author Alberto Conejero Hernandez
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new custom exception.
 */
@NoArgsConstructor

/**
 * Instantiates a new custom exception.
 *
 * @param codError the cod error
 * @param error the error
 */
@AllArgsConstructor
public class CustomException extends Exception {

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

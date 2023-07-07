package com.iteriam.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Alberto Conejero Hernandez
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends Exception {

	/**
	 * 
	 */

	public CustomException(CustomException cExcep) {
		this.codError = cExcep.getCodError();
		this.error = cExcep.getError();

	}

	private static final long serialVersionUID = 1L;
	/**
	 * Variable codError
	 */
	private String codError;
	/**
	 * Variable error
	 */
	private String error;

}

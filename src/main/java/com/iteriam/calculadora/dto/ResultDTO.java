package com.iteriam.calculadora.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * The Class ResultDTO.
 *
 * @author Alberto Conejero Hernandez
 */

@Getter
@Setter

@AllArgsConstructor
public class ResultDTO {

	
	/** The result. */
	private BigDecimal result;
}

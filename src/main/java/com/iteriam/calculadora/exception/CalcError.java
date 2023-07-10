package com.iteriam.calculadora.exception;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class CalcError.
 */
public class CalcError {

	/** The message. */
	@JsonProperty("message")
	private String message;
	
	/** The status code. */
	@JsonProperty("status_code")
	private int statusCode;
	
	/** The uri requested. */
	@JsonProperty("uri")
	private String uriRequested;

	/**
	 * Instantiates a new calc error.
	 *
	 * @param statusCode the status code
	 * @param message the message
	 * @param uriRequested the uri requested
	 */
	public CalcError(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	/**
	 * Instantiates a new calc error.
	 *
	 * @param statusCode the status code
	 * @param message the message
	 */
	public CalcError(int statusCode, String message) {
		this.message = message;
		this.statusCode = statusCode;

	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the uri requested.
	 *
	 * @return the uri requested
	 */
	public String getUriRequested() {
		return uriRequested;
	}

}

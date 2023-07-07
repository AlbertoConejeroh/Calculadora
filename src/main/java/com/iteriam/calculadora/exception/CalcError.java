package com.iteriam.calculadora.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalcError {

	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;

	public CalcError(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public CalcError(int statusCode, String message) {
		this.message = message;
		this.statusCode = statusCode;

	}

	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

}

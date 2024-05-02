package com.exception;

public class InsufficientFundException extends Exception {
	private static final long serialVersionUID = 3986953233785278987L;
	private String message;

	public InsufficientFundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
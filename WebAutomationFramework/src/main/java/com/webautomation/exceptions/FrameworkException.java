package com.webautomation.exceptions;

public class FrameworkException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public FrameworkException(String message) {
		super(message);
	}
	
	public FrameworkException(String message,Throwable clause) {
		super(message, clause);
	}
	
}

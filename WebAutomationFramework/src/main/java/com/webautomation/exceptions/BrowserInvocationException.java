package com.webautomation.exceptions;

public class BrowserInvocationException extends FrameworkException {
	private static final long serialVersionUID = 1L;

	public BrowserInvocationException(String message) {
		super(message);
	}

	public BrowserInvocationException(String message, Throwable clause) {
		super(message, clause);
	}
}

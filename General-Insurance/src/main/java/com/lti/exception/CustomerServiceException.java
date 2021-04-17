package com.lti.exception;

public class CustomerServiceException extends RuntimeException {

	public CustomerServiceException() {
		super();
	}

	public CustomerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}

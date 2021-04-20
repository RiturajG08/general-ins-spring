package com.lti.exception;

public class RenewalServiceException extends RuntimeException{

	public RenewalServiceException() {
		super();
	}

	public RenewalServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RenewalServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RenewalServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RenewalServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}

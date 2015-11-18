package com.cooladata.dal.base.exceptions;

public class SystemValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String prefix = "SYSTEM VALIDATION ERROR: ";
	
	public SystemValidationException() {
		super();
	}

	public SystemValidationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(prefix + message, cause, enableSuppression, writableStackTrace);
	}

	public SystemValidationException(String message, Throwable cause) {
		super(prefix + message, cause);
	}

	public SystemValidationException(String message) {
		super(prefix + message);
	}
}

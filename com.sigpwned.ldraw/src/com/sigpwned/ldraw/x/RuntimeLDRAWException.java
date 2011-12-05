package com.sigpwned.ldraw.x;

public class RuntimeLDRAWException extends RuntimeException {
	private static final long serialVersionUID = -8843217954775419568L;

	public RuntimeLDRAWException(String message) {
		super(message);
	}

	public RuntimeLDRAWException(Exception cause) {
		super(cause);
	}

	public RuntimeLDRAWException(String message, Exception cause) {
		super(message, cause);
	}
}

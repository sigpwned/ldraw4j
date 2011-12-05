package com.sigpwned.ldraw.x;

public class LDRAWException extends Exception {
	private static final long serialVersionUID = 2362316273476261661L;

	public LDRAWException(String message) {
		super(message);
	}

	public LDRAWException(Exception cause) {
		super(cause);
	}

	public LDRAWException(String message, Exception cause) {
		super(message, cause);
	}
}

package com.sigpwned.ldraw4j.x;

public class InternalLDRAWException extends RuntimeLDRAWException {
	private static final long serialVersionUID = -5544318074295736654L;

	public InternalLDRAWException(String message) {
		super(message);
	}

	public InternalLDRAWException(Exception cause) {
		super(cause);
	}
}

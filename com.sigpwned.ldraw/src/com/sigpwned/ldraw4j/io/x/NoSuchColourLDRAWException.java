package com.sigpwned.ldraw4j.io.x;

import com.sigpwned.ldraw4j.x.LDRAWException;

public class NoSuchColourLDRAWException extends LDRAWException {
	private static final long serialVersionUID = -3430088313656354083L;

	public NoSuchColourLDRAWException(int code) {
		super("No such colour: "+code);
	}
}

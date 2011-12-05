package com.sigpwned.ldraw.model.colour.ref;

import com.sigpwned.ldraw.model.colour.ColourReference;

public class CodeColourReference extends ColourReference {
	private int code;
	
	public CodeColourReference(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public String toString() {
		return Integer.toString(getCode());
	}
}

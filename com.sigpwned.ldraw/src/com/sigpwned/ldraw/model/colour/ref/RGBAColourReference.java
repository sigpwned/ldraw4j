package com.sigpwned.ldraw.model.colour.ref;

import com.sigpwned.ldraw.model.colour.ColourReference;
import com.sigpwned.ldraw.model.colour.RGBA;

public class RGBAColourReference extends ColourReference {
	private RGBA value;
	
	public RGBAColourReference(RGBA value) {
		this.value = value;
	}
	
	public RGBA getValue() {
		return value;
	}
	
	public String toString() {
		return getValue().toString();
	}
}

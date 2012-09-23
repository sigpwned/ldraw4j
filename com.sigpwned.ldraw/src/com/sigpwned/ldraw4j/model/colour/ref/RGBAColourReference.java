package com.sigpwned.ldraw4j.model.colour.ref;

import com.sigpwned.ldraw4j.model.Colour;
import com.sigpwned.ldraw4j.model.colour.ColourReference;
import com.sigpwned.ldraw4j.model.colour.Colours;
import com.sigpwned.ldraw4j.model.colour.RGBA;

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

	public Colour eval(Colours colours, Colour currentColour) {
		return new Colour(getValue().getRGBString(), null, null, null, getValue(), getValue());
	}
}

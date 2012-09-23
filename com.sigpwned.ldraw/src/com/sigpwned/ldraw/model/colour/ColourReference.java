package com.sigpwned.ldraw.model.colour;

import com.sigpwned.ldraw.model.Colour;
import com.sigpwned.ldraw.model.colour.ref.CodeColourReference;
import com.sigpwned.ldraw.model.colour.ref.RGBAColourReference;

public abstract class ColourReference {
	public CodeColourReference asCode() {
		return (CodeColourReference) this;
	}

	public RGBAColourReference asRGBA() {
		return (RGBAColourReference) this;
	}
	
	public abstract Colour eval(Colours colours, Colour currentColour);
	
	public abstract String toString();
}

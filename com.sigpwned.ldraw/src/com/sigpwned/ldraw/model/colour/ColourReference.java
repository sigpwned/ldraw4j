package com.sigpwned.ldraw.model.colour;

import com.sigpwned.ldraw.model.colour.ref.CodeColourReference;
import com.sigpwned.ldraw.model.colour.ref.RGBAColourReference;

public abstract class ColourReference {
	public CodeColourReference asCode() {
		return (CodeColourReference) this;
	}

	public RGBAColourReference asRGBA() {
		return (RGBAColourReference) this;
	}
	
	public abstract String toString();
}

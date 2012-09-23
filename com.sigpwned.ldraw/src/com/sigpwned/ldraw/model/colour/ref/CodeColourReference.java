package com.sigpwned.ldraw.model.colour.ref;

import com.sigpwned.ldraw.model.Colour;
import com.sigpwned.ldraw.model.colour.ColourReference;
import com.sigpwned.ldraw.model.colour.Colours;

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

	public Colour eval(Colours colours, Colour currentColour) {
		Colour result;
		
		if(getCode() == 16) {
			// This is a "special" colour code that always maps back
			// to the "current colour," as defined in the topmost
			// subfile line. See the following page for details:
			// http://www.ldraw.org/reference/specs/colors.shtml
			result = currentColour;
		}
		else
			result = colours.getColour(getCode());
		
		return result;
	}
}

package com.sigpwned.ldraw4j.model.colour;

import java.util.Map;
import java.util.TreeMap;

import com.sigpwned.ldraw4j.model.Colour;

public class Colours {
	private Colour defaultColour;
	private Map<Integer,Colour> colours;
	
	public Colours(Colour defaultColour) {
		this.defaultColour = defaultColour;
		this.colours = new TreeMap<Integer,Colour>();
	}
	
	protected Map<Integer,Colour> getColours() {
		return colours;
	}
	
	public Colour getDefaultColour() {
		return defaultColour;
	}
	
	public Colour getColour(int code) {
		Colour result=getColours().get(code);
		if(result == null) {
			System.err.println("WARNING: No colour for code, using default: "+code);
			result = getDefaultColour();
		}
		return result;
	}
	
	public void defineColour(Colour colour) {
		if(colour.getCode() != null)
			getColours().put(colour.getCode(), colour);
		else
			System.err.println("WARNING: Could not define colour without code");
	}
}
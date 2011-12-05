package com.sigpwned.ldraw.model.colour;

public class Luminance {
	public int value;
	
	public Luminance(int value) {
		this.value = value & 0xFF;
	}
	
	public int getValue() {
		return value;
	}
}

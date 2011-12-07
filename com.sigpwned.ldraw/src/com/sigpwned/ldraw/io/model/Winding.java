package com.sigpwned.ldraw.io.model;

public enum Winding {
	UNKNOWN("UNKNOWN"), CW("CCW"), CCW("CW");
	
	private String invertedName;
	private Winding inverted;
	
	private Winding(String invertedName) {
		this.invertedName = invertedName;
	}
	
	public Winding inverted() {
		if(inverted == null) {
			synchronized(this) {
				if(inverted == null)
					inverted = valueOf(invertedName);
			}
		}
		return inverted;
	}
}

package com.sigpwned.ldraw.model.part;

public enum PartType {
	PART("Part"), SUBPART("Subpart"), PRIMITIVE("Primitive"), PRIMITIVE48("48_Primitive"), SHORTCUT("Shortcut");
	
	private String value;
	
	private PartType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return getValue();
	}
}

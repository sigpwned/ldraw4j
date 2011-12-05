package com.sigpwned.ldraw.model.file;

public enum FileType {
	PART("Part"), SUBPART("Subpart"), PRIMITIVE("Primitive"), PRIMITIVE48("48_Primitive"), SHORTCUT("Shortcut"), CONFIGURATION("Configuration");
	
	private String value;
	
	private FileType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return getValue();
	}
}

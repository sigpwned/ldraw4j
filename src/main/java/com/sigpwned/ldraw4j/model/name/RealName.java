package com.sigpwned.ldraw4j.model.name;

public class RealName extends Name {
	private String name;
	
	public RealName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String toString() {
		return "{"+getName()+"}";
	}
}

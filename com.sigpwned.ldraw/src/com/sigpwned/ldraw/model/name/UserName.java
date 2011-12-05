package com.sigpwned.ldraw.model.name;

public class UserName extends Name {
	private String name;
	
	public UserName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String toString() {
		return "["+getName()+"]";
	}
}

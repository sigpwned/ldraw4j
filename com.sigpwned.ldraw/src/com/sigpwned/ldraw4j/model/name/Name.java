package com.sigpwned.ldraw4j.model.name;

public abstract class Name {
	public RealName asRealName() {
		return (RealName) this;
	}
	
	public UserName asUserName() {
		return (UserName) this;
	}
	
	public abstract String toString();
}

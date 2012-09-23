package com.sigpwned.ldraw4j.model.colour.material;


public class CustomMaterial extends AbstractMaterial {
	private String params;
	
	public CustomMaterial(String params) {
		this.params = params;
	}
	
	public String getParams() {
		return params;
	}

	public String toString() {
		return "MATERIAL "+getParams();
	}
}

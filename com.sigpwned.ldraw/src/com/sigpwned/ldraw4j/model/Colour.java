package com.sigpwned.ldraw4j.model;

import com.sigpwned.ldraw4j.model.colour.Material;
import com.sigpwned.ldraw4j.model.colour.RGBA;

public class Colour {
	public static Colour defaultColour() {
		return new Colour("DEFAULT", null, null, null, RGBA.rgba(255, 0, 0, 255), RGBA.rgba(0, 0, 0, 255));
	}
	
	private String name;
	private Integer code;
	private Material material;
	private Integer luminance;
	private RGBA value;
	private RGBA edge;
	
	public Colour(String name, Integer code, Material material, Integer luminance, RGBA value, RGBA edge) {
		this.name = name;
		this.code = code;
		this.material = material;
		this.luminance = luminance;
		this.value = value;
		this.edge = edge;
	}

	public String getName() {
		return name;
	}

	public Integer getCode() {
		return code;
	}

	public Material getMaterial() {
		return material;
	}

	public Integer getLuminance() {
		return luminance;
	}

	public RGBA getValue() {
		return value;
	}

	public RGBA getEdge() {
		return edge;
	}
	
	public int hashCode() {
		return getValue()!=null ? getValue().hashCode() : 0;
	}
	
	public boolean equals(Object other) {
		boolean result;
		
		if(this == other)
			result = true;
		else
		if(other == null)
			result = false;
		else
		if(other instanceof Colour) {
			Colour otherp=(Colour) other;
			result = true;
			result = result && equal(getName(), otherp.getName());
			result = result && equal(getCode(), otherp.getCode());
			result = result && equal(getMaterial(), otherp.getMaterial());
			result = result && equal(getLuminance(), otherp.getLuminance());
			result = result && equal(getValue(), otherp.getValue());
			result = result && equal(getEdge(), otherp.getEdge());
		}
		else
			result = false;
		
		return result;
	}
	
	private static boolean equal(Object a, Object b) {
		return a==b || (a!=null && b!=null && a.equals(b));
	}
}

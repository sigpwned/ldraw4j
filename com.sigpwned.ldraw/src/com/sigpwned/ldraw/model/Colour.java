package com.sigpwned.ldraw.model;

import com.sigpwned.ldraw.model.colour.Material;
import com.sigpwned.ldraw.model.colour.RGBA;

public class Colour {
	private String name;
	private int code;
	private Material material;
	private Integer luminance;
	private RGBA value;
	private RGBA edge;
	
	public Colour(String name, int code, Material material, Integer luminance, RGBA value, RGBA edge) {
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

	public int getCode() {
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
}

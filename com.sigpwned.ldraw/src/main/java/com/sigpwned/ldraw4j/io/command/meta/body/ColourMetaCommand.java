package com.sigpwned.ldraw4j.io.command.meta.body;

import com.sigpwned.ldraw4j.model.colour.Material;
import com.sigpwned.ldraw4j.model.colour.RGBA;

public class ColourMetaCommand extends AbstractBodyMetaCommand {
	private String name;
	private int code;
	private RGBA value;
	private Integer luminance;
	private Material material;
	
	public ColourMetaCommand(String name, int code, RGBA value, Integer luminance, Material material) {
		this.name = name;
		this.code = code;
		this.value = value;
		this.luminance = luminance;
		this.material = material;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public RGBA getValue() {
		return value;
	}

	public Integer getLuminance() {
		return luminance;
	}

	public Material getMaterial() {
		return material;
	}
}

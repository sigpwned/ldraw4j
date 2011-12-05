package com.sigpwned.ldraw.io.command.meta.body;

import com.sigpwned.ldraw.model.colour.Luminance;
import com.sigpwned.ldraw.model.colour.Material;
import com.sigpwned.ldraw.model.colour.RGBA;

public class ColourMetaCommand extends AbstractBodyMetaCommand {
	private String name;
	private int code;
	private RGBA value;
	private Luminance luminance;
	private Material material;
	
	public ColourMetaCommand(String name, int code, RGBA value, Luminance luminance, Material material) {
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

	public Luminance getLuminance() {
		return luminance;
	}

	public Material getMaterial() {
		return material;
	}
}

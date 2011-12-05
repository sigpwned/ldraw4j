package com.sigpwned.ldraw.model.colour.material;

import com.sigpwned.ldraw.model.colour.Luminance;
import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.colour.material.size.Size;

public class GlitterMaterial extends AbstractMaterial {
	private RGBA value;
	private Luminance luminance;
	private float fraction;
	private float vfraction;
	private Size size;
	
	public GlitterMaterial(RGBA value, Luminance luminance, float fraction, float vfraction, Size size) {
		this.value = value;
		this.luminance = luminance;
		this.fraction = fraction;
		this.vfraction = vfraction;
		this.size = size;
	}

	public RGBA getValue() {
		return value;
	}

	public Luminance getLuminance() {
		return luminance;
	}

	public float getFraction() {
		return fraction;
	}

	public float getVfraction() {
		return vfraction;
	}

	public Size getSize() {
		return size;
	}
}

package com.sigpwned.ldraw.model.colour.material;

import com.sigpwned.ldraw.model.colour.Luminance;
import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.colour.material.size.Size;

public class SpeckleMaterial extends AbstractMaterial {
	private RGBA value;
	private Luminance luminance;
	private float fraction;
	private Size size;
	
	public SpeckleMaterial(RGBA value, Luminance luminance, float fraction, Size size) {
		this.value = value;
		this.luminance = luminance;
		this.fraction = fraction;
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

	public Size getSize() {
		return size;
	}
}

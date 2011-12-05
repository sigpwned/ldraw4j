package com.sigpwned.ldraw.model.colour.material;

import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.colour.material.size.Size;

public class GlitterMaterial extends AbstractMaterial {
	private RGBA value;
	private Integer luminance;
	private float fraction;
	private float vfraction;
	private Size size;
	
	public GlitterMaterial(RGBA value, Integer luminance, float fraction, float vfraction, Size size) {
		this.value = value;
		this.luminance = luminance;
		this.fraction = fraction;
		this.vfraction = vfraction;
		this.size = size;
	}

	public RGBA getValue() {
		return value;
	}

	public Integer getLuminance() {
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
	
	public String toString() {
		StringBuilder result=new StringBuilder();
		result.append("MATERIAL GLITTER VALUE ");
		result.append(getValue().getRGBString());
		if(getValue().isAlphaDefined())
			result.append(" ALPHA "+getValue().getAlpha());
		if(getLuminance() != null)
			result.append(" LUMINANCE "+getLuminance().intValue());
		result.append(" FRACTION "+getFraction());
		result.append(" VFRACTION "+getVfraction());
		result.append(" "+getSize());
		return result.toString();
	}
}

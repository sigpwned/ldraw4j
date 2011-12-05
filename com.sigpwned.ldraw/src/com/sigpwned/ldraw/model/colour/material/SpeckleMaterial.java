package com.sigpwned.ldraw.model.colour.material;

import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.colour.material.size.Size;

public class SpeckleMaterial extends AbstractMaterial {
	private RGBA value;
	private Integer luminance;
	private float fraction;
	private Size size;
	
	public SpeckleMaterial(RGBA value, Integer luminance, float fraction, Size size) {
		this.value = value;
		this.luminance = luminance;
		this.fraction = fraction;
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

	public Size getSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder result=new StringBuilder();
		result.append("MATERIAL SPECKLE VALUE ");
		result.append(getValue().getRGBString());
		if(getValue().isAlphaDefined())
			result.append(" ALPHA "+getValue().getAlpha());
		if(getLuminance() != null)
			result.append(" LUMINANCE "+getLuminance().intValue());
		result.append(" FRACTION "+getFraction());
		result.append(" "+getSize());
		return result.toString();
	}
}

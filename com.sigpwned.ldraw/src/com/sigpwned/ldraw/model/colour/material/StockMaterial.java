package com.sigpwned.ldraw.model.colour.material;

import com.sigpwned.ldraw.model.colour.Material;

public enum StockMaterial implements Material {
	CHROME, PEARLESCENT, RUBBER, MATTE_METALLIC, METAL;

	public CustomMaterial asCustom() {
		throw new ClassCastException();
	}

	public GlitterMaterial asGlitter() {
		throw new ClassCastException();
	}

	public SpeckleMaterial asSpeckle() {
		throw new ClassCastException();
	}

	public StockMaterial asStock() {
		return this;
	}
	
	public String toString() {
		return name();
	}
}

package com.sigpwned.ldraw4j.model.colour.material;

import com.sigpwned.ldraw4j.model.colour.Material;

public abstract class AbstractMaterial implements Material {
	public CustomMaterial asCustom() {
		return (CustomMaterial) this;
	}

	public GlitterMaterial asGlitter() {
		return (GlitterMaterial) this;
	}

	public SpeckleMaterial asSpeckle() {
		return (SpeckleMaterial) this;
	}

	public StockMaterial asStock() {
		throw new ClassCastException();
	}
	
	public abstract String toString();
}

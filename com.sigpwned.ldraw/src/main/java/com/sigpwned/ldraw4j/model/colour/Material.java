package com.sigpwned.ldraw4j.model.colour;

import com.sigpwned.ldraw4j.model.colour.material.CustomMaterial;
import com.sigpwned.ldraw4j.model.colour.material.GlitterMaterial;
import com.sigpwned.ldraw4j.model.colour.material.SpeckleMaterial;
import com.sigpwned.ldraw4j.model.colour.material.StockMaterial;

public interface Material {
	public CustomMaterial asCustom();
	
	public GlitterMaterial asGlitter();
	
	public SpeckleMaterial asSpeckle();
	
	public StockMaterial asStock();
}

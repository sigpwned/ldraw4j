package com.sigpwned.ldraw.io.model;

public class ModelState {
	private boolean clipping;
	private Winding winding;
	
	public ModelState() {
		this.clipping = true;
		this.winding  = Winding.UNKNOWN;
	}
	
	public Winding getWinding() {
		return winding;
	}
	
	public void setWinding(Winding winding) {
		this.winding = winding;
	}

	public boolean isClipping() {
		return clipping;
	}

	public void setClipping(boolean clipping) {
		this.clipping = clipping;
	}
}

package com.sigpwned.ldraw4j.io.model;

import com.sigpwned.ldraw4j.model.geometry.Matrix3f;
import com.sigpwned.ldraw4j.model.geometry.Point3f;

public class ModelState {
	private String name;
	private boolean clipping;
	private Winding winding;
	private Matrix3f rotation;
	private Point3f translation;
	
	public ModelState(String name) {
		this.name = name;
		this.clipping = true;
		this.winding  = Winding.CCW;
		this.rotation = Matrix3f.ident();
		this.translation = Point3f.zero();
	}
	
	public String getName() {
		return name;
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

	public Matrix3f getRotation() {
		return rotation;
	}

	public void setRotation(Matrix3f rotation) {
		this.rotation = rotation;
	}

	public Point3f getTranslation() {
		return translation;
	}

	public void setTranslation(Point3f translation) {
		this.translation = translation;
	}
}

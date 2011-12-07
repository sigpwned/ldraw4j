package com.sigpwned.ldraw.io.handle.model;

import com.sigpwned.ldraw.io.LDRAWModelReadHandler;
import com.sigpwned.ldraw.model.Colour;
import com.sigpwned.ldraw.model.geometry.Point3f;

public class AbstractLDRAWModelReadHandler implements LDRAWModelReadHandler {
	public void line(Colour colour, Point3f[] line) {
	}
	public void triangle(Colour colour, Point3f[] line) {
	}
	public void quadrilateral(Colour colour, Point3f[] line) {
	}
	public void optionalLine(Colour colour, Point3f[] line) {
	}
}

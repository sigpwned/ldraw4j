package com.sigpwned.ldraw.io;

import com.sigpwned.ldraw.io.model.ModelState;
import com.sigpwned.ldraw.model.Colour;
import com.sigpwned.ldraw.model.geometry.Point3f;

public interface LDRAWModelReadHandler {
	public void clipping(ModelState state);
	
	public void winding(ModelState state);
	
	public void line(ModelState modelState, Colour colour, Point3f[] line);

	public void triangle(ModelState modelState, Colour colour, Point3f[] line);

	public void quadrilateral(ModelState modelState, Colour colour, Point3f[] line);

	public void optionalLine(ModelState modelState, Colour colour, Point3f[] line, Point3f[] controlPoints);
	
	public void enterFile(String name);

	public void leaveFile(String name);
}

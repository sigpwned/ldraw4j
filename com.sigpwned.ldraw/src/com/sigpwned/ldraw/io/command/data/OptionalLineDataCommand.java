package com.sigpwned.ldraw.io.command.data;

import com.sigpwned.ldraw.model.geometry.Point3f;

public class OptionalLineDataCommand extends AbstractDataCommand {
	private int colour;
	private Point3f[] vertices;
	
	public OptionalLineDataCommand(int colour, Point3f[] vertices) {
		if(vertices.length != 4)
			throw new IllegalArgumentException("Argument `vertices' must have length 4, not "+vertices.length);
		this.colour = colour;
		this.vertices = vertices;
	}

	public int getColour() {
		return colour;
	}

	public Point3f[] getVertices() {
		return vertices;
	}
}

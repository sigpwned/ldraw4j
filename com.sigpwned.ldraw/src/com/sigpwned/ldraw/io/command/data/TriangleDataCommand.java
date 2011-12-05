package com.sigpwned.ldraw.io.command.data;

import com.sigpwned.ldraw.model.geometry.Point3f;

public class TriangleDataCommand extends AbstractDataCommand {
	private int colour;
	private Point3f[] vertices;
	
	public TriangleDataCommand(int colour, Point3f[] vertices) {
		if(vertices.length != 3)
			throw new IllegalArgumentException("Argument `vertices' must have length 3, not "+vertices.length);
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

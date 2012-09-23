package com.sigpwned.ldraw4j.io.command.data;

import com.sigpwned.ldraw4j.model.geometry.Point3f;

public class QuadrilateralDataCommand extends AbstractDataCommand {
	private int colour;
	private Point3f[] vertices;
	
	public QuadrilateralDataCommand(int colour, Point3f[] vertices) {
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

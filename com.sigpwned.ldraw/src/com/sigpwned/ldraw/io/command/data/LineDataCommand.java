package com.sigpwned.ldraw.io.command.data;

import com.sigpwned.ldraw.model.geometry.Point3f;

public class LineDataCommand extends AbstractDataCommand {
	private int colour;
	private Point3f p1;
	private Point3f p2;
	
	public LineDataCommand(int colour, Point3f p1, Point3f p2) {
		this.colour = colour;
		this.p1 = p1;
		this.p2 = p2;
	}

	public int getColour() {
		return colour;
	}

	public Point3f getP1() {
		return p1;
	}

	public Point3f getP2() {
		return p2;
	}
}

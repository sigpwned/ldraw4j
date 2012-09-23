package com.sigpwned.ldraw4j.io.command.data;

import com.sigpwned.ldraw4j.model.geometry.Matrix3f;
import com.sigpwned.ldraw4j.model.geometry.Point3f;


public class SubFileDataCommand extends AbstractDataCommand {
	private int color;
	private Point3f location;
	private Matrix3f rotation;
	private String file;
	
	public SubFileDataCommand(int color, Point3f location, Matrix3f rotation, String file) {
		this.color = color;
		this.location = location;
		this.rotation = rotation;
		this.file = file;
	}

	public int getColor() {
		return color;
	}

	public Point3f getLocation() {
		return location;
	}

	public Matrix3f getRotation() {
		return rotation;
	}

	public String getFile() {
		return file;
	}
}

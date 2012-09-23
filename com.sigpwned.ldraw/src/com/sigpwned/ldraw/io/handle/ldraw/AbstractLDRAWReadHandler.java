package com.sigpwned.ldraw.io.handle.ldraw;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.sigpwned.ldraw.io.LDRAWReadHandler;
import com.sigpwned.ldraw.model.colour.ColourReference;
import com.sigpwned.ldraw.model.colour.Material;
import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.file.FileType;
import com.sigpwned.ldraw.model.file.FileVersion;
import com.sigpwned.ldraw.model.geometry.Matrix3f;
import com.sigpwned.ldraw.model.geometry.Point3f;
import com.sigpwned.ldraw.model.name.Name;
import com.sigpwned.ldraw.model.name.RealName;
import com.sigpwned.ldraw.model.name.UserName;
import com.sigpwned.ldraw.model.winding.BFC;
import com.sigpwned.ldraw.x.LDRAWException;

public abstract class AbstractLDRAWReadHandler implements LDRAWReadHandler {
	public void partDescription(String description) throws LDRAWException {
	}
	public void name(String filename) throws LDRAWException {
	}
	public void author(RealName realName, UserName userName) throws LDRAWException {
	}
	public void ldraworg(FileType partType, String qualifiers, FileVersion version) throws LDRAWException {
	}
	public void license(String licenseStatement, boolean redistributable) throws LDRAWException {
	}
	public void bfc(BFC bfc) throws LDRAWException {
	}
	public void history(Date date, Name name, String message) throws LDRAWException {
	}
	public void category(String category) throws LDRAWException {
	}
	public void commandLine(String commandLine) throws LDRAWException {
	}
	public void keywords(List<String> keywords) throws LDRAWException {
	}
	public void help(String message) throws LDRAWException {
	}
	public void clear() throws LDRAWException {
	}
	public void colour(String name, int code, RGBA value, ColourReference edge, Integer luminance, Material material) throws LDRAWException {
	}
	public void pause() throws LDRAWException {
	}
	public void print(String message) throws LDRAWException {
	}
	public void save() throws LDRAWException {
	}
	public void step() throws LDRAWException {
	}
	public void write(String message) throws LDRAWException {
	}
	public void meta(String line) throws LDRAWException {
	}
	public void subfile(ColourReference colour, Point3f location, Matrix3f rotation, String file) throws IOException, LDRAWException {
	}
	public void line(ColourReference colour, Point3f[] line) throws LDRAWException {
	}
	public void triangle(ColourReference colour, Point3f[] triangle) throws LDRAWException {
	}
	public void quadrilateral(ColourReference colour, Point3f[] quad) throws LDRAWException {
	}
	public void optionalLine(ColourReference colour, Point3f[] line, Point3f[] controlPoints) throws LDRAWException {
	}
	public void comment(String comment) throws LDRAWException {
	}
}

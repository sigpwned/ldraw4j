package com.sigpwned.ldraw.io;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

/**
 * Process a file in LDRAW format. The file format is documented pretty well on
 * <a href="http://www.ldraw.org/Article218.html">the LDRAW website</a>.
 */
public interface LDRAWReadHandler {
	///////////////////////////////////////////////////////////////////////////
	// HEADER META COMMANDS ///////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public void author(RealName realName, UserName userName) throws LDRAWException;
	
	public void bfc(BFC bfc) throws LDRAWException;
	
	public void category(String category) throws LDRAWException;
	
	public void commandLine(String commandLine) throws LDRAWException;
	
	public void help(String message) throws LDRAWException;
	
	public void history(Date date, Name name, String message) throws LDRAWException;
	
	public void keywords(List<String> keywords) throws LDRAWException;
	
	public void ldraworg(FileType partType, String qualifiers, FileVersion partVersion) throws LDRAWException;
	
	public void license(String licenseStatement, boolean redistributable) throws LDRAWException;

	public void name(String filename) throws LDRAWException;
	
	public void partDescription(String description) throws LDRAWException;

	///////////////////////////////////////////////////////////////////////////
	// BODY META COMMANDS /////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public void clear() throws LDRAWException;
	
	public void colour(String name, int code, RGBA value, ColourReference edge, Integer luminance, Material material) throws LDRAWException;
	
	public void pause() throws LDRAWException;
	
	public void print(String message) throws LDRAWException;
	
	public void save() throws LDRAWException;

	public void step() throws LDRAWException;
	
	public void write(String message) throws LDRAWException;
	
	///////////////////////////////////////////////////////////////////////////
	// OTHER META COMMANDS ////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public void meta(String line) throws LDRAWException;
	
	///////////////////////////////////////////////////////////////////////////
	// MODEL //////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public void subfile(int colour, Point3f location, Matrix3f rotation, String file) throws IOException, LDRAWException;
	
	public void line(int colour, Point3f[] line) throws LDRAWException;
	
	public void triangle(int colour, Point3f[] triangle) throws LDRAWException;

	public void quadrilateral(int colour, Point3f[] quad) throws LDRAWException;
	
	public void optionalLine(int colour, Point3f[] line, Point3f[] control) throws LDRAWException;

	///////////////////////////////////////////////////////////////////////////
	// OTHER //////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public void comment(String comment) throws LDRAWException;
}

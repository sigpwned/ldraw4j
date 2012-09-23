// Copyright 2012 Andy Boothe
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.sigpwned.ldraw4j.io.handle.ldraw;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.sigpwned.ldraw4j.io.LDRAWReadHandler;
import com.sigpwned.ldraw4j.model.colour.ColourReference;
import com.sigpwned.ldraw4j.model.colour.Material;
import com.sigpwned.ldraw4j.model.colour.RGBA;
import com.sigpwned.ldraw4j.model.file.FileType;
import com.sigpwned.ldraw4j.model.file.FileVersion;
import com.sigpwned.ldraw4j.model.geometry.Matrix3f;
import com.sigpwned.ldraw4j.model.geometry.Point3f;
import com.sigpwned.ldraw4j.model.name.Name;
import com.sigpwned.ldraw4j.model.name.RealName;
import com.sigpwned.ldraw4j.model.name.UserName;
import com.sigpwned.ldraw4j.model.winding.BFC;
import com.sigpwned.ldraw4j.x.LDRAWException;

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

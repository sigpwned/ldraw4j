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

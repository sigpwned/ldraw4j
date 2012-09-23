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

import com.sigpwned.ldraw4j.model.geometry.Point3f;

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

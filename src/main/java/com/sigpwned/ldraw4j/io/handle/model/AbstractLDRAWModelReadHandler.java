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
package com.sigpwned.ldraw4j.io.handle.model;

import com.sigpwned.ldraw4j.io.LDRAWModelReadHandler;
import com.sigpwned.ldraw4j.io.model.ModelState;
import com.sigpwned.ldraw4j.model.Colour;
import com.sigpwned.ldraw4j.model.geometry.Point3f;

public class AbstractLDRAWModelReadHandler implements LDRAWModelReadHandler {
	public void line(ModelState modelState, Colour colour, Point3f[] line) {
	}
	public void triangle(ModelState modelState, Colour colour, Point3f[] line) {
	}
	public void quadrilateral(ModelState modelState, Colour colour, Point3f[] line) {
	}
	public void optionalLine(ModelState modelState, Colour colour, Point3f[] line, Point3f[] controlPoints) {
	}
	public void clipping(ModelState state) {
	}
	public void winding(ModelState state) {
	}
	public void enterFile(String name) {
	}
	public void leaveFile(String name) {
	}
	public void meta(String line) {
	}
}

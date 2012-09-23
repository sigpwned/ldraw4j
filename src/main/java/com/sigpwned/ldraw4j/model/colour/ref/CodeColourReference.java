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
package com.sigpwned.ldraw4j.model.colour.ref;

import com.sigpwned.ldraw4j.model.Colour;
import com.sigpwned.ldraw4j.model.colour.ColourReference;
import com.sigpwned.ldraw4j.model.colour.Colours;

public class CodeColourReference extends ColourReference {
	private int code;
	
	public CodeColourReference(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public String toString() {
		return Integer.toString(getCode());
	}

	public Colour eval(Colours colours, Colour currentColour) {
		Colour result;
		
		if(getCode() == 16) {
			// This is a "special" colour code that always maps back
			// to the "current colour," as defined in the topmost
			// subfile line. See the following page for details:
			// http://www.ldraw.org/reference/specs/colors.shtml
			result = currentColour;
		}
		else
			result = colours.getColour(getCode());
		
		return result;
	}
}

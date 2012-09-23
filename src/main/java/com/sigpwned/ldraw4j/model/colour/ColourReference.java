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
package com.sigpwned.ldraw4j.model.colour;

import com.sigpwned.ldraw4j.model.Colour;
import com.sigpwned.ldraw4j.model.colour.ref.CodeColourReference;
import com.sigpwned.ldraw4j.model.colour.ref.RGBAColourReference;

public abstract class ColourReference {
	public CodeColourReference asCode() {
		return (CodeColourReference) this;
	}

	public RGBAColourReference asRGBA() {
		return (RGBAColourReference) this;
	}
	
	public abstract Colour eval(Colours colours, Colour currentColour);
	
	public abstract String toString();
}

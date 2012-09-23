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
package com.sigpwned.ldraw4j.model.colour.material;

import com.sigpwned.ldraw4j.model.colour.RGBA;
import com.sigpwned.ldraw4j.model.colour.material.size.Size;

public class SpeckleMaterial extends AbstractMaterial {
	private RGBA value;
	private Integer luminance;
	private float fraction;
	private Size size;
	
	public SpeckleMaterial(RGBA value, Integer luminance, float fraction, Size size) {
		this.value = value;
		this.luminance = luminance;
		this.fraction = fraction;
		this.size = size;
	}

	public RGBA getValue() {
		return value;
	}

	public Integer getLuminance() {
		return luminance;
	}

	public float getFraction() {
		return fraction;
	}

	public Size getSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder result=new StringBuilder();
		result.append("MATERIAL SPECKLE VALUE ");
		result.append(getValue().getRGBString());
		if(getValue().isAlphaDefined())
			result.append(" ALPHA "+getValue().getAlpha());
		if(getLuminance() != null)
			result.append(" LUMINANCE "+getLuminance().intValue());
		result.append(" FRACTION "+getFraction());
		result.append(" "+getSize());
		return result.toString();
	}
}

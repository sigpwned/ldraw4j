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

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class RGBA {
	private static final Map<Integer,RGBA> palette=new HashMap<Integer,RGBA>();
	
	public static RGBA rgba(int red, int green, int blue, int alpha) {
		int rgba=0;
		rgba = rgba | ((alpha & 0xFF) << 24);
		rgba = rgba | ((red   & 0xFF) << 16);
		rgba = rgba | ((green & 0xFF) <<  8);
		rgba = rgba | ((blue  & 0xFF) <<  0);
		
		Integer lookup=Integer.valueOf(rgba);
		
		RGBA result=palette.get(lookup);
		if(result == null)
			palette.put(lookup, result = new RGBA(rgba));
		
		return result;
	}
	
	private int rgba;
	
	private RGBA(int rgba) {
		this.rgba = rgba;
	}
	
	public int getRed() {
		return (rgba & 0x00FF0000) >>> 16;
	}
	
	public int getGreen() {
		return (rgba & 0x0000FF00) >>>  8;
	}
	
	public int getBlue() {
		return (rgba & 0x000000FF) >>>  0;
	}
	
	public int getAlpha() {
		return (rgba & 0xFF000000) >>>  24;
	}
	
	public Color toColor() {
		return new Color(getRed(), getBlue(), getGreen(), getAlpha());
	}
	
	public String toString() {
		return getRGBString();
	}
	
	public String getRGBString() {
		StringBuilder result=new StringBuilder();
		result.append("#");
		if(getRed() < 16) result.append("0");
		result.append(Integer.toString(getRed(), 16));
		if(getGreen() < 16) result.append("0");
		result.append(Integer.toString(getGreen(), 16));
		if(getBlue() < 16) result.append("0");
		result.append(Integer.toString(getBlue(), 16));
		return result.toString();
	}
	
	public boolean isAlphaDefined() {
		return getAlpha() != 255;
	}
	
	public int hashCode() {
		return rgba;
	}
	
	public boolean equals(Object other) {
		boolean result;
		
		if(this == other)
			result = true;
		else
		if(other == null)
			result = false;
		else
		if(other instanceof RGBA) {
			RGBA otherp=(RGBA) other;
			result = true;
			result = result && getRed()==otherp.getRed();
			result = result && getGreen()==otherp.getGreen();
			result = result && getBlue()==otherp.getBlue();
			result = result && getAlpha()==otherp.getAlpha();
		}
		else
			result = false;
		
		return result;
	}
}

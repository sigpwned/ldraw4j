package com.sigpwned.ldraw.model.geometry;

import com.sigpwned.ldraw.util.StringUtil;


public class Point3f {
	private float[] xyz;
	
	public Point3f(float[] xyz) {
		this.xyz = xyz;
	}
	
	public float get(int i) {
		return xyz[i];
	}

	public float x() {
		return get(0);
	}

	public float y() {
		return get(1);
	}

	public float z() {
		return get(2);
	}
	
	public String toString() {
		StringBuilder result=new StringBuilder();
		for(int i=0;i<xyz.length;i++) {
			if(result.length() != 0) result.append(" ");
			result.append(StringUtil.f(get(i)));
		}
		return result.toString();
	}
}

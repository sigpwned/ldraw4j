package com.sigpwned.ldraw4j.model.geometry;

import com.sigpwned.ldraw4j.util.StringUtil;


public class Point3f {
	public static Point3f zero() {
		return new Point3f(new float[] {
			0.0f, 0.0f, 0.0f
		});
	}
	
	private float[] xyz;
	
	public Point3f(float[] xyz) {
		this.xyz = xyz;
	}
	
	public float[] get() {
		return xyz;
	}
	
	public float get(int i) {
		return get()[i];
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
	
	public Point3f add(Point3f o) {
		float[] result=new float[3];
		for(int i=0;i<3;i++)
			result[i] = get(i)+o.get(i);
		return new Point3f(result);
	}
	
	public Point3f sub(Point3f o) {
		float[] result=new float[3];
		for(int i=0;i<3;i++)
			result[i] = get(i)-o.get(i);
		return new Point3f(result);		
	}
}

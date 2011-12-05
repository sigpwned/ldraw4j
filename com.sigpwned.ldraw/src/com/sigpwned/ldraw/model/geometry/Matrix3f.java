package com.sigpwned.ldraw.model.geometry;

import com.sigpwned.ldraw.util.StringUtil;

public class Matrix3f {
	public float[][] data;
	
	public Matrix3f(float[][] data) {
		if(data.length != 3)
			throw new IllegalArgumentException("Matrix3f data must have 3 rows");
		for(int row=0;row<data.length;row++)
			if(data[row].length != 3)
				throw new IllegalArgumentException("Matrix3f row "+row+" must have 3 columns");
		this.data = data;
	}
	
	public float[] get(int row) {
		return data[row];
	}
	
	public float get(int row, int col) {
		return data[row][col];
	}

	public String toString() {
		StringBuilder result=new StringBuilder();
		for(int row=0;row<data.length;row++)
			for(int col=0;col<data[row].length;col++) {
				if(result.length() != 0) result.append(" ");
				result.append(StringUtil.f(get(row, col)));
			}
		return result.toString();
	}
}

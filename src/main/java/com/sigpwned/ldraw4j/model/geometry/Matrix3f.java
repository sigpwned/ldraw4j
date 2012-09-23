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
package com.sigpwned.ldraw4j.model.geometry;

import com.sigpwned.ldraw4j.util.StringUtil;

public class Matrix3f {
	public static Matrix3f ident() {
		return new Matrix3f(new float[][] {
			{ 1.0f, 0.0f, 0.0f },
			{ 0.0f, 1.0f, 0.0f },
			{ 0.0f, 0.0f, 1.0f }
		});
	}

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
				if(!result.equals("")) result.append(" ");
				result.append(StringUtil.f(get(row, col)));
			}
		return result.toString();
	}
	
	public Matrix3f mul(Matrix3f o) {
		float[][] result=new float[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				result[i][j] = 0.0f;
				for(int a=0;a<3;a++)
					result[i][j] = result[i][j]+get(i, a)*o.get(a, j);
			}
		return new Matrix3f(result);
	}

	public Point3f mul(Point3f o) {
		float[] result=new float[3];
		for(int i=0;i<3;i++) {
			result[i] = 0.0f;
			for(int a=0;a<3;a++)
				result[i] = result[i]+get(i, a)*o.get(a);
		}
		return new Point3f(result);
	}
	
	public static void main(String[] args) {
		try {
			Matrix3f a=new Matrix3f(new float[][] {
				{ 1.0f, 2.0f, 3.0f },
				{ 4.0f, 5.0f, 6.0f },
				{ 7.0f, 8.0f, 9.0f }
			});
			System.out.println(a);
			
			System.out.println(a.mul(new Point3f(new float[] {
				1.0f, 2.0f, 3.0f
			})));
			
			System.out.println(a.mul(a));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

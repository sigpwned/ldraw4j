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
package com.sigpwned.ldraw4j.model.colour.material.size;

public class MinMaxSize extends AbstractSize {
	private int minSize;
	private int maxSize;
	
	public MinMaxSize(int minSize, int maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}
	
	public int getMinSize() {
		return minSize;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public String toString() {
		return "MINSIZE "+getMinSize()+" MAXSIZE "+getMaxSize();
	}
}

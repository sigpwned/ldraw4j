package com.sigpwned.ldraw.model.colour.material.size;

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

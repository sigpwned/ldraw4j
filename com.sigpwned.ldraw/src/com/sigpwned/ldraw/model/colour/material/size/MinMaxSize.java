package com.sigpwned.ldraw.model.colour.material.size;

public class MinMaxSize extends AbstractSize {
	private int minValue;
	private int maxValue;
	
	public MinMaxSize(int minValue, int maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	public int getMinValue() {
		return minValue;
	}
	
	public int getMaxValue() {
		return maxValue;
	}
}

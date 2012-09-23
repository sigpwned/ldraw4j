package com.sigpwned.ldraw4j.model.colour.material.size;

public class SingleSize extends AbstractSize {
	private int size;
	
	public SingleSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		return "SIZE "+getSize();
	}
}

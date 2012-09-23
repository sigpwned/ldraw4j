package com.sigpwned.ldraw4j.model.colour.material.size;

public abstract class AbstractSize implements Size {
	public SingleSize asSingle() {
		return (SingleSize) this;
	}

	public MinMaxSize asMinMax() {
		return (MinMaxSize) this;
	}

	public abstract String toString();
}

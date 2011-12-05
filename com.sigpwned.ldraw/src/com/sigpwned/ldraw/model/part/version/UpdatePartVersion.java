package com.sigpwned.ldraw.model.part.version;

import com.sigpwned.ldraw.model.part.PartVersion;

public class UpdatePartVersion extends PartVersion {
	private int year;
	private int release;
	
	public UpdatePartVersion(int year, int release) {
		this.year = year;
		this.release = release;
	}

	public int getYear() {
		return year;
	}

	public int getRelease() {
		return release;
	}

	public String toString() {
		return String.format(
			"UPDATED %04d-%02d",
			getYear(),
			getRelease()
		);
	}
}

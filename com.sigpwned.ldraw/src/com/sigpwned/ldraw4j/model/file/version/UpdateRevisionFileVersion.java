package com.sigpwned.ldraw4j.model.file.version;

import com.sigpwned.ldraw4j.model.file.FileVersion;

public class UpdateRevisionFileVersion extends FileVersion {
	private int year;
	private int release;
	
	public UpdateRevisionFileVersion(int year, int release) {
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

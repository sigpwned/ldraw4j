package com.sigpwned.ldraw4j.model.file.version;

import com.sigpwned.ldraw4j.model.file.FileVersion;

public class OriginalFileVersion extends FileVersion {
	public static final OriginalFileVersion INSTANCE=new OriginalFileVersion();
	public static OriginalFileVersion getInstance() {
		return INSTANCE;
	}
	
	private OriginalFileVersion() {
	}

	public String toString() {
		return "ORIGINAL";
	}
}

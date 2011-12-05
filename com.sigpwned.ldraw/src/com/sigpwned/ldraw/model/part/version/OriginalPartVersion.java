package com.sigpwned.ldraw.model.part.version;

import com.sigpwned.ldraw.model.part.PartVersion;

public class OriginalPartVersion extends PartVersion {
	public static final OriginalPartVersion INSTANCE=new OriginalPartVersion();
	public static OriginalPartVersion getInstance() {
		return INSTANCE;
	}
	
	private OriginalPartVersion() {
	}

	public String toString() {
		return "ORIGINAL";
	}
}

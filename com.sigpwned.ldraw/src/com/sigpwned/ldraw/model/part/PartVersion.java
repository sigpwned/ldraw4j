package com.sigpwned.ldraw.model.part;

import com.sigpwned.ldraw.model.part.version.OriginalPartVersion;
import com.sigpwned.ldraw.model.part.version.UpdatePartVersion;

public abstract class PartVersion {
	public OriginalPartVersion asOriginal() {
		return (OriginalPartVersion) this;
	}

	public UpdatePartVersion asUpdate() {
		return (UpdatePartVersion) this;
	}
	
	public abstract String toString();
}

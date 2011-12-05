package com.sigpwned.ldraw.model.file;

import com.sigpwned.ldraw.model.file.version.OriginalFileVersion;
import com.sigpwned.ldraw.model.file.version.UpdateRevisionFileVersion;

public abstract class FileVersion {
	public OriginalFileVersion asOriginal() {
		return (OriginalFileVersion) this;
	}

	public UpdateRevisionFileVersion asUpdate() {
		return (UpdateRevisionFileVersion) this;
	}
	
	public abstract String toString();
}

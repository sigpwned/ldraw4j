package com.sigpwned.ldraw.io.command.meta.header;

import com.sigpwned.ldraw.model.file.FileType;
import com.sigpwned.ldraw.model.file.FileVersion;

public class LDRAWORGMetaCommand extends AbstractHeaderMetaCommand {
	private FileType partType;
	private String qualifiers;
	private FileVersion partVersion;
	
	public LDRAWORGMetaCommand(FileType partType, String qualifiers, FileVersion partVersion) {
		this.partType = partType;
		this.qualifiers = qualifiers;
		this.partVersion = partVersion;
	}

	public FileType getPartType() {
		return partType;
	}

	public String getQualifiers() {
		return qualifiers;
	}

	public FileVersion getPartVersion() {
		return partVersion;
	}
}

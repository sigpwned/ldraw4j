package com.sigpwned.ldraw.io.command.meta.header;

import com.sigpwned.ldraw.model.part.PartType;
import com.sigpwned.ldraw.model.part.PartVersion;

public class LDRAWORGMetaCommand extends AbstractHeaderMetaCommand {
	private PartType partType;
	private String qualifiers;
	private PartVersion partVersion;
	
	public LDRAWORGMetaCommand(PartType partType, String qualifiers, PartVersion partVersion) {
		this.partType = partType;
		this.qualifiers = qualifiers;
		this.partVersion = partVersion;
	}

	public PartType getPartType() {
		return partType;
	}

	public String getQualifiers() {
		return qualifiers;
	}

	public PartVersion getPartVersion() {
		return partVersion;
	}
}

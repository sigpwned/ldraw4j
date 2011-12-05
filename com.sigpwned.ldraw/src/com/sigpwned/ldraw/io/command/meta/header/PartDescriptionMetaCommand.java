package com.sigpwned.ldraw.io.command.meta.header;


public class PartDescriptionMetaCommand extends AbstractHeaderMetaCommand {
	private String description;
	
	public PartDescriptionMetaCommand(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}

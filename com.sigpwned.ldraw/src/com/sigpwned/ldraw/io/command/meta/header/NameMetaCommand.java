package com.sigpwned.ldraw.io.command.meta.header;


public class NameMetaCommand extends AbstractHeaderMetaCommand {
	private String filename;

	public NameMetaCommand(String filename) {
		super();
		this.filename = filename;
	}
	
	public String getFilename() {
		return filename;
	}
}

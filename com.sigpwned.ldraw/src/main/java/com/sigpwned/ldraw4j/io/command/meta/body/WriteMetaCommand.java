package com.sigpwned.ldraw4j.io.command.meta.body;


public class WriteMetaCommand extends AbstractBodyMetaCommand {
	private String message;
	
	public WriteMetaCommand(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

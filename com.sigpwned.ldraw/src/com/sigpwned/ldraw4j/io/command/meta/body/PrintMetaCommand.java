package com.sigpwned.ldraw4j.io.command.meta.body;


public class PrintMetaCommand extends AbstractBodyMetaCommand {
	private String message;
	
	public PrintMetaCommand(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

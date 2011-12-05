package com.sigpwned.ldraw.io.command.meta.body;


public class PrintMetaCommand extends AbstractBodyMetaCommand {
	private String message;
	
	public PrintMetaCommand(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

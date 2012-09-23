package com.sigpwned.ldraw4j.io.command.meta.header;


public class HelpMetaCommand extends AbstractHeaderMetaCommand {
	private String message;

	public HelpMetaCommand(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

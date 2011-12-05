package com.sigpwned.ldraw.io.command.meta.header;


public class CommandLineMetaCommand extends AbstractHeaderMetaCommand {
	private String commandLine;
	
	public CommandLineMetaCommand(String commandLine) {
		this.commandLine = commandLine;
	}

	public String getCommandLine() {
		return commandLine;
	}
}

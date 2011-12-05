package com.sigpwned.ldraw.io.command.meta;


public class UnofficialMetaCommand extends AbstractMetaCommand {
	private String name;
	private String arguments;
	
	public UnofficialMetaCommand(String name, String arguments) {
		this.name = name;
		this.arguments = arguments;
	}

	public String getName() {
		return name;
	}

	public String getArguments() {
		return arguments;
	}
}

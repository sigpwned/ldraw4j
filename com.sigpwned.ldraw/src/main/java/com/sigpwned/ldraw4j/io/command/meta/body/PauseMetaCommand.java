package com.sigpwned.ldraw4j.io.command.meta.body;


public class PauseMetaCommand extends AbstractBodyMetaCommand {
	private static final PauseMetaCommand INSTANCE=new PauseMetaCommand();
	public static PauseMetaCommand getInstance() {
		return INSTANCE;
	}
	
	private PauseMetaCommand() {
	}
}
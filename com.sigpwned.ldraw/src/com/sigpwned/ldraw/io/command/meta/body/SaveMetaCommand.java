package com.sigpwned.ldraw.io.command.meta.body;


public class SaveMetaCommand extends AbstractBodyMetaCommand {
	private static final SaveMetaCommand INSTANCE=new SaveMetaCommand();
	public static SaveMetaCommand getInstance() {
		return INSTANCE;
	}
	
	private SaveMetaCommand() {
	}
}

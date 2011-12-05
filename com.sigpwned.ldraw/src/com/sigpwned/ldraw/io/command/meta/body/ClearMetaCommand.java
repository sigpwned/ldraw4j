package com.sigpwned.ldraw.io.command.meta.body;


public class ClearMetaCommand extends AbstractBodyMetaCommand {
	private static final ClearMetaCommand INSTANCE=new ClearMetaCommand();
	public static ClearMetaCommand getInstance() {
		return INSTANCE;
	}
	
	private ClearMetaCommand() {
	}
}

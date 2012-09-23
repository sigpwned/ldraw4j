package com.sigpwned.ldraw4j.io.command.meta.body;


public class StepMetaCommand extends AbstractBodyMetaCommand {
	private static final StepMetaCommand INSTANCE=new StepMetaCommand();
	public static StepMetaCommand getInstance() {
		return INSTANCE;
	}
	
	private StepMetaCommand() {
	}
}

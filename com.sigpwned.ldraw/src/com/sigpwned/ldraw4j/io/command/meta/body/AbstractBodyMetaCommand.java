package com.sigpwned.ldraw4j.io.command.meta.body;

import com.sigpwned.ldraw4j.io.command.meta.AbstractMetaCommand;


public abstract class AbstractBodyMetaCommand extends AbstractMetaCommand {
	public ClearMetaCommand asClear() {
		return (ClearMetaCommand) this;
	}

	public ColourMetaCommand asColour() {
		return (ColourMetaCommand) this;
	}

	public PauseMetaCommand asPause() {
		return (PauseMetaCommand) this;
	}

	public PrintMetaCommand asPrint() {
		return (PrintMetaCommand) this;
	}

	public SaveMetaCommand asSave() {
		return (SaveMetaCommand) this;
	}

	public StepMetaCommand asStep() {
		return (StepMetaCommand) this;
	}

	public WriteMetaCommand asWrite() {
		return (WriteMetaCommand) this;
	}
}

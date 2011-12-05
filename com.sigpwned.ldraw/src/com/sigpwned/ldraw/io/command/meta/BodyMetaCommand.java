package com.sigpwned.ldraw.io.command.meta;

import com.sigpwned.ldraw.io.command.meta.body.ClearMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.ColourMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.PauseMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.PrintMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.SaveMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.StepMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.WriteMetaCommand;

public interface BodyMetaCommand {
	public ClearMetaCommand asClear();

	public ColourMetaCommand asColour();

	public PauseMetaCommand asPause();

	public PrintMetaCommand asPrint();

	public SaveMetaCommand asSave();

	public StepMetaCommand asStep();

	public WriteMetaCommand asWrite();
}

package com.sigpwned.ldraw4j.io.command;

import com.sigpwned.ldraw4j.io.LDRAWCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.ClearMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.ColourMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.PauseMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.PrintMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.SaveMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.StepMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.body.WriteMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.AuthorMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.CategoryMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.CommandLineMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.HelpMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.HistoryMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.KeywordsMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.LDRAWORGMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.LicenseMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.NameMetaCommand;
import com.sigpwned.ldraw4j.io.command.meta.header.PartDescriptionMetaCommand;

public abstract class AbstractLDRAWCommand implements LDRAWCommand {
	public MetaCommand asMeta() {
		return (MetaCommand) this;
	}
	
	public DataCommand asData() {
		return (DataCommand) this;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// BODY CASTS /////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	
	///////////////////////////////////////////////////////////////////////////
	// HEADER CASTS ///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////


	///////////////////////////////////////////////////////////////////////////
	// DATA CASTS /////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
}

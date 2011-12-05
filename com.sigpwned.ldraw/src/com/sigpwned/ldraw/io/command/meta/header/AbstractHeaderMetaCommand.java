package com.sigpwned.ldraw.io.command.meta.header;

import com.sigpwned.ldraw.io.command.meta.AbstractMetaCommand;


public abstract class AbstractHeaderMetaCommand extends AbstractMetaCommand {
	public AuthorMetaCommand asAuthor() {
		return (AuthorMetaCommand) this;
	}
	
	public CategoryMetaCommand asCategory() {
		return (CategoryMetaCommand) this;
	}

	public CommandLineMetaCommand asCommandLine() {
		return (CommandLineMetaCommand) this;
	}

	public HelpMetaCommand asHelp() {
		return (HelpMetaCommand) this;
	}

	public HistoryMetaCommand asHistory() {
		return (HistoryMetaCommand) this;
	}
	
	public KeywordsMetaCommand asKeywords() {
		return (KeywordsMetaCommand) this;
	}

	public LDRAWORGMetaCommand asLDRAWORG() {
		return (LDRAWORGMetaCommand) this;
	}

	public LicenseMetaCommand asLicense() {
		return (LicenseMetaCommand) this;
	}

	public NameMetaCommand asName() {
		return (NameMetaCommand) this;
	}

	public PartDescriptionMetaCommand asPartDescription() {
		return (PartDescriptionMetaCommand) this;
	}
}

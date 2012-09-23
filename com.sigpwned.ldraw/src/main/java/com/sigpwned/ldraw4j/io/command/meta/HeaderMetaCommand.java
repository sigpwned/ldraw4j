package com.sigpwned.ldraw4j.io.command.meta;

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

public interface HeaderMetaCommand {
	public AuthorMetaCommand asAuthor();
	
	public BFCMetaCommand asBFC();
	
	public CategoryMetaCommand asCategory();

	public CommandLineMetaCommand asCommandLine();

	public HelpMetaCommand asHelp();

	public HistoryMetaCommand asHistory();
	
	public KeywordsMetaCommand asKeywords();

	public LDRAWORGMetaCommand asLDRAWORG();

	public LicenseMetaCommand asLicense();

	public NameMetaCommand asName();

	public PartDescriptionMetaCommand asPartDescription();
}

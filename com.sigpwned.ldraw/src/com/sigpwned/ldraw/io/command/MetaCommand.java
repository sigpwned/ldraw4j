package com.sigpwned.ldraw.io.command;

import com.sigpwned.ldraw.io.LDRAWCommand;
import com.sigpwned.ldraw.io.command.meta.BFCMetaCommand;
import com.sigpwned.ldraw.io.command.meta.UnofficialMetaCommand;
import com.sigpwned.ldraw.io.command.meta.body.AbstractBodyMetaCommand;
import com.sigpwned.ldraw.io.command.meta.header.AbstractHeaderMetaCommand;


public interface MetaCommand extends LDRAWCommand {
	public AbstractHeaderMetaCommand asHeader();
	
	public AbstractBodyMetaCommand asBody();
	
	public UnofficialMetaCommand asUnofficial();

	public BFCMetaCommand asBFC();
}

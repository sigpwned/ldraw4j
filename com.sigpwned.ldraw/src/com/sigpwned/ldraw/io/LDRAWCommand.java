package com.sigpwned.ldraw.io;

import com.sigpwned.ldraw.io.command.DataCommand;
import com.sigpwned.ldraw.io.command.MetaCommand;

public interface LDRAWCommand {
	public MetaCommand asMeta();
	
	public DataCommand asData();
}

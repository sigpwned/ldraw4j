package com.sigpwned.ldraw4j.io;

import com.sigpwned.ldraw4j.io.command.DataCommand;
import com.sigpwned.ldraw4j.io.command.MetaCommand;

public interface LDRAWCommand {
	public MetaCommand asMeta();
	
	public DataCommand asData();
}

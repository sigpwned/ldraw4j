package com.sigpwned.ldraw4j.io.command;

import com.sigpwned.ldraw4j.io.LDRAWCommand;

public abstract class AbstractLDRAWCommand implements LDRAWCommand {
	public MetaCommand asMeta() {
		return (MetaCommand) this;
	}
	
	public DataCommand asData() {
		return (DataCommand) this;
	}
}

package com.sigpwned.ldraw4j.io.command.meta;

import com.sigpwned.ldraw4j.io.command.meta.header.AbstractHeaderMetaCommand;
import com.sigpwned.ldraw4j.model.winding.BFC;

public class BFCMetaCommand extends AbstractHeaderMetaCommand {
	private BFC bfc;
	
	public BFCMetaCommand(BFC bfc) {
		this.bfc = bfc;
	}
	
	public BFC getBFC() {
		return bfc;
	}
}

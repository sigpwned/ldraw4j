package com.sigpwned.ldraw4j.io.command.meta.header;

import com.sigpwned.ldraw4j.model.name.RealName;
import com.sigpwned.ldraw4j.model.name.UserName;

public class AuthorMetaCommand extends AbstractHeaderMetaCommand {
	private RealName realName;
	private UserName userName;
	
	public AuthorMetaCommand(RealName realName, UserName userName) {
		this.realName = realName;
		this.userName = userName;
	}

	public RealName getRealName() {
		return realName;
	}

	public UserName getUserName() {
		return userName;
	}
}

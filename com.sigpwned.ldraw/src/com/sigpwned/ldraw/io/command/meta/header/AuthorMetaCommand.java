package com.sigpwned.ldraw.io.command.meta.header;

import com.sigpwned.ldraw.model.name.RealName;
import com.sigpwned.ldraw.model.name.UserName;

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

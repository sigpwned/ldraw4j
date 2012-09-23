package com.sigpwned.ldraw4j.io.command.meta.header;

import java.util.Date;

import com.sigpwned.ldraw4j.model.name.Name;

public class HistoryMetaCommand extends AbstractHeaderMetaCommand {
	private Date date;
	private Name name;
	private String message;

	public HistoryMetaCommand(Date date, Name name, String message) {
		this.date = date;
		this.name = name;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public Name getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}
}

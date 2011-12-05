package com.sigpwned.ldraw.model.file.version;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sigpwned.ldraw.model.file.FileVersion;

public class UpdateDateFileVersion extends FileVersion {
	private Date date;
	
	public UpdateDateFileVersion(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	private static final DateFormat DATE=new SimpleDateFormat("yyyy-MM-dd");
	public String toString() {
		return "UPDATE "+DATE.format(getDate());
	}
}

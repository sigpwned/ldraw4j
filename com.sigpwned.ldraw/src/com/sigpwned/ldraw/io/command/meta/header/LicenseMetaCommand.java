package com.sigpwned.ldraw.io.command.meta.header;


public class LicenseMetaCommand extends AbstractHeaderMetaCommand {
	private String licenseStatement;
	private boolean redistributable;
	
	public LicenseMetaCommand(String licenseStatement, boolean redistributable) {
		this.licenseStatement = licenseStatement;
		this.redistributable = redistributable;
	}

	public String getLicenseStatement() {
		return licenseStatement;
	}

	public boolean isRedistributable() {
		return redistributable;
	}
}

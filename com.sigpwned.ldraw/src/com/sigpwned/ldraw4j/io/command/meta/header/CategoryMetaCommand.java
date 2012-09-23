package com.sigpwned.ldraw4j.io.command.meta.header;


public class CategoryMetaCommand extends AbstractHeaderMetaCommand {
	private String category;

	public CategoryMetaCommand(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}

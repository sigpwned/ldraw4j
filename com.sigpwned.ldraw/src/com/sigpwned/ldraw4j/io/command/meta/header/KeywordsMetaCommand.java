package com.sigpwned.ldraw4j.io.command.meta.header;

import java.util.List;


public class KeywordsMetaCommand extends AbstractHeaderMetaCommand {
	private List<String> keywords;
	
	public KeywordsMetaCommand(List<String> keywords) {
		this.keywords = keywords;
	}
	
	public List<String> getKeywords() {
		return keywords;
	}
}

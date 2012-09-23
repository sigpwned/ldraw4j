package com.sigpwned.ldraw4j;

import java.io.File;
import java.io.IOException;

import com.sigpwned.ldraw4j.io.LDRAWConfiguration;
import com.sigpwned.ldraw4j.io.LDRAWModelReadHandler;
import com.sigpwned.ldraw4j.io.LDRAWModelReader;
import com.sigpwned.ldraw4j.x.LDRAWException;

public class LDRAW {
	public static LDRAWModelReader createModelReader(File home, LDRAWModelReadHandler handler) throws IOException, LDRAWException {
		return new LDRAWModelReader(LDRAWConfiguration.load(home), handler);
	}
}

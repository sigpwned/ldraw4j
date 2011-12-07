package com.sigpwned.ldraw.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import com.sigpwned.ldraw.io.handle.ldraw.AbstractLDRAWReadHandler;
import com.sigpwned.ldraw.model.geometry.Point3f;
import com.sigpwned.ldraw.x.LDRAWException;

public class LDRAWModelReader {
	private LDRAWConfiguration config;
	private LDRAWModelReadHandler handler;
	private BufferedReader lines;
	
	public LDRAWModelReader(LDRAWConfiguration config, LDRAWModelReadHandler handler) {
		this.config = config;
		this.handler = handler;
	}

	public void read(Reader in) throws IOException, LDRAWException {
		try {
			try {
				lines = new BufferedReader(in);
				parse(in);
			}
			finally {
				lines.close();
				lines = null;
			}
		}
		finally {
			in.close();
		}
	}
	
	protected LDRAWConfiguration getConfig() {
		return config;
	}
	
	protected void parse(Reader in) throws IOException, LDRAWException {
		new LDRAWReader(new AbstractLDRAWReadHandler() {
			public void line(int colour, Point3f[] line) throws LDRAWException {
				handler.line(getConfig().getColour(colour), line);
			}

			public void triangle(int colour, Point3f[] triangle) throws LDRAWException {
				handler.triangle(getConfig().getColour(colour), triangle);
			}

			public void quadrilateral(int colour, Point3f[] quad) throws LDRAWException {
				handler.triangle(getConfig().getColour(colour), quad);
			}

			public void optionalLine(int colour, Point3f[] line) throws LDRAWException {
				handler.optionalLine(getConfig().getColour(colour), line);
			}
		}).read(in);
	}
}

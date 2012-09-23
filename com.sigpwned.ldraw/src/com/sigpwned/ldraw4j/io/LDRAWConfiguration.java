package com.sigpwned.ldraw4j.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.sigpwned.ldraw4j.io.handle.ldraw.AbstractLDRAWReadHandler;
import com.sigpwned.ldraw4j.model.Colour;
import com.sigpwned.ldraw4j.model.colour.ColourReference;
import com.sigpwned.ldraw4j.model.colour.Colours;
import com.sigpwned.ldraw4j.model.colour.Material;
import com.sigpwned.ldraw4j.model.colour.RGBA;
import com.sigpwned.ldraw4j.x.LDRAWException;

public class LDRAWConfiguration {
	public static LDRAWConfiguration load(File home) throws IOException, LDRAWException {
		File ldconfig=new File(home, "LDConfig.ldr");
		if(!ldconfig.canRead())
			throw new LDRAWException("Invalid configuration directory: No LDConfig.ldr");
		
		LDRAWConfiguration result=new LDRAWConfiguration(home);
		result.read(new FileReader(ldconfig));
		
		return result;
	}
	
	private File home;
	private Colours colours;
	
	public LDRAWConfiguration(File home) {
		this.home = home;
		this.colours = new Colours(Colour.defaultColour());
	}
	
	public File getHome() {
		return home;
	}
	
	public Colours getColours() {
		return colours;
	}
	
	protected void read(Reader in) throws IOException, LDRAWException {
		new LDRAWReader(new AbstractLDRAWReadHandler() {
			public void colour(String name, int code, RGBA value, ColourReference edgeref, Integer luminance, Material material) throws LDRAWException {
				System.err.println("Loading colour "+name+" #"+code);
				
				RGBA edge=edgeref.eval(colours, Colour.defaultColour()).getValue();
				
				Colour colour=new Colour(name, code, material, luminance, value, edge);
				
				colours.defineColour(colour);
			}
		}).read(in);
	}
}

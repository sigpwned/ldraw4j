package com.sigpwned.ldraw.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.sigpwned.ldraw.io.handle.ldraw.AbstractLDRAWReadHandler;
import com.sigpwned.ldraw.io.x.NoSuchColourLDRAWException;
import com.sigpwned.ldraw.model.Colour;
import com.sigpwned.ldraw.model.colour.ColourReference;
import com.sigpwned.ldraw.model.colour.Material;
import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.colour.ref.CodeColourReference;
import com.sigpwned.ldraw.model.colour.ref.RGBAColourReference;
import com.sigpwned.ldraw.x.InternalLDRAWException;
import com.sigpwned.ldraw.x.LDRAWException;

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
	private Map<Integer,Colour> colours;
	
	public LDRAWConfiguration(File home) {
		this.home = home;
		this.colours = new TreeMap<Integer,Colour>();
	}
	
	public File getHome() {
		return home;
	}
	
	public Collection<Colour> getColours() {
		return colours.values();
	}
	
	public Colour getColour(int code) throws LDRAWException {
		Colour result=colours.get(code);
		if(result == null)
			throw new NoSuchColourLDRAWException(code);
		return result;
	}
	
	protected void read(Reader in) throws IOException, LDRAWException {
		new LDRAWReader(new AbstractLDRAWReadHandler() {
			public void colour(String name, int code, RGBA value, ColourReference edgeref, Integer luminance, Material material) throws LDRAWException {
				System.err.println("Loading colour "+name+" #"+code);
				
				RGBA edge;
				if(edgeref == null)
					edge = null;
				else
				if(edgeref instanceof CodeColourReference)
					edge = getColour(edgeref.asCode().getCode()).getValue();
				else
				if(edgeref instanceof RGBAColourReference)
					edge = edgeref.asRGBA().getValue();
				else
					throw new InternalLDRAWException("Unrecognized ColourReference: "+edgeref);
				
				Colour colour=new Colour(name, code, material, luminance, value, edge);
				
				colours.put(colour.getCode(), colour);
			}
		}).read(in);
	}
}

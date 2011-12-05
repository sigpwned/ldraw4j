package com.sigpwned.ldraw.model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;
import java.util.TreeSet;

import com.sigpwned.ldraw.x.InternalLDRAWException;

public class BrickLibrary {
	private static final FilenameFilter DATFILES=new FilenameFilter() {
		public boolean accept(File parent, String name) {
			return name.endsWith(".dat") || name.endsWith(".DAT");
		}
	};
	
	public static BrickLibrary scan(File home) {
		return new BrickLibrary(home, scan(home, new StringBuilder(), new TreeSet<String>()));
	}
	
	protected static Set<String> scan(File directory, StringBuilder path, Set<String> entries) {
		for(File file : directory.listFiles()) {
			boolean isdatfile=file.getName().endsWith(".dat") || file.getName().endsWith(".DAT");
			boolean isdirectory=file.isDirectory();
			if(isdatfile || isdirectory) {
				path.append(File.separatorChar);
				path.append(file.getName());
				
				if(isdatfile)
					entries.add(path.toString());
				else
				if(isdirectory)
					scan(file, path, entries);
				else
					throw new InternalLDRAWException("Not a dat file or a directory");
				
				path.setLength(path.length()-(file.getName().length()+1));
			}
		}
		return entries;
	}
	
	private File home;
	private Set<String> entries;
	
	public BrickLibrary(File home, Set<String> entries) {
		this.home = home;
		this.entries = entries;
	}
	
	public File getHome() {
		return home;
	}
}

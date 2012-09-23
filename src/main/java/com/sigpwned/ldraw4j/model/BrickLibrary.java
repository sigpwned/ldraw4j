// Copyright 2012 Andy Boothe
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.sigpwned.ldraw4j.model;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import com.sigpwned.ldraw4j.x.InternalLDRAWException;

public class BrickLibrary {
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

	public Set<String> getEntries() {
		return entries;
	}
}

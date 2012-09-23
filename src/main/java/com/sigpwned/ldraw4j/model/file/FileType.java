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
package com.sigpwned.ldraw4j.model.file;

public enum FileType {
	PART("Part"), SUBPART("Subpart"), PRIMITIVE("Primitive"), PRIMITIVE48("48_Primitive"), SHORTCUT("Shortcut"), CONFIGURATION("Configuration");
	
	private String value;
	
	private FileType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return getValue();
	}
}

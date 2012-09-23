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
package com.sigpwned.ldraw4j.model.file.version;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sigpwned.ldraw4j.model.file.FileVersion;

public class UpdateDateFileVersion extends FileVersion {
	private Date date;
	
	public UpdateDateFileVersion(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	private static final DateFormat DATE=new SimpleDateFormat("yyyy-MM-dd");
	public String toString() {
		return "UPDATE "+DATE.format(getDate());
	}
}

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
package com.sigpwned.ldraw4j.io.command.meta.header;


public class LicenseMetaCommand extends AbstractHeaderMetaCommand {
	private String licenseStatement;
	private boolean redistributable;
	
	public LicenseMetaCommand(String licenseStatement, boolean redistributable) {
		this.licenseStatement = licenseStatement;
		this.redistributable = redistributable;
	}

	public String getLicenseStatement() {
		return licenseStatement;
	}

	public boolean isRedistributable() {
		return redistributable;
	}
}

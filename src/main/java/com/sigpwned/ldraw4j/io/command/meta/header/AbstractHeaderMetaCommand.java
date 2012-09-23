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

import com.sigpwned.ldraw4j.io.command.meta.AbstractMetaCommand;


public abstract class AbstractHeaderMetaCommand extends AbstractMetaCommand {
	public AuthorMetaCommand asAuthor() {
		return (AuthorMetaCommand) this;
	}
	
	public CategoryMetaCommand asCategory() {
		return (CategoryMetaCommand) this;
	}

	public CommandLineMetaCommand asCommandLine() {
		return (CommandLineMetaCommand) this;
	}

	public HelpMetaCommand asHelp() {
		return (HelpMetaCommand) this;
	}

	public HistoryMetaCommand asHistory() {
		return (HistoryMetaCommand) this;
	}
	
	public KeywordsMetaCommand asKeywords() {
		return (KeywordsMetaCommand) this;
	}

	public LDRAWORGMetaCommand asLDRAWORG() {
		return (LDRAWORGMetaCommand) this;
	}

	public LicenseMetaCommand asLicense() {
		return (LicenseMetaCommand) this;
	}

	public NameMetaCommand asName() {
		return (NameMetaCommand) this;
	}

	public PartDescriptionMetaCommand asPartDescription() {
		return (PartDescriptionMetaCommand) this;
	}
}

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
package com.sigpwned.ldraw4j.io.command;

import com.sigpwned.ldraw4j.io.LDRAWCommand;
import com.sigpwned.ldraw4j.io.command.data.LineDataCommand;
import com.sigpwned.ldraw4j.io.command.data.OptionalLineDataCommand;
import com.sigpwned.ldraw4j.io.command.data.QuadrilateralDataCommand;
import com.sigpwned.ldraw4j.io.command.data.SubFileDataCommand;
import com.sigpwned.ldraw4j.io.command.data.TriangleDataCommand;

public interface DataCommand extends LDRAWCommand {
	public LineDataCommand asLine();
	
	public OptionalLineDataCommand asOptionalLine();
	
	public QuadrilateralDataCommand asQuadrilateral();
	
	public SubFileDataCommand asSubFile();
	
	public TriangleDataCommand asTriangle();
}

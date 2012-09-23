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

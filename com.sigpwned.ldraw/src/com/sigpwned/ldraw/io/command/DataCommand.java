package com.sigpwned.ldraw.io.command;

import com.sigpwned.ldraw.io.LDRAWCommand;
import com.sigpwned.ldraw.io.command.data.LineDataCommand;
import com.sigpwned.ldraw.io.command.data.OptionalLineDataCommand;
import com.sigpwned.ldraw.io.command.data.QuadrilateralDataCommand;
import com.sigpwned.ldraw.io.command.data.SubFileDataCommand;
import com.sigpwned.ldraw.io.command.data.TriangleDataCommand;

public interface DataCommand extends LDRAWCommand {
	public LineDataCommand asLine();
	
	public OptionalLineDataCommand asOptionalLine();
	
	public QuadrilateralDataCommand asQuadrilateral();
	
	public SubFileDataCommand asSubFile();
	
	public TriangleDataCommand asTriangle();
}

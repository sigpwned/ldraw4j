package com.sigpwned.ldraw4j.io.command.data;

import com.sigpwned.ldraw4j.io.command.AbstractLDRAWCommand;
import com.sigpwned.ldraw4j.io.command.DataCommand;

public abstract class AbstractDataCommand extends AbstractLDRAWCommand implements DataCommand {
	public LineDataCommand asLine() {
		return (LineDataCommand) this;
	}
	
	public OptionalLineDataCommand asOptionalLine() {
		return (OptionalLineDataCommand) this;
	}
	
	public QuadrilateralDataCommand asQuadrilateral() {
		return (QuadrilateralDataCommand) this;
	}
	
	public SubFileDataCommand asSubFile() {
		return (SubFileDataCommand) this;
	}
	
	public TriangleDataCommand asTriangle() {
		return (TriangleDataCommand) this;
	}
}

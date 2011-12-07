package com.sigpwned.ldraw.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.sigpwned.ldraw.io.handle.ldraw.AbstractLDRAWReadHandler;
import com.sigpwned.ldraw.io.model.ModelState;
import com.sigpwned.ldraw.io.model.Winding;
import com.sigpwned.ldraw.model.geometry.Point3f;
import com.sigpwned.ldraw.model.winding.BFC;
import com.sigpwned.ldraw.x.InternalLDRAWException;
import com.sigpwned.ldraw.x.LDRAWException;

public class LDRAWModelReader {
	private static class State {
		private boolean invertNext;
		private ModelState modelState;
		
		public State() {
			this.modelState = new ModelState();
			this.invertNext = false;
		}

		public boolean isInvertNext() {
			return invertNext;
		}

		public void setInvertNext(boolean invertNext) {
			this.invertNext = invertNext;
		}
		
		public ModelState getModelState() {
			return modelState;
		}
	}
	
	private LDRAWConfiguration config;
	private LDRAWModelReadHandler handler;
	private BufferedReader lines;
	private List<State> stateStack;
	
	public LDRAWModelReader(LDRAWConfiguration config, LDRAWModelReadHandler handler) {
		this.config = config;
		this.handler = handler;
		this.stateStack = new ArrayList<State>();
	}

	public void read(Reader in) throws IOException, LDRAWException {
		try {
			try {
				lines = new BufferedReader(in);
				parse(in);
			}
			finally {
				lines.close();
				lines = null;
			}
		}
		finally {
			in.close();
		}
	}
	
	protected LDRAWConfiguration getConfig() {
		return config;
	}
	
	protected State top() {
		if(stateStack.size() == 0)
			throw new IllegalStateException("State stack empty");
		return stateStack.get(stateStack.size()-1);
	}
	
	protected State pop() {
		State result=top();
		stateStack.remove(stateStack.size()-1);
		return result;
	}
	
	protected void push(State state) {
		stateStack.add(state);
	}
	
	protected void parse(Reader in) throws IOException, LDRAWException {
		push(new State());
		try {
			new LDRAWReader(new AbstractLDRAWReadHandler() {
				public void bfc(BFC bfc) throws LDRAWException {
					if(bfc == BFC.NOCERTIFY)
						top().getModelState().setWinding(Winding.UNKNOWN);
					else
					if(bfc==BFC.CERTIFY || bfc==BFC.CERTIFY_CCW)
						top().getModelState().setWinding(Winding.CCW);
					else
					if(bfc == BFC.CERTIFY_CW)
						top().getModelState().setWinding(Winding.CW);
					else
					if(bfc == BFC.CCW) {
						if(!top().getModelState().getWinding().equals(Winding.CCW)) {
							top().getModelState().setWinding(Winding.CCW);
							handler.winding(top().getModelState());
						}
					} else
					if(bfc == BFC.CCW) {
						if(!top().getModelState().getWinding().equals(Winding.CW)) {
							top().getModelState().setWinding(Winding.CW);
							handler.winding(top().getModelState());
						}
					} else
					if(bfc == BFC.INVERTNEXT)
						top().setInvertNext(true);
					else
					if(bfc == BFC.CLIP) {
						if(!top().getModelState().isClipping()) {
							top().getModelState().setClipping(true);
							handler.clipping(top().getModelState());
						}
					} else
					if(bfc == BFC.NOCLIP) {
						if(top().getModelState().isClipping()) {
							top().getModelState().setClipping(false);
							handler.clipping(top().getModelState());
						}
					}
					else
						throw new InternalLDRAWException("Unrecognized BFC: "+bfc);
				}
				
				public void line(int colour, Point3f[] line) throws LDRAWException {
					handler.line(top().getModelState(), getConfig().getColour(colour), line);
				}
	
				public void triangle(int colour, Point3f[] triangle) throws LDRAWException {
					handler.triangle(top().getModelState(), getConfig().getColour(colour), triangle);
				}
	
				public void quadrilateral(int colour, Point3f[] quad) throws LDRAWException {
					handler.quadrilateral(top().getModelState(), getConfig().getColour(colour), quad);
				}
	
				public void optionalLine(int colour, Point3f[] line) throws LDRAWException {
					handler.optionalLine(top().getModelState(), getConfig().getColour(colour), line);
				}
			}).read(in);
		}
		finally {
			pop();
		}
	}
}

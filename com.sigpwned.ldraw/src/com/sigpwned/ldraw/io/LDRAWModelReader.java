package com.sigpwned.ldraw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.sigpwned.ldraw.io.handle.ldraw.AbstractLDRAWReadHandler;
import com.sigpwned.ldraw.io.model.ModelState;
import com.sigpwned.ldraw.io.model.Winding;
import com.sigpwned.ldraw.model.geometry.Matrix3f;
import com.sigpwned.ldraw.model.geometry.Point3f;
import com.sigpwned.ldraw.model.winding.BFC;
import com.sigpwned.ldraw.x.InternalLDRAWException;
import com.sigpwned.ldraw.x.LDRAWException;

public class LDRAWModelReader {
	private static class State {
		private boolean inverted;
		private boolean invertNext;
		private ModelState modelState;
		
		public State(String name) {
			this.modelState = new ModelState(name);
			this.inverted = false;
			this.invertNext = false;
		}
		
		public boolean isInverted() {
			return inverted;
		}

		public void setInverted(boolean inverted) {
			this.inverted = inverted;
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

	public void read(String name) throws IOException, LDRAWException {
		read(name, new FileReader(part(name)));
	}
	
	protected File part(String name) {
		name = name.replace('\\', File.separatorChar);
		
		File result=null;
		for(File home : new File[]{new File(getConfig().getHome(), "parts"), new File(new File(getConfig().getHome(), "p"), "48"), new File(getConfig().getHome(), "p")}) {
		// for(File home : new File[]{new File(getConfig().getHome(), "parts"), new File(getConfig().getHome(), "p")}) {
			result = new File(home, name);
			if(result.exists()) {
				System.err.println(result.getAbsolutePath());
				break;
			}
		}
		if(result == null)
			throw new RuntimeException("Should never happen");
		
		return result;
	}
	
	public void read(String name, Reader in) throws IOException, LDRAWException {
		try {
			try {
				lines = new BufferedReader(in);
				push(new State(name));
				try {
					parse(in);
				}
				finally {
					pop();
				}
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
	
	private int depth=0;
	protected void parse(Reader in) throws IOException, LDRAWException {
		handler.enterFile(top().getModelState().getName());
		try {
			new LDRAWReader(new AbstractLDRAWReadHandler() {
				public void bfc(BFC bfc) throws LDRAWException {
					if(top().isInvertNext())
						System.err.println("WARNING: Ignoring illegal INVERTNEXT");
					
					top().setInvertNext(false);
					
					if(bfc == BFC.NOCERTIFY)
						top().getModelState().setWinding(winding(Winding.UNKNOWN));
					else
					if(bfc==BFC.CERTIFY || bfc==BFC.CERTIFY_CCW)
						top().getModelState().setWinding(winding(Winding.CCW));
					else
					if(bfc == BFC.CERTIFY_CW)
						top().getModelState().setWinding(winding(Winding.CW));
					else
					if(bfc == BFC.CCW) {
						Winding winding=winding(Winding.CCW);
						if(!top().getModelState().getWinding().equals(winding)) {
							top().getModelState().setWinding(winding);
							handler.winding(top().getModelState());
						}
					} else
					if(bfc == BFC.CW) {
						Winding winding=winding(Winding.CW);
						if(!top().getModelState().getWinding().equals(winding)) {
							top().getModelState().setWinding(winding);
							handler.winding(top().getModelState());
						}
					} else
					if(bfc == BFC.INVERTNEXT) {
						System.err.println("INVERTNEXT");
						top().setInvertNext(true);
					} else
					if(bfc == BFC.CLIP) {
						System.err.println("BFC.CLIP");
						if(!top().getModelState().isClipping()) {
							top().getModelState().setClipping(true);
							handler.clipping(top().getModelState());
						}
					} else
					if(bfc == BFC.NOCLIP) {
						System.err.println("BFC.NOCLIP");
						if(top().getModelState().isClipping()) {
							top().getModelState().setClipping(false);
							handler.clipping(top().getModelState());
						}
					}
					else
						throw new InternalLDRAWException("Unrecognized BFC: "+bfc);
				}
				
				public void line(int colour, Point3f[] line) throws LDRAWException {
					if(top().isInvertNext())
						System.err.println("WARNING: Ignoring illegal INVERTNEXT");
					handler.line(top().getModelState(), getConfig().getColour(colour), transform(line));
					top().setInvertNext(false);
				}
	
				public void triangle(int colour, Point3f[] triangle) throws LDRAWException {
					if(top().isInvertNext())
						System.err.println("WARNING: Ignoring illegal INVERTNEXT");
					handler.triangle(top().getModelState(), getConfig().getColour(colour), transform(triangle));
					top().setInvertNext(false);
				}
	
				public void quadrilateral(int colour, Point3f[] quad) throws LDRAWException {
					if(top().isInvertNext())
						System.err.println("WARNING: Ignoring illegal INVERTNEXT");
					handler.quadrilateral(top().getModelState(), getConfig().getColour(colour), transform(quad));
					top().setInvertNext(false);
				}
	
				public void optionalLine(int colour, Point3f[] line, Point3f[] controlPoints) throws LDRAWException {
					if(top().isInvertNext())
						System.err.println("WARNING: Ignoring illegal INVERTNEXT");				
					handler.optionalLine(top().getModelState(), getConfig().getColour(colour), transform(line), transform(controlPoints));
					top().setInvertNext(false);
				}
				
				protected Point3f[] transform(Point3f[] points) {
					Point3f[] mypoints=new Point3f[points.length];
					for(int i=0;i<points.length;i++)
						mypoints[i] = top().getModelState().getRotation().mul(points[i]).add(top().getModelState().getTranslation());
					return mypoints;
				}
				
				protected Winding winding(Winding winding) {
					Winding result;
					if(winding.equals(Winding.UNKNOWN))
						result = Winding.UNKNOWN;
					else
					if(top().isInverted()) {
						if(winding.equals(Winding.CW))
							result = Winding.CCW;
						else
						if(winding.equals(Winding.CCW))
							result = Winding.CW;
						else
							throw new IllegalArgumentException("Unrecognized winding: "+winding);
					}
					else
						result = winding;
					System.err.println("Winding = "+winding+" -> "+result+" ("+top().isInverted()+")");
					return result;
				}
	
				public void subfile(int colour, Point3f st, Matrix3f sr, String file) throws LDRAWException, IOException {
					State newstate=new State(file);
					
					newstate.setInverted(top().isInverted() ^ top().isInvertNext());
	
					if(newstate.isInverted())
						newstate.getModelState().setWinding(Winding.CW);
					else 
						newstate.getModelState().setWinding(Winding.CCW);
					
					Point3f t=top().getModelState().getTranslation();
					Matrix3f r=top().getModelState().getRotation();
					
					newstate.getModelState().setRotation(r.mul(sr));
					
					newstate.getModelState().setTranslation(new Point3f(new float[] {
						r.get(0,0)*st.x()+r.get(0, 1)*st.y()+r.get(0, 2)*st.z()+t.x(),
						r.get(1,0)*st.x()+r.get(1, 1)*st.y()+r.get(1, 2)*st.z()+t.y(),
						r.get(2,0)*st.x()+r.get(2, 1)*st.y()+r.get(2, 2)*st.z()+t.z()
					}));
					
					String padding="";
					for(int i=0;i<depth;i++)
						padding = padding+" ";
					System.err.println(padding+"subfile -> "+newstate.isInverted()+" = "+newstate.getModelState().getName()+" ("+newstate.getModelState().getWinding()+")");
					System.err.println(padding+sr);
					System.err.println(padding+newstate.getModelState().getRotation());
					System.err.println(padding+newstate.getModelState().getTranslation());
					depth = depth+1;
					
					push(newstate);
					try {
						parse(new FileReader(part(file)));
					}
					finally {
						pop();
					}
					
					depth = depth-1;
					
					top().setInvertNext(false);
				}
			}).read(in);
		}
		finally {
			handler.leaveFile(top().getModelState().getName());
		}
	}
}

package com.sigpwned.ldraw.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import com.sigpwned.ldraw.io.x.MalformedFileLDRAWException;
import com.sigpwned.ldraw.model.colour.Luminance;
import com.sigpwned.ldraw.model.colour.Material;
import com.sigpwned.ldraw.model.colour.RGBA;
import com.sigpwned.ldraw.model.geometry.Matrix3f;
import com.sigpwned.ldraw.model.geometry.Point3f;
import com.sigpwned.ldraw.model.name.Name;
import com.sigpwned.ldraw.model.name.RealName;
import com.sigpwned.ldraw.model.name.UserName;
import com.sigpwned.ldraw.model.part.PartType;
import com.sigpwned.ldraw.model.part.PartVersion;
import com.sigpwned.ldraw.model.part.version.OriginalPartVersion;
import com.sigpwned.ldraw.model.part.version.UpdatePartVersion;
import com.sigpwned.ldraw.model.winding.BFC;
import com.sigpwned.ldraw.util.CollectionUtil;
import com.sigpwned.ldraw.util.StringUtil;
import com.sigpwned.ldraw.x.InternalLDRAWException;
import com.sigpwned.ldraw.x.LDRAWException;
import com.sigpwned.ldraw.x.LeakedLDRAWException;


public class LDRAWReader {
	private LDRAWHandler handler;
	private BufferedReader lines;
	private int lineno;
	
	public LDRAWReader(LDRAWHandler handler) {
		this.handler = handler;
	}
	
	public void read(Reader in) throws IOException, LDRAWException {
		try {
			try {
				lines = new BufferedReader(in);
				parse();
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
	
	private static final Pattern LINE=Pattern.compile("^(\\d+)");
	protected void parse() throws IOException, LDRAWException {
		lineno = 0;
		for(String line=lines.readLine();line!=null;line=lines.readLine()) {
			line   = line.trim();
			lineno = lineno+1;
			if(line.equals("")) {
				// Blank lines are ignored
			}
			else {
				MatchResult m=StringUtil.match(line, LINE);
				if(m == null)
					throw new MalformedFileLDRAWException("Non-empty line does not begin with a number: "+line);
				int code=Integer.parseInt(m.group(1));
				String command=line.substring(m.end(), line.length()).trim();
				if(code == 0)
					meta(command);
				else
				if(code == 1)
					subfile(command);
				else
				if(code == 2)
					line(command);
				else
				if(code == 3)
					triangle(command);
				else
				if(code == 4)
					quadrilateral(command);
				else
				if(code == 5)
					optionalLine(command);
				else
					throw new MalformedFileLDRAWException("Illegal code at beginning of line: "+line);
			}
		}
	}
	
	private static final Pattern OPTIONALLINE=Pattern.compile("^(\\d+)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s*$");
	private void optionalLine(String line) throws LDRAWException {
		MatchResult m=require(line, OPTIONALLINE, "Malformed optionalLine line: "+line);
		
		int colour=Integer.parseInt(m.group(1));
		Point3f[] triangle=new Point3f[] {
			p(m, 2), p(m, 5), p(m, 8), p(m, 11)
		};
		
		handler.optionalLine(colour, triangle);
	}

	private static final Pattern QUAD=Pattern.compile("^(\\d+)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s*$");
	private void quadrilateral(String line) throws LDRAWException {
		MatchResult m=require(line, QUAD, "Malformed quadrilateral line: "+line);
		
		int colour=Integer.parseInt(m.group(1));
		Point3f[] triangle=new Point3f[] {
			p(m, 2), p(m, 5), p(m, 8), p(m, 11)
		};
		
		handler.quadrilateral(colour, triangle);
	}

	private static final Pattern TRIANGLE=Pattern.compile("^(\\d+)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s*$");
	private void triangle(String line) throws LDRAWException {
		MatchResult m=require(line, TRIANGLE, "Malformed triangle line: "+line);
		
		int colour=Integer.parseInt(m.group(1));
		Point3f[] triangle=new Point3f[] {
			p(m, 2), p(m, 5), p(m, 8)
		};
		
		handler.triangle(colour, triangle);
	}

	private static final Pattern LINEPAT=Pattern.compile("^(\\d+)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([+-]?\\d+(?:.\\d*)?)\\s*$");
	private void line(String line) throws LDRAWException {
		MatchResult m=require(line, LINEPAT, "Malformed line line: "+line);
		
		int colour=Integer.parseInt(m.group(1));
		Point3f p1=p(m, 2);
		Point3f p2=p(m, 5);
		
		handler.line(colour, p1, p2);
	}

	private static final Pattern SUBFILE=Pattern.compile("^(\\d+)\\s+([+-]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+([-+]?\\d+(?:.\\d*)?)\\s+(.*?)\\s*$");
	private void subfile(String line) throws LDRAWException {
		MatchResult m=require(line, SUBFILE, "Malformed subfile line: "+line);
		
		int colour=Integer.parseInt(m.group(1));
		
		Point3f location=p(m, 2);
		
		float[][] rotationCoords=new float[3][];
		for(int i=0;i<3;i++) {
			rotationCoords[i] = new float[3];
			for(int j=0;j<3;j++)
				rotationCoords[i][j] = Float.parseFloat(m.group(5+3*i+j));
		}
		Matrix3f rotation=new Matrix3f(rotationCoords);
		
		String file=m.group(14);
		
		handler.subfile(colour, location, rotation, file);
	}
	
	private static final DateFormat DATE=new SimpleDateFormat("yyyy-MM-dd");

	private static final Pattern COMMENT=Pattern.compile("^//");
	private static final Pattern COMMAND=Pattern.compile("^(!\\w+|name:|author:|bfc\\b|clear\\b|pause\\b|print\\b|save\\b|step\\b|write\\b)", Pattern.CASE_INSENSITIVE);
	private static final Pattern AUTHOR_ARGS=Pattern.compile("^([^\\[]+?)\\s*(?:\\[([^\\]]+)\\])?$");
	private static final Pattern LDRAW_ORG_ARGS=Pattern.compile("^(part|subpart|primitive|48_primitive|shortcut)\\s+(\\S.*?\\s+)?(original|update\\s+(\\d+)-(\\d+))$", Pattern.CASE_INSENSITIVE);
	private static final Pattern LICENSE_REDISTRIBUTABLE=Pattern.compile("(?!=not)\\s*redistributable", Pattern.CASE_INSENSITIVE);
	private static final Pattern HISTORY_ARGS=Pattern.compile("^(\\d+-\\d+-\\d+)\\s+(\\[[^\\]]+\\]|\\{[^\\}]+\\})\\s+(.*?)\\s*$", Pattern.CASE_INSENSITIVE);
	protected void meta(String line) throws LDRAWException {
		MatchResult m=StringUtil.match(line, COMMAND);
		if(m != null) {
			String command=m.group().toLowerCase();
			String arguments=line.substring(m.end(), line.length()).trim();
			if(command.equals("!name") || command.equals("name:"))
				handler.name(arguments);
			else
			if(command.equals("!author") || command.equals("author:")) {
				m = require(arguments, AUTHOR_ARGS, "Malformed author line: "+arguments);
				RealName realName=new RealName(m.group(1));
				UserName userName=null;
				if(m.group(2) != null)
					userName = new UserName(m.group(2));
				handler.author(realName, userName);
			} else
			if(command.equals("!ldraw_org")) {
				m = require(arguments, LDRAW_ORG_ARGS, "Malformed LDRAW_ORG line: "+arguments);
				
				String partTypeName=m.group(1).toLowerCase();
				if(partTypeName.equals("48_primitive"))
					partTypeName = "primitive48";
				PartType partType=valueOf(PartType.class, partTypeName.toUpperCase());

				String qualifiers=m.group(2);

				PartVersion partVersion;
				String partVersionText=m.group(3).toLowerCase();
				if(partVersionText.equals("original"))
					partVersion = OriginalPartVersion.getInstance();
				else
					partVersion = new UpdatePartVersion(Integer.parseInt(m.group(4)), Integer.parseInt(m.group(5)));
				
				handler.ldraworg(partType, qualifiers, partVersion);
			} else
			if(command.equals("!license")) {
				handler.license(arguments, StringUtil.match(arguments, LICENSE_REDISTRIBUTABLE)!=null);
			} else
			if(command.equals("!bfc") || command.equals("bfc")) {
				String bfcName=CollectionUtil.join(StringUtil.toUpperCase(StringUtil.words(arguments)), "_");
				BFC bfc=valueOf(BFC.class, bfcName);
				handler.bfc(bfc);
			} else
			if(command.equals("!history")) {
				m = require(arguments, HISTORY_ARGS, "Malformed HISTORY line: "+arguments);
				
				Date date=d(m.group(1), DATE, "Bad date in HISTORY line: "+m.group(1));
				Name name;
				if(m.group(2).startsWith("{"))
					name = new RealName(m.group(2).substring(1, m.group(2).length()-1));
				else
				if(m.group(2).startsWith("["))
					name = new UserName(m.group(2).substring(1, m.group(2).length()-1));
				else
					throw new InternalLDRAWException("Unhandled case for name: "+m.group(2));
				String message=m.group(3);
				
				handler.history(date, name, message);
			} else
			if(command.equals("!category"))
				handler.category(arguments);
			else
			if(command.equals("!cmdline"))
				handler.commandLine(arguments);
			else
			if(command.equals("!keywords"))
				handler.keywords(StringUtil.trim(StringUtil.split(arguments, StringUtil.COMMA)));
			else
			if(command.equals("!help"))
				handler.help(arguments);
			else
			if(command.equals("clear") || command.equals("!clear"))
				handler.clear();
			else
			if(command.equals("pause") || command.equals("!pause"))
				handler.pause();
			else
			if(command.equals("print") || command.equals("!print"))
				handler.print(arguments);
			else
			if(command.equals("save") || command.equals("!save"))
				handler.save();
			else
			if(command.equals("step") || command.equals("!step"))
				handler.step();
			else
			if(command.equals("write") || command.equals("!write"))
				handler.write(arguments);
			else
				handler.meta(line);
		} else
		if(lineno == 1) {
			// This is an explicit property of the header. First line with a
			// 0 is always the part description.
			handler.partDescription(line);
		} else
		if(line.equals("")) {
			// This is typically the last line in a file. NBD.
		}
		else {
			if(StringUtil.match(line, COMMENT) == null)
				System.err.println("WARNING: Line not marked explicitly as a comment being interpreted as comment: "+line);
			handler.comment(line);
		}
	}
	
	private static <T extends Enum<T>> T valueOf(Class<T> klass, String name) throws LDRAWException {
		T result;
		try {
			result = klass.cast(klass.getMethod("valueOf", String.class).invoke(null, name));
		}
		catch(IllegalArgumentException e) {
			throw new MalformedFileLDRAWException("Not a valid "+klass.getSimpleName()+" value: "+name);
		}
		catch(Exception e) {
			throw new LeakedLDRAWException(e);
		}
		return result;
	}
	
	private static Point3f p(MatchResult m, int start) {
		float[] coords=new float[3];
		for(int i=0;i<3;i++)
			coords[i] = Float.parseFloat(m.group(start+i));
		return new Point3f(coords);
	}
	
	private static Date d(String value, DateFormat format, String failure) throws LDRAWException {
		Date result;
		try {
			result = format.parse(value);
		}
		catch(ParseException e) {
			throw new MalformedFileLDRAWException(failure);
		}
		return result;
	}
	
	private static MatchResult require(String s, Pattern p, String failure) throws LDRAWException {
		MatchResult result=StringUtil.match(s, p);
		if(result == null)
			throw new MalformedFileLDRAWException(failure);
		return result;
	}
	
	public static void main(String[] args) {
		try {
			final Writer out=new OutputStreamWriter(System.out);
			LDRAWReader reader=new LDRAWReader(new LDRAWHandler() {
				private void println(String message) throws LDRAWException {
					try {
						out.write(message); out.write('\n'); out.flush();
					}
					catch(IOException e) {
						throw new LeakedLDRAWException(e);
					}
				}
				public void partDescription(String description) throws LDRAWException {
					println("0 "+description);
				}
				public void name(String filename) throws LDRAWException {
					println("0 Name: "+filename);
				}
				public void author(RealName realName, UserName userName) throws LDRAWException {
					String line="0 Author: "+realName.getName();
					if(userName != null)
						line = line+" ["+userName.getName()+"]";
					println(line);
				}
				public void ldraworg(PartType partType, String qualifiers, PartVersion version) throws LDRAWException {
					String line="0 !LDRAW_ORG "+partType.toString()+" ";
					if(qualifiers != null)
						line = line+qualifiers+" ";
					line = line+version;
					println(line);
				}
				public void license(String licenseStatement, boolean redistributable) throws LDRAWException {
					println("0 !LICENSE "+licenseStatement);
				}
				public void bfc(BFC bfc) throws LDRAWException {
					println("0 BFC "+bfc.toString());
				}
				private final DateFormat DATE=new SimpleDateFormat("yyyy-MM-dd");
				public void history(Date date, Name name, String message) throws LDRAWException {
					println("0 !HISTORY "+DATE.format(date)+" "+name+" "+message);
				}
				public void category(String category) throws LDRAWException {
					println("0 !CATEGORY "+category);
				}
				public void commandLine(String commandLine) throws LDRAWException {
					println("0 !CMDLINE "+commandLine);
				}
				public void keywords(List<String> keywords) throws LDRAWException {
					println("0 !KEYWORDS "+CollectionUtil.join(keywords, ", "));
				}
				public void help(String message) throws LDRAWException {
					println("0 !HELP "+message);
				}
				public void clear() throws LDRAWException {
					println("0 !CLEAR");
				}
				public void colour(String name, int code, RGBA value, Luminance luminance, Material material) throws LDRAWException {
				}
				public void pause() throws LDRAWException {
				}
				public void print(String message) throws LDRAWException {
				}
				public void save() throws LDRAWException {
				}
				public void step() throws LDRAWException {
					println("0 STEP");
				}
				public void write(String message) throws LDRAWException {
				}
				public void meta(String line) throws LDRAWException {
				}
				public void subfile(int colour, Point3f location, Matrix3f rotation, String file) throws LDRAWException {
					println("1 "+colour+" "+location+" "+rotation+" "+file);
				}
				public void line(int colour, Point3f p1, Point3f p2) throws LDRAWException {
					println("2 "+colour+" "+p1+" "+p2);
				}
				public void triangle(int colour, Point3f[] triangle) throws LDRAWException {
					String line="3 "+colour;
					for(Point3f p : triangle)
						line = line+" "+p;
					println(line);
				}
				public void quadrilateral(int colour, Point3f[] quad) throws LDRAWException {
					String line="4 "+colour;
					for(Point3f p : quad)
						line = line+" "+p;
					println(line);
				}
				public void optionalLine(int colour, Point3f[] line) throws LDRAWException {
					String l="5 "+colour;
					for(Point3f p : line)
						l = l+" "+p;
					println(l);
				}
				public void comment(String comment) throws LDRAWException {
				}
			});
			reader.read(new FileReader("/Users/aboothe/Documents/workspaces/lego/legocad/LDRAW/ldraw/parts/154.dat"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

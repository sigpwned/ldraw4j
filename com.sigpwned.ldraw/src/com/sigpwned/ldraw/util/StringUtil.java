package com.sigpwned.ldraw.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static final Pattern WHITESPACE=Pattern.compile("[\\s\\xA0]+"); // \\xA0 is &nbsp; from HTML
	public static final Pattern COMMA=Pattern.compile(",");
	
	public static MatchResult match(String string, Pattern pattern) {
		return match(string, pattern, 0);
	}

	public static MatchResult match(String string, Pattern pattern, int start) {
		MatchResult result;
		
		Matcher matcher=pattern.matcher(string);
		if(matcher.find(start))
			result = matcher;
		else
			result = null;
		
		return result;
	}
	
	public static List<String> words(String text) {
		return split(text.trim(), WHITESPACE);
	}
	
	public static List<String> split(String haystack, Pattern needle, boolean delims) {
		List<String> result=new ArrayList<String>();
		
		int start=0;
		for(MatchResult match=match(haystack, needle, start);match!=null;match=match(haystack, needle, start)) {
			if(start != match.start())
				result.add(haystack.substring(start, match.start()));
			if(delims)
				result.add(match.group());
			start = match.end();
		}
		if(start != haystack.length())
			result.add(haystack.substring(start, haystack.length()));
		
		return result;
	}
	
	public static List<String> split(String haystack, Pattern needle) {
		return split(haystack, needle, false);
	}

	public static List<String> toUpperCase(Collection<String> values) {
		List<String> result=new ArrayList<String>();
		for(String value : values)
			result.add(value.toUpperCase());
		return result;
	}

	public static List<String> toLowerCase(Collection<String> values) {
		List<String> result=new ArrayList<String>();
		for(String value : values)
			result.add(value.toLowerCase());
		return result;
	}

	public static List<String> trim(Collection<String> values) {
		List<String> result=new ArrayList<String>();
		for(String value : values)
			result.add(value.trim());
		return result;
	}
	
	public static String f(float f) {
		String result;
		
		double d=f;
		double floor=Math.floor(f);
		if(d-floor <= 0.001)
			result = Integer.toString((int) floor);
		else
			result = Float.toString(f);
		
		return result;
	}
}

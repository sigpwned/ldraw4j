package com.sigpwned.ldraw.util;

import java.util.Collection;

public class CollectionUtil {
	public static <T> String join(Collection<T> values, String join) {
		StringBuilder result=new StringBuilder();
		
		String delim="";
		for(T value : values) {
			result.append(delim);
			result.append(value==null ? "null" : value.toString());
			delim = join;
		}
		
		return result.toString();
	}
}

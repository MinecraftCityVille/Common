package de.mccityville.common.java;

public final class StringUtils {
	
	public static boolean containsCaseInsensitive(String[] array, String valueToFind) {
		for (String str : array)
			if (valueToFind.equals(str))
				return true;
		
		return false;
	}
	
	private StringUtils() { }
}

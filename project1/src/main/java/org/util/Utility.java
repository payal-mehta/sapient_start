package org.util;

public class Utility {
public static boolean isDigit(char c) {
	if(c >= '0' && c <= '9')
		return true;
	return false;
}
public static boolean isAlpha(char c) {
	if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
		return true;
	return false;
}
}

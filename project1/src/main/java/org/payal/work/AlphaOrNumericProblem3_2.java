package org.payal.work;

import org.util.Utility;

public class AlphaOrNumericProblem3_2 {
	public static  void findAlphaOrNumeric(String text){
		if (text == null || text.isEmpty()) {
	        throw new IllegalArgumentException("input word must have non-empty value.");
	    }
	    for (int i = 0; i < text.length(); i++) { 
	    	char c=text.charAt(i);
		    if(Utility.isAlpha(c)) {
		    	System.out.println(c +" is alpha ");
		    }
		    else if(Utility.isDigit(c)) {
		    	System.out.println(c +" is Numeric ");
		    }
		}
	}
	public static void main(String args[]){
	    String text = "1 2 3 AS ";
	    findAlphaOrNumeric(text);
	}
}
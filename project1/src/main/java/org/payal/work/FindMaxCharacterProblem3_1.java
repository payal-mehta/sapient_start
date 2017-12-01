package org.payal.work;

import java.util.HashMap;
import java.util.Map;


public class FindMaxCharacterProblem3_1 
{   
	public static  Character findMaxChar(String text){
		if (text == null || text.isEmpty()) {
	        throw new IllegalArgumentException("input word must have non-empty value.");
	    }
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    Character maxChar = ' ';
	    long max = Integer.MIN_VALUE;
	    for(int i=0;i<text.length();i++){
	        Character current = text.charAt(i);
	        if(map.containsKey(current)){
	            map.put(current,map.get(current)+1);
	        }
	        else{
	            map.put(current,1);
	        }
	        if(map.get(current)>max){
	            maxChar = current;
	            max = map.get(current);
	        }
	    }
	    return maxChar;
	}

	public static void main(String args[]){
	    String text = "wfaveqr caaaaaaaaaaaafwefwgqrsssssssssssssssssssssssssssssvwerwbhqfvwrfwvbetqfwef q fwgwfw erfq";
	    System.out.println("The max character is : "+ findMaxChar(text));
	}
}

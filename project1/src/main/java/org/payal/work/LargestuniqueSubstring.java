package org.payal.work;

import java.util.HashMap;
import java.util.Map;

public class LargestuniqueSubstring {
	public static void main(String[] args) {
		uniqueSubstring("asdasdfgasdfgh");
	}

	static void uniqueSubstring(String st){
	     Map<Character,Integer> map=new HashMap<Character,Integer>();
	    int index=0,start=0;
	    int maxLength=0,i=0;
	    char[] arr=st.toCharArray();
	    for(i=0;i<arr.length;){
	      if(map.containsKey(arr[i])){
	        if(map.size()>maxLength)
	        {
	          maxLength=map.size();
	          start=index;
	        }
	        i=map.get(arr[i])+1;
	        map.clear();
	        index=i;
	      }
	      else{
	        map.put(arr[i],i);
	        i++;
	      }
	    }
	    if(map.size()>maxLength){
	    	maxLength=map.size();
	          start=index;

	    }
	    System.out.println(start+" "+maxLength+" "+st.substring(start, start+maxLength));
	     
}}

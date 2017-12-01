package org.payal.work;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PangramDetector_Problem4 { private final Set<Character> missingLetters = new HashSet<Character>();  

public PangramDetector_Problem4(String s) {  
	for (char ch = 'a'; ch <= 'z'; ch++) {  
		missingLetters.add(ch);  
	}  
	s = s.toLowerCase();  
	for (int i = 0; i < s.length(); i++) {  
		missingLetters.remove(s.charAt(i));  
	}  
}  

public boolean isPangram() {  
	return missingLetters.isEmpty();  
}  

public Set<Character> getMissingAlphabets() {  
	return missingLetters;  
}  
public Set<Character> getMissingAlphabetsInOrder() {  
	return new TreeSet<Character>(missingLetters);  
} 
public static void main(String[] str){  
	String sentence1 = "a, b, c, d, e,f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, Y";  
	PangramDetector_Problem4 p1 = new PangramDetector_Problem4(sentence1);  
	if(p1.isPangram()){  
		System.out.println("Given sentence is pangram");  
	}else{  
		System.out.println("Given sentence is not pagram");
		System.out.println(p1.getMissingAlphabets());
		System.out.println(p1.getMissingAlphabetsInOrder());
	}  

}  
}

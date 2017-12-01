package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
public static void main(String[] args) throws InterruptedException {
	String[] array={"a1","a2","a3","s1","s2","s3"};
	List<String> list=Arrays.asList(array);
	for(String s:list){
		//System.out.println(Integer.parseInt(String.valueOf(s.charAt(1)))>1);
		
	}
	List<String> s1=list.stream().filter(s->Integer.parseInt(String.valueOf(s.charAt(1)))>1).map(s->s.toUpperCase())
	.sorted().collect(Collectors.toList());
	//System.out.println(s1);
	
	Stream s2=list.stream().map(s->{System.out.println("in map"+s);return s.toUpperCase();}).filter(s->{
		System.out.println("in Filter"+s);
		return (Integer.parseInt(String.valueOf(s.charAt(1)))>1);
	}).sorted();
	
	///
	
	
	Stream s3=list.stream().filter(s->Integer.parseInt(String.valueOf(s.charAt(1)))>1).map(s->s.toUpperCase())
			.sorted();
	Thread.sleep(100);
	//System.out.println("Sysout"+s2.forEach(action);());
	s2.forEach(s->System.out.println(s));
	
	
	
/*	Stream s4=list.stream().map(s->{System.out.println("in map"+s);return s.toUpperCase();}).filter(s->{
		System.out.println("in Filter"+s);
		return (Integer.parseInt(String.valueOf(s.charAt(1)))>1);
		
		s4.forEach(s->System.out.println(s));

	});*/
	
	
	Stream s4=list.stream().filter(s->Integer.parseInt(String.valueOf(s.charAt(1)))>1).map(s->s.toUpperCase())
			.sorted();
	Thread.sleep(100);
	//System.out.println("Sysout"+s2.forEach(action);());
	s2.forEach(s->System.out.println(s));
	
}
}

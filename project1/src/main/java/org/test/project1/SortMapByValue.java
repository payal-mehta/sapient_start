package org.test.project1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
	public static Map<String, String> getMap(){
		Map<String ,String> map=new HashMap<String,String>();
		map.put("A1", "second");
		map.put("b1", "first");
		map.put("g1", "third");
		map.put("h1", "fifth");
		map.put("j1", "forth");
		map.put("o1", "six");

		return map;
	}
	public static void main(String[] args) {

		Map<String ,String> map=getMap();
		Map<String ,String> sortedMap = map .entrySet() .stream()
				.sorted((e1,e2)->e1.getValue().compareTo(e2.getValue())) .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new)); 
		sortedMap.forEach((key,val)->{
			System.out.println(key+ " = "+ val.toString());

		});
	}
}

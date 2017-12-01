package org.payal.work;

import java.util.HashMap;
import java.util.Map;


public class HashMapImmutability {
public static void main(String[] args) {
	Employee e1=new Employee("a",1);
	Employee e2=new Employee("v",2);
	Employee e3=new Employee("d",3);
	Map map=new HashMap<Employee,String>();
	map.put(e1, "ss");
	map.put(e2, "ss");
	map.put(e3, "ss");
	e1.setName("aaaa");
	System.out.println(map.get(e1).toString());
}
}

class Employee{
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int id;
	
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		
		return name.length()+id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e=(Employee)obj;
		
		return name.equals(e.name) && id==e.id;
	}
}

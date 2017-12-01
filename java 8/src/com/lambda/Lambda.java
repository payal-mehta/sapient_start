package com.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Lambda {
	
public static void main(String[] args) {
	ArrayList<Employee> arrayList=new ArrayList<Employee>();
	Employee e1=new Employee(1, "a1", 123);
	Employee e2=new Employee(2, "a2", 234);
	Employee e3=new Employee(3, "a3", 345);
	
	arrayList.add(e1);
	arrayList.add(e2);
	arrayList.add(e3);
	
	
	Predicate<Integer> p1=(i)->(i>200);
	ArrayList<Employee> arrayList2=getHighPaidEmp(p1,arrayList);
		GetEmp iEmp=(e)->"S";
		sayHello(iEmp);
		
}

public static ArrayList<Employee> getHighPaidEmp(Predicate<Integer> p,ArrayList<Employee> list){
	ArrayList<Employee> result=new ArrayList<Employee>();
	for(Employee e:list){
		if(p.test(e.getSal())){
			result.add(e);
		}
		
	}
	return list;
	
}

public static void sayHello(GetEmp emp){
	Employee e1=new Employee(1, "a1", 123);
	System.out.println("Hello--->"+emp.getEmp(e1));
}

}

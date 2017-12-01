package com.car.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestCar {
public static void main(String[] args) {
	
	List<Car> list=createCarList();
	
	
	Predicate<Car> p2=(p)->p.isAutomatic();
	List<Car> autoCar=list.stream().filter(p2).collect(Collectors.toList());
	autoCar.forEach(s->System.out.println(s.getManufacture()+" Year "+s.getManufactureYear()+" Price " +s.getPrice()));
	//Car Manufacture
	
	Predicate<Car> p1=(e)->Integer.parseInt(e.getManufactureYear())>2010;
	List<Car> afterYear=list.stream().filter(car->p1.test(car)).collect(Collectors.toList());
	afterYear.forEach(s->System.out.println(s.getManufacture()+" Year "+s.getManufactureYear()+" Price " +s.getPrice()));

	//Car Manufacture groupBy
	
	Map<String, Long> map=list.stream().collect(Collectors.groupingBy(Car::getManufacture,Collectors.counting()));
	map.forEach((key, value) -> {
	    System.out.println("Key : " + key + " Value : " + value);
	});//
	
	List<Car> insPriceList=list.stream().filter(p2).filter(p1).map(s->{
		s.setPrice(s.getPrice()+s.getPrice()*5/100);
		return s;}).collect(Collectors.toList());

	insPriceList.forEach(s->System.out.println(s.getManufacture()+" Year "+s.getManufactureYear()+" Price " +s.getPrice()));
	
	List<Car> problem3 = list.stream().sorted(Comparator
			.comparing((Car car) -> car.getPrice())
			.thenComparing((Car o1, Car o2) -> o2.getManufacture().compareTo(o1.getManufacture()))).collect(Collectors.toList()); 
	problem3.forEach(s->System.out.println("problem3 "+s.getManufacture()+" Year "+s.getManufactureYear()+" Price " +s.getPrice()));

	
	
}

static List<Car> createCarList(){
	Car c1=new Car(1,"Hundai",true,"2007",10000);
	Car c7=new Car(1,"Hundai",true,"2002",20000);

	Car c2=new Car(1,"Maruti",false,"2002",5000);
	Car c3=new Car(1,"Hyunda",true,"2010",20000);
	Car c4=new Car(1,"Suzuki",true,"2012",15000);
	Car c5=new Car(1,"Tata",true,"2000",10000);
	List<Car> list=new ArrayList<Car>();
	list.add(c1);
	list.add(c2);
	list.add(c3);
	list.add(c4);
	list.add(c5);
	list.add(c7);

	return list;
	
}
}

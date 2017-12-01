package com.car.lambda;

import java.util.Date;

public class Car {
	int carId;
	String manufacture;
	Boolean isAutomatic;
	String manufactureYear;
	int price;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	public String getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Car(int carId, String manufacture, boolean isAutomatic,
			String manufactureYear, int price) {
		super();
		this.carId = carId;
		this.manufacture = manufacture;
		this.isAutomatic = isAutomatic;
		this.manufactureYear = manufactureYear;
		this.price = price;
	}
	public Car(){}
	
}

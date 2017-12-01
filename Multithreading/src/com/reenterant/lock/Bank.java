package com.reenterant.lock;

public class Bank {
int accNum;
int amount;
String name;
public Bank() {
}
public Bank(int accNum, int amount, String name) {
	super();
	this.accNum = accNum;
	this.amount = amount;
	this.name = name;
}
public int getAccNum() {
	return accNum;
}
public void setAccNum(int accNum) {
	this.accNum = accNum;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}

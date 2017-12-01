package com.lambda;

/**
 * @author pmeh12
 *
 */


public class Employee {
	
	public int empNum    ;
	String  empName;
	int  sal ;
	public Employee(int empNum, String empName, int sal) {
		super();
		this.empNum = empNum;
		this.empName = empName;
		this.sal = sal;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	 @Override
	    public String toString() {
	        return String.format(
	                "Employee[id=%d, Employee Name='%s', Sal='%d']",
	                empNum,empName, sal);
	    }
	 
}

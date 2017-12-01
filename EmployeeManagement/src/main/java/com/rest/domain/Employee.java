package com.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pmeh12
 *
 */
@Entity
@Table(name = "EMP")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "empno")
	Long  empNum;

	@Column(name = "ename")
	String  empName;
	
	@Column(name = "sal")
	int  sal ;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(Long  empNum, String empName, int sal) {
		super();
		this.empNum = empNum;
		this.empName = empName;
		this.sal = sal;
	}
	public Long  getEmpNum() {
		return empNum;
	}
	public void setEmpNum(Long  empNum) {
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

package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeDao employeeDao;
	
    public List getEmployees(){
    	return employeeDao.getEmployees();
    }
	public String saveEmployee(){
    	return employeeDao.saveEmployee();
	}
	public String deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(empId);
	}
}

package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.EmployeeService;


@RestController
@RequestMapping("/emp")
@SpringBootApplication
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public List getEmployees(){
    	return employeeService.getEmployees();
    }
	@RequestMapping("/save")
	public String saveEmployee(){
		return employeeService.saveEmployee();		
	}
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam Long empId){
		return employeeService.deleteEmployee(empId);	
		
	}
	
}

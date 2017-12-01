package com.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rest.domain.Employee;
import com.rest.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {

		List<Employee> list=new ArrayList<Employee>();
		System.out.println(employeeRepository.count());
		for(Employee emp : employeeRepository.findAll()){
			list.add(emp);
		}

		return list;
	}

	public String saveEmployee(){
		employeeRepository.save(new Employee(1L,"A1",123));
		employeeRepository.save(new Employee(2L,"A2",223));
		employeeRepository.save(new Employee(3L,"A3",323));
		employeeRepository.save(new Employee(4L,"A4",423));
		employeeRepository.save(new Employee(5L,"A5",523));
		return "Done";
	}

	public String deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}
}

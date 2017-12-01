package com.rest.repository;

import java.util.List;

import com.rest.domain.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

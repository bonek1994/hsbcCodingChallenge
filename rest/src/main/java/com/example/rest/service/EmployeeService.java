package com.example.rest.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.rest.exceptions.ResourceNotFoundException;
import com.example.rest.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Integer id, Employee employeeDetails) throws ResourceNotFoundException;

	Employee getEmployee(Integer id) throws ResourceNotFoundException;

	void deleteEmployee(Integer id);

	List<Employee> findEmployees(Specification<Employee> specifications);
}
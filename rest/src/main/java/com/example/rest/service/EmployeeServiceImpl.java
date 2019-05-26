package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.rest.exceptions.ResourceNotFoundException;
import com.example.rest.model.Employee;
import com.example.rest.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Integer id, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
		employee.setAge(employeeDetails.getAge());
		employee.setGrade(employeeDetails.getGrade());
		employee.setName(employeeDetails.getName());
		employee.setSurname(employeeDetails.getSurname());
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployee(Integer id) throws ResourceNotFoundException{
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findEmployees(Specification<Employee> specifications) {
		return employeeRepository.findAll(specifications);
	}
}

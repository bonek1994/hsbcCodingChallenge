package com.example.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.exceptions.ResourceNotFoundException;
import com.example.rest.model.Employee;
import com.example.rest.service.EmployeeService;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@PathVariable("id") Integer id, @Valid @RequestBody Employee employeeDetails) 
			throws ResourceNotFoundException {
		employeeService.updateEmployee(id, employeeDetails);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping
	public List<Employee> findEmployees(
			@And({
				@Spec(path = "name", spec = Equal.class),
				@Spec(path = "surname", spec = Equal.class),
				@Spec(path = "age", spec = Equal.class),
				@Spec(path = "grade", spec = Equal.class)
			}) Specification<Employee> specifications) {
		return employeeService.findEmployees(specifications);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}
}

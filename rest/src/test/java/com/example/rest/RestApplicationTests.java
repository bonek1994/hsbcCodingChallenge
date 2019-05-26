package com.example.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	
	private String getLocalAddress() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testEmployeeCreated() {
		Employee empl = createTestEmployee();
		ResponseEntity<Employee> response = restTemplate.postForEntity(getLocalAddress() + "/employees", empl, Employee.class);
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertSame(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void testGetEmployeeById() {
		ResponseEntity<Employee> response = restTemplate.getForEntity(getLocalAddress() + "/employees/1", Employee.class);
		assertNotNull(response);
	}
	
	@Test
	public void testUpdateEmployeeById() {
		Employee empl = createTestEmployee();
		restTemplate.put(getLocalAddress() + "/users/1", empl);
		ResponseEntity<Employee> response = restTemplate.getForEntity(getLocalAddress() + "/employees/1", Employee.class);
		assertNotNull(response);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testDeleteEmployeeById() {
		restTemplate.delete(getLocalAddress() + "/employees/1");
		ResponseEntity<Employee> response = restTemplate.getForEntity(getLocalAddress() + "/employees/1", Employee.class);
		assertNotNull(response);
		assertSame(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
    @Test
    public void getAll() {
    	ResponseEntity<Employee[]> employees = restTemplate.getForEntity(getLocalAddress() + "/employees",
    			Employee[].class);
    	assertNotNull(employees);
    }
    
	private Employee createTestEmployee() {
		Employee empl = new Employee();
		empl.setName("John");
		empl.setSurname("Wick");
		empl.setAge(36);
		empl.setGrade(5);
		return empl;
	}
}

package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.demoapp.employees.EmployeeResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTests {

	@Autowired 
	private TestRestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getEmployeeById() {
		// Arrange
		int id = 1;
		Employee employee100 = new Employee();
		employee100.setName("natdanai");
		employeeRepository.save(employee100);
		
		// Action
		EmployeeResponse result 
			= restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
	
		//Assert
		assertEquals(id, result.getId());
		assertEquals("natdanai", result.getName());
	}
	
	@Test
	public void listEmployee() {
		// Action
		EmployeeResponse[] results 
			= restTemplate.getForObject("/employees", EmployeeResponse[].class);
	
		//Assert
		assertEquals(2, results.length);
	}

}

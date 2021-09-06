package com.example.demoapp;

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
	
	@Test
	public void listEmployee() {
		// Action
		EmployeeResponse[] results 
			= restTemplate.getForObject("/employees", EmployeeResponse[].class);
	
		//Assert
		assertEquals(2, results.length);
	}

}

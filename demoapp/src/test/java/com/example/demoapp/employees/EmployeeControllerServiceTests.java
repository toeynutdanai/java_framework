package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.demoapp.employees.EmployeeResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerServiceTests {

	@Autowired 
	private TestRestTemplate restTemplate;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	@DisplayName("Success case")
	public void case01() {
		// Arrange
		int id = 1;
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("natdanai");
		when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
		// Action
		EmployeeResponse result 
			= restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
	
		//Assert
		assertEquals(id, result.getId());
		assertEquals("natdanai", result.getName());
	}

}

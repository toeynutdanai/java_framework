package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerWebMvcTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void getEmployeeById() throws Exception {
		int id = 100;
		MvcResult result =  mvc.perform(get("/employees/" + 100))
			.andExpect(status().isOk())
			.andReturn();
		// Response body
		byte[] json = result.getResponse().getContentAsByteArray();
		ObjectMapper mapper = new ObjectMapper();
		EmployeeResponse response = mapper.readValue(json, EmployeeResponse.class);
		// Assert
		assertEquals(id, response.getId());
		assertEquals("natdanai", response.getName());
	}

}

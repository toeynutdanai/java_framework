package com.example.demoapp.employees;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeResponse getById(int id) {
//		EmployeeResponse response = new EmployeeResponse();
//		response.setId(id);
//		response.setName("natdanai");
		
		Optional<Employee> result = employeeRepository.findById(id);
		if(result.isPresent()) {
			//Map data from entity to response
			EmployeeResponse response = new EmployeeResponse();
			response.setId(result.get().getId());
			response.setName(result.get().getName());
			return response;
		}
		throw new EmployeeNotFoundException("Employee not found id=" + id);
	}
	
}

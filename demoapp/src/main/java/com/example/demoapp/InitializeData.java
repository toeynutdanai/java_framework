package com.example.demoapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demoapp.employees.Employee;
import com.example.demoapp.employees.EmployeeRepository;

@Configuration
public class InitializeData {
//	ไม่ค่อยได้ใช้
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@PostConstruct
	public void xxxx() {
		Employee employee = new Employee();
		employee.setId(1000);
		employee.setName("Natdanai");
		employeeRepository.saveAndFlush(employee);
	}
}

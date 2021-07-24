package com.universal.rest.webservices.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeDAOService service;
	
	@PostMapping("/add-employee")
	public String addUser(@RequestBody Employee employee) {
		
		long id = service.insert(employee);
		return "Employee created :  "+ employee.toString();
		
	}

}

package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomException;
import com.masai.model.Employees;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home() {
		return "Task Manager API";
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employees> createEmployee(@RequestBody @Valid Employees employee) throws CustomException{
		
		Employees emp = employeeService.createEmployee(employee);
		
		return new ResponseEntity<Employees>(emp,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employee/{empID}")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable Integer empID) throws CustomException{
		
		Employees emp = employeeService.getEmployeeById(empID);
		
		return new ResponseEntity<Employees>(emp,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/employee/{empID}")
	public ResponseEntity<Employees> deleteEmployee(@PathVariable Integer empID) throws CustomException{
		
		Employees emp = employeeService.deleteEmployee(empID);
		
		return new ResponseEntity<Employees>(emp,HttpStatus.OK);
		
	}
	
}

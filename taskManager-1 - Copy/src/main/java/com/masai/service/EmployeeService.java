package com.masai.service;

import com.masai.exceptions.CustomException;
import com.masai.model.Employees;

public interface EmployeeService {

	public Employees createEmployee(Employees employee) throws CustomException;
	
	public Employees getEmployeeById(Integer empID) throws CustomException;
	
	public Employees deleteEmployee(Integer empID) throws CustomException;
	
}

	package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomException;
import com.masai.model.Employees;
import com.masai.repositery.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employees createEmployee(Employees employee) throws CustomException {
		
		if(employee!=null)
		{
			return employeeDAO.save(employee);
		}
		else
		{
			throw new CustomException("Please provide correct info");
		}
	
	}

	@Override
	public Employees getEmployeeById(Integer empID) throws CustomException {
		
		Employees employee = employeeDAO.findById(empID).orElseThrow(()-> new CustomException("No employee found with id : "+empID));
		
		return employee;
	}

	@Override
	public Employees deleteEmployee(Integer empID) throws CustomException {
		
		Employees employee = employeeDAO.findById(empID).orElseThrow(()-> new CustomException("No employee found with id : "+empID));
		
		employeeDAO.delete(employee);
		
		return employee;
		
	}

}

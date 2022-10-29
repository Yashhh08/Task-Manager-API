package com.masai.service;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.masai.exceptions.CustomException;

import com.masai.model.Tasks;

public interface TaskService {

	public Tasks createTask(Tasks task, Integer empID) throws CustomException;
	
	public List<Tasks> getTaskByDeadLine(String startDate, String endDate) throws CustomException;
	
	public List<Tasks> getTaskByDeadLineOrderBy(String starDate, String endDate) throws CustomException;
	
	public List<Tasks> getTaskByEmployeeId(Integer EmpID) throws CustomException;
	
	public Tasks updateTask(Integer taskID, Tasks task, Integer empID) throws CustomException;
	
	public void deleteTask(Integer taskID) throws CustomException;

}

package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomException;
import com.masai.model.Employees;
import com.masai.model.Tasks;
import com.masai.repositery.EmployeeDAO;
import com.masai.repositery.TaskDAO;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private TaskDAO taskDAO;
	
	@Override
	public Tasks createTask(Tasks task, Integer empID) throws CustomException {
		
		Employees emp = employeeDAO.findById(empID).orElseThrow(()->new CustomException("employee does not found with empID : "+empID));
		
		if(task!=null)
		{
			emp.getTasks().add(task);
			
			task.setEmployee(emp);
			
			return taskDAO.save(task);
		
		}
		else
		{
			throw new CustomException("Please provide correct info");
		}
		
	}

	@Override
	public List<Tasks> getTaskByDeadLine(String startDate, String endDate) throws CustomException {
		
	   List<Tasks> tasks = taskDAO.getTaskByDeadLine(startDate, endDate);
	   
	   if(tasks.isEmpty())
	   {
		   throw new CustomException("No tasks found..");
	   }
	   else
	   {
		   return tasks;
	   }
		
	}

	@Override
	public List<Tasks> getTaskByDeadLineOrderBy(String startDate, String endDate) throws CustomException {
		
		return null;
		
	}

	@Override
	public List<Tasks> getTaskByEmployeeId(Integer EmpID) throws CustomException {
		
		employeeDAO.findById(EmpID).orElseThrow(()->new CustomException("No employee found with id : "+EmpID ));
		
		List<Tasks> tasks = taskDAO.getTaskByEmployeeId(EmpID);
		
		if(tasks.isEmpty())
		{
			throw new CustomException("No tasks pending..");
		}
		else
		{
			return tasks;
		}
		
	}

	@Override
	public Tasks updateTask(Integer taskID, Tasks task, Integer empID) throws CustomException {
		
		taskDAO.findById(taskID).orElseThrow(()->new CustomException("No task found with id : "+taskID));
		
		Employees emp = employeeDAO.findById(empID).orElseThrow(()->new CustomException("No employee found with id : "+empID));
		
		task.setEmployee(emp);
		
		return taskDAO.save(task);
		
	}

	@Override
	public void deleteTask(Integer taskID) throws CustomException {
		
		Tasks task = taskDAO.findById(taskID).orElseThrow(()->new CustomException("No task found with id : "+taskID));
		
		taskDAO.deleteTask(taskID);
		
		System.out.println("deleted task : "+taskID); 
	}

}

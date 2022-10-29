package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomException;
import com.masai.model.Tasks;
import com.masai.service.EmployeeService;
import com.masai.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/task/{empID}")
	public ResponseEntity<Tasks> createTask(@RequestBody @Valid Tasks task, @PathVariable Integer empID) throws CustomException{
		
		Tasks createdTask = taskService.createTask(task,empID);
		
		return new ResponseEntity<Tasks>(createdTask,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Tasks>> getTaskByDeadLine(@RequestParam("start_date") String start_date,@RequestParam("end_date") String end_date) throws CustomException{
		
		List<Tasks> tasks = taskService.getTaskByDeadLine(start_date, end_date);
		
		return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
		
	}
	
	@GetMapping("/tasks/employee_id={EmpID}")
	public ResponseEntity<List<Tasks>> getTaskByEmployeeId(@PathVariable Integer EmpID) throws CustomException{
		
		List<Tasks> tasks = taskService.getTaskByEmployeeId(EmpID);
		
		return new ResponseEntity<List<Tasks>>(tasks,HttpStatus.OK);
		
	}
	
	@PutMapping("/tasks/{taskID}/{empID}")
	public ResponseEntity<Tasks> updateTask(@PathVariable Integer taskID,@RequestBody Tasks task, @PathVariable Integer empID) throws CustomException{
		
		Tasks tasks = taskService.updateTask(taskID, task, empID);
		
		return new ResponseEntity<Tasks>(tasks,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/tasks/{taskID}")
	public ResponseEntity<Void> deleteTask(@PathVariable Integer taskID) throws CustomException{
		
		taskService.deleteTask(taskID);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}

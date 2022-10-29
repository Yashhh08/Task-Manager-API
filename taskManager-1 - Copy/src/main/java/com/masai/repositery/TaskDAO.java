package com.masai.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.masai.exceptions.CustomException;
import com.masai.model.Employees;
import com.masai.model.Tasks;

@Repository
public interface TaskDAO extends JpaRepository<Tasks, Integer>{
 
	@Query("select t from Tasks as t where start_Date >= ?1  and end_Date <= ?2")
	public List<Tasks> getTaskByDeadLine(String startDate, String endDate) throws CustomException;
	
	@Query("select t from Tasks as t where start_Date >= ?1  and end_Date <= ?2 order by end_Date")
	public List<Tasks> getTaskByDeadLineOrderBy(String starDate, String endDate) throws CustomException;
	
	@Query("select t from Tasks as t where employee_empID = ?1")
	public List<Tasks> getTaskByEmployeeId(Integer empID) throws CustomException;

	@Transactional
	@Modifying
	@Query("delete from Tasks where taskID = ?1")
	public void deleteTask(Integer taskID) throws CustomException;
	
}

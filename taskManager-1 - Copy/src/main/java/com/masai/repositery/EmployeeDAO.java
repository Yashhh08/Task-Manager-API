package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Employees;

@Repository
public interface EmployeeDAO extends JpaRepository<Employees, Integer> {

}

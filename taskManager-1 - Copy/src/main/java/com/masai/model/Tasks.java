package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskID;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@NotNull
	private Boolean status;
	
	@NotNull
	private String priority;
	
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Employees employee;
	
}

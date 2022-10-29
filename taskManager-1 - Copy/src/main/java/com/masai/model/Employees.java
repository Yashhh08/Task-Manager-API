package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empID;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String state;
	
	@Pattern(regexp = "[0-9]{10}")
	private String mobile;
	
	@NotNull
	private String designation;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Tasks> tasks = new ArrayList<>();
	
}

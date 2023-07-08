package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
//	Column(length=30)
//	private String FirstName;
//	@Column(length=30)
//	private String LastName;
//	@Column(length=20)
//	private String email;
//	@Column(length=10)
//	private String Password;
//	@Column
//	private LocalDate JoinDate;
//	@Column
//	private double Salary;
	
	private String FirstName;
	private String LastName;
	private String email;
	private String Password;
	private LocalDate JoinDate;
	private double Salary;
	private String AssignedDept;
	

}

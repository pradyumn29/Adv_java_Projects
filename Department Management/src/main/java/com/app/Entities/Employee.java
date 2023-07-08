package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Employee extends BaseEntity{
	
	@Column(length=30)
	private String FirstName;
	@Column(length=30)
	private String LastName;
	@Column(length=20)
	private String email;
	@Column(length=10)
	private String Password;
	@Column
	private LocalDate JoinDate;
	@Column
	private double Salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	private Department AssignedDept;
	

}

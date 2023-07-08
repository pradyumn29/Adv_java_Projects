package com.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="dept")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class Department extends BaseEntity {

	@Column(length=20)
	private String DeptName;
	
	@Column(length=20)
	private String Location;
	
	@OneToMany(mappedBy = "AssignedDept",cascade=CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private	List<Employee>EmployeeList=new ArrayList<>();
	
	public boolean addstudent(Employee s) {
		EmployeeList.add(s);
		s.setAssignedDept(this);
		return true;
	}

}

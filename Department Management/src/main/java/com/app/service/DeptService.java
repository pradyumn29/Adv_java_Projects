package com.app.service;

import java.util.List;

import com.app.Entities.Department;
import com.app.dto.DepartmentDTO;

public interface DeptService {

	List<Department> getAllDept();
	
	
	
	Department Updatedept(Department dept);
	
	String DeleteDept(Long Id);

	String AddDept(DepartmentDTO dept);
	
}

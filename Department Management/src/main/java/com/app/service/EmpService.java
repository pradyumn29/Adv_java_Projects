package com.app.service;

import java.util.List;

import com.app.Entities.Employee;
import com.app.dto.EmployeeDTO;

public interface EmpService {
	
	List<Employee> getAllEmp();
	
	Employee AddEmp(EmployeeDTO emp);
	
	String DeleteEmp(Long id);
	
	Employee UpdateEmp(Employee emp);
	
	Employee getbyId(Long id);
	EmployeeDTO addEmps(EmployeeDTO ed);

}

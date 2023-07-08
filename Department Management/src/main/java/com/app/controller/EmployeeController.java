package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Department;
import com.app.Entities.Employee;
import com.app.dto.EmployeeDTO;
import com.app.service.DeptService;
import com.app.service.EmpService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmpService empServ;
	@Autowired
	private DeptService deptService;
	@GetMapping("/")
	public List<Employee> getAllEmp(){
		return empServ.getAllEmp();
	}
	
	@PostMapping("/emp")
	public EmployeeDTO addEmp(@RequestBody EmployeeDTO ed) {
		return empServ.addEmps(ed);
	}
	
	@PostMapping
	public ResponseEntity<Employee> AddEmp(@RequestBody EmployeeDTO emp) {
		
		return new ResponseEntity<>(empServ.AddEmp(emp),HttpStatus.CREATED);
	}
	
	@PutMapping
	public Employee UpdateEmp(@RequestBody Employee emp) {
		return empServ.UpdateEmp(emp);
	}
	
	@DeleteMapping("/{id}")
     public String deleteEmp(@PathVariable Long id) {
		String msg=empServ.DeleteEmp(id);
		
		return msg;
	}
}

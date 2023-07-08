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
import com.app.dto.ApiresponseDTO;
import com.app.dto.DepartmentDTO;
import com.app.service.DeptService;

@RestController
@RequestMapping("/department")
public class DeptConntroller {
	
	@Autowired
	private DeptService DeptServ;
	
	@GetMapping("/")
	public List<Department> getAllDept(){
		return DeptServ.getAllDept();
	}
	
	@PostMapping
	public ApiresponseDTO AddDept(@RequestBody DepartmentDTO dept) {
		return new ApiresponseDTO(DeptServ.AddDept(dept));
	}
	
	@PutMapping
	public Department UpdateDept(@RequestBody Department dept) {
		return DeptServ.Updatedept(dept);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteDept(@PathVariable Long Id) {
		String msg=DeptServ.DeleteDept(Id);
		return msg;
	}
	

}

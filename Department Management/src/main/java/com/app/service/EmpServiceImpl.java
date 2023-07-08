package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.Department;
import com.app.Entities.Employee;
import com.app.Repository.DeptRepo;
import com.app.Repository.EmployeeRepo;
import com.app.dto.EmployeeDTO;
import com.app.exception.CustomisedException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmployeeRepo EmpRepo;
	
	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private DeptRepo dr;
	
	@Override
	public List<Employee> getAllEmp() {
		
		return EmpRepo.findAll();
	}

	@Override
	public Employee AddEmp(EmployeeDTO emp) {
	
		Employee e=mp.map(emp, Employee.class); 
		Employee e1=EmpRepo.save(e);
		return e1;
	 
	}
	
	public EmployeeDTO addEmps(EmployeeDTO ed) {
		Department d1 = dr.findByDeptName(ed.getAssignedDept()).orElseThrow(()->new CustomisedException("Course not found"));
		Employee e1 = mp.map(ed, Employee.class);
		
		d1.addstudent(e1);
		Employee e3 = EmpRepo.save(e1);
		
		EmployeeDTO e2=mp.map(e3,EmployeeDTO.class);
		return e2;
		
	}

	@Override
	public String DeleteEmp(Long id) {
		String msg="not deleted";
		if(EmpRepo.existsById(id)) {
			EmpRepo.deleteById(id);
			msg="deleted";
		}
		return msg;
	}

	@Override
	public Employee UpdateEmp(Employee emp) {
		
		return EmpRepo.save(emp);
	}

	@Override
	public Employee getbyId(Long id) {
		
		return EmpRepo.findById(id).orElseThrow(()->new CustomisedException("error in id"));
	}

}

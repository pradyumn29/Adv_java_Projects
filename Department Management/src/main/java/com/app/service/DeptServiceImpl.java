package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.Department;
import com.app.Repository.DeptRepo;
import com.app.dto.DepartmentDTO;
import com.app.exception.CustomisedException;
@Service
@Transactional

public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptRepo dRepo;
	
	@Autowired
	private ModelMapper mp;
	
	@Override
	public List<Department> getAllDept() {
	
		return dRepo.findAll();
	}

	@Override
	public String AddDept(DepartmentDTO dept) {

        Department d=mp.map(dept,Department.class);
        Department d1=dRepo.save(d);
        if(d1==null)
        	throw new CustomisedException("course insertion unsuccesfull");
		return "department added!!!";
	}

	@Override
	public Department Updatedept(Department dept) {

		return dRepo.save(dept);
	}

	@Override
	public String DeleteDept(Long Id) {
        String msg="not deleted";
         if(dRepo.existsById(Id)) {
        	 dRepo.deleteById(Id);
        	 msg="deleted";
         }
         return msg;
     }
}



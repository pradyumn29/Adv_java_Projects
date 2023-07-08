package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Department;

public interface DeptRepo extends JpaRepository<Department, Long> {
	
	Optional<Department> findByDeptName(String dname);
}

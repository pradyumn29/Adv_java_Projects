package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}

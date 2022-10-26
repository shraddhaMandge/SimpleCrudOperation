package com.example.Organisation.repo;


import com.example.Organisation.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//@Query(value = "select * from Employee where empName=:empNname", nativeQuery = true)
	List<Employee> findByEmpName(String empName);

	List<Employee> findByEmpAge(int empAge);
	
	
}

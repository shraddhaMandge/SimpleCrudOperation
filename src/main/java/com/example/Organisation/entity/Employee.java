package com.example.Organisation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
public class Employee {
	
	@Id
	public Long empId;
	public String empName;
	public Long empSalary;
	public int empAge;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public Employee(Long empId, String empName, Long empSalary, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

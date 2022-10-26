package com.example.Organisation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Organisation.entity.Employee;
import com.example.Organisation.repo.EmployeeRepository;

@RestController
@RequestMapping(path = "/Employee/", produces = MediaType.APPLICATION_JSON_VALUE)

public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("getEmployee")
	public ResponseEntity<List<Employee>> getEmployee(){		
		 List<Employee> emp = repo.findAll();
		return ResponseEntity.ok().body(emp);		
	}
	
	@PostMapping("create")
	public String createEmployee(@RequestBody Employee emp){
		repo.save(emp);
		return "Employee created sucessufully";	
	}

    @GetMapping("/emp/{empName}")
    public List<Employee> findEmployeeByName(@PathVariable String empName) {
        return repo.findByEmpName(empName);
    }
    
    @GetMapping("emp/{empAge}")
	public List<Employee> FindByAge(int empAge){
		List<Employee> emp=repo.findByEmpAge(empAge);
		return emp;
	}
	
	@PutMapping("update")
	public String updateEmployee(@RequestBody Employee emp){
		Employee existingEmployee = repo.findById(emp.empId).orElse(null);
		existingEmployee.setEmpId(emp.getEmpId());
		existingEmployee.setEmpName(emp.getEmpName());
		existingEmployee.setEmpAge(emp.getEmpAge());
		existingEmployee.setEmpSalary(emp.getEmpSalary());		 
			Employee employee=repo.save(existingEmployee);
			return "updated Sucessufully"+"/n"+ employee;
		
	}
	
	@DeleteMapping("delete/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		repo.deleteById(empId);
		return "deleted Sucessufully";
		
	}
	
	
}

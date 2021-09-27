package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmplyeeRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmplyeeController {
	
	@Autowired
	EmplyeeRepo employeeRepo;
	
	@GetMapping("/employees")
	public List<Employee> getALLEmployess() {
		
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeRepo.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :"+ id));
		
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employeeDetails) {
		
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :"+ id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		
		Employee updatedEmployee = employeeRepo.save(employee);
		
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :"+ id));
		
		employeeRepo.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
}

package com.app.controller;

import java.util.*;

import javax.validation.Valid;

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

import com.app.dto.ApiResponse;
import com.app.dto.ReqAuthDTO;
import com.app.entities.Employee;
import com.app.service.EmployeeService;


@RestController  //@Controller+@Responsebody
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("In constructor of Emp controller");
	}
	
	@GetMapping
	public List<Employee> listEmps()
	{
		System.out.println("in get method");
		return empService.getAllEmployees();
	}
	
	@PostMapping
	public ResponseEntity<?> saveEmpDetails(@RequestBody Employee transientEmp) {
		System.out.println("in post method");
		System.out.println("in save " + transientEmp);// not null , id : null
		return new ResponseEntity<>(empService.addEmpDetails(transientEmp), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{empId}")
	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
		return new ApiResponse(empService.deleteEmpdetails(empId));
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployeeData(@PathVariable Long empId)
	{
		return empService.getEmpData(empId);
	}
	
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEntity)
	{
		return empService.updateEmpData(detachedEntity);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid ReqAuthDTO reqdto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(empService.authenticateEmp(reqdto));
	}
}


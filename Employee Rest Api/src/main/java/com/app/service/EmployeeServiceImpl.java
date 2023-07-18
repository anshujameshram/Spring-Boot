package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ReqAuthDTO;
import com.app.dto.RespAuthDTO;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	ModelMapper mapper;
	
	public EmployeeServiceImpl() {
		System.out.println("in contr of Emp service");
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee transientData) {
		
		return empRepo.save(transientData);
	}

	@Override
	public String deleteEmpdetails(Long empId) {
		String msg="cannot be deleted!!";
		if(empRepo.existsById(empId))
		{
			empRepo.deleteById(empId);
			msg=" Emp id "+empId+"deleted!!";
			
		}
		return msg;
	}

	@Override
	public Employee getEmpData(Long empId) {
		
		return empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Not found!!!"));
	}

	@Override
	public Employee updateEmpData(Employee detachedEntity) {
		return empRepo.save(detachedEntity);
	}

	@Override
	public Object authenticateEmp(ReqAuthDTO reqdto) {
		Employee emp=empRepo.findByEmailAndPassword(reqdto.getEmail(), reqdto.getPassword())
				.orElseThrow(()->new ResourceNotFoundException("Invalid email and password!!!"));
		RespAuthDTO respdto=mapper.map(emp,RespAuthDTO.class);
		return respdto;
	}
	
	

}

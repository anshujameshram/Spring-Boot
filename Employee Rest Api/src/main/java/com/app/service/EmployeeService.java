package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ReqAuthDTO;
import com.app.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee addEmpDetails(Employee transientData);

	String deleteEmpdetails(Long empId);

	Employee getEmpData(Long empId);

	Employee updateEmpData(Employee detachedEntity);

	Object authenticateEmp( ReqAuthDTO reqdto);

}

package com.spring.boot.complaint.service;

import org.springframework.stereotype.Component;

import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.response.ResponseDTO;

@Component
public interface EmployeeService {
	
	public void register(Employee emp);

	public void registerEmpByAdmin(Long adminId, Employee emp);

	public void deleteEmp(Long empId);
	
	public ResponseDTO findCompByType(Long id,String type);
	
	public ResponseDTO findCompByStatus(Long id,String type);
	
	public ResponseDTO findAllComp(Long id);


}

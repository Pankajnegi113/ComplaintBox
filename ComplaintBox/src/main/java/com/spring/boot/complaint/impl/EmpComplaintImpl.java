package com.spring.boot.complaint.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.complaint.model.Admin;
import com.spring.boot.complaint.model.EmpComplaint;
import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.repository.EmpComplaintRepository;
import com.spring.boot.complaint.repository.EmployeeRepository;
import com.spring.boot.complaint.service.EmpComplaintService;

@Service
public class EmpComplaintImpl implements EmpComplaintService {

	@Autowired
	EmpComplaintRepository empComplaintRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//register complaint by employee with empId- set default to unresolved
	@Override
	public void registerComplaint(Long empId,EmpComplaint complaint) {
		Employee currentEmp = employeeRepository.findById(empId).orElseThrow(()->new NullPointerException("Employee id"+empId+"doesn't exist"));
		currentEmp.getEmpComplaint().add(complaint);
		complaint.setEmployee(currentEmp);
		complaint.setStatus("unresolved");
		employeeRepository.save(currentEmp);
	}

}

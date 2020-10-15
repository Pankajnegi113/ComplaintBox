package com.spring.boot.complaint.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminCompDTO {
	private Long empId;
	private String empName;
	private String status;
	
	public AdminCompDTO()
	{
	
	}
	
	public AdminCompDTO( Long empId, String empName,String status) {
		super();
		this.status = status;
		this.empId = empId;
		this.empName = empName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
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
 
}

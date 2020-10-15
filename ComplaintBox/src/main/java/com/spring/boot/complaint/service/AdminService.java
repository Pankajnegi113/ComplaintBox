package com.spring.boot.complaint.service;

import org.springframework.stereotype.Component;

import com.spring.boot.complaint.model.Admin;

import com.spring.boot.complaint.response.ResponseDTO;

@Component
public interface AdminService {
	public void registerAdmin(Admin admin);
	public ResponseDTO findAllJobs();
	public void resolveComp(Long compId);
	

}

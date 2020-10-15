package com.spring.boot.complaint.service;

import org.springframework.stereotype.Component;

import com.spring.boot.complaint.model.EmpComplaint;

@Component
public interface EmpComplaintService {
	public void registerComplaint(Long empId, EmpComplaint complaint);

}

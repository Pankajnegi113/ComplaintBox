package com.spring.boot.complaint.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.complaint.dto.AdminCompDTO;
import com.spring.boot.complaint.model.Admin;
import com.spring.boot.complaint.model.EmpComplaint;
import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.model.Vendor;
import com.spring.boot.complaint.repository.AdminRepository;
import com.spring.boot.complaint.repository.EmpComplaintRepository;
import com.spring.boot.complaint.response.ResponseDTO;
import com.spring.boot.complaint.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	EmpComplaintRepository empComplaintRepository;
	
	//register admin
	public void registerAdmin(Admin admin) {
		adminRepository.save(admin);

	}

	//get all jobs/complaints by admin
	@Override
	public ResponseDTO findAllJobs() {
		ResponseDTO responseDTO = new ResponseDTO<>();
		List<AdminCompDTO> adminCompDto = adminRepository.findAllComplaints();
        if (Objects.nonNull(adminCompDto) && adminCompDto.size()>0) {
            responseDTO = new ResponseDTO<>();
            responseDTO.setMessage("Offers List Fetched SuccessFully");
            responseDTO.setSuccess(true);
            responseDTO.setData(adminCompDto);
        } else {
            responseDTO.setMessage("No Data Found");
            responseDTO.setSuccess(false);
        }
        return responseDTO;
		
	}

	//get all complaints by complaint id
	@Override
	public void resolveComp(Long compId) {
		EmpComplaint currentComp = empComplaintRepository.findById(compId).orElseThrow(()->new NullPointerException("Complaint with id"+compId+"doesn't exist"));
		currentComp.setStatus("resolved");
		empComplaintRepository.save(currentComp);	
	}


}

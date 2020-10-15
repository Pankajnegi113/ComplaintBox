package com.spring.boot.complaint.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.complaint.model.Admin;
import com.spring.boot.complaint.model.EmpComplaint;
import com.spring.boot.complaint.model.Vendor;
import com.spring.boot.complaint.repository.AdminRepository;
import com.spring.boot.complaint.repository.EmpComplaintRepository;
import com.spring.boot.complaint.repository.VendorRepository;
import com.spring.boot.complaint.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository VendorRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	EmpComplaintRepository empComplaintRepository;
	
	@Override
	public void registerVendorByAdmin(Long adminId, Vendor vendor) {
		Admin currentAdmin = adminRepository.findById(adminId).orElseThrow(()->new NullPointerException("Admin id"+adminId+"doesn't exist"));
		currentAdmin.getVendor().add(vendor);
		vendor.setAdmin(currentAdmin);
		adminRepository.save(currentAdmin);
		
	}

	@Override
	public void deleteVendor(Long vendorId) {
		if(VendorRepository.existsById(vendorId))
			VendorRepository.deleteById(vendorId);
		else
			throw new RuntimeException("No such id present to be deleted");	
	}
	
	@Override
	public void resolveComp(Long compId) {
		EmpComplaint currentComp = empComplaintRepository.findById(compId).orElseThrow(()->new NullPointerException("Complaint with id"+compId+"doesn't exist"));
		currentComp.setStatus("resolved");
		empComplaintRepository.save(currentComp);	
	}

}

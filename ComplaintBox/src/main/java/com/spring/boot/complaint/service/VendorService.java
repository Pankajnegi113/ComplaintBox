package com.spring.boot.complaint.service;

import org.springframework.stereotype.Component;

import com.spring.boot.complaint.model.Vendor;

@Component
public interface VendorService {
	
	public void registerVendorByAdmin(Long adminId, Vendor vendor);

	public void deleteVendor(Long vendorId);
	
	public void resolveComp(Long compId);

}

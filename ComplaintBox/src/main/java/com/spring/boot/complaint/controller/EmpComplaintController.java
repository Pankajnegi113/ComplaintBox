package com.spring.boot.complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.complaint.model.EmpComplaint;
import com.spring.boot.complaint.service.EmpComplaintService;
import com.spring.boot.complaint.service.VendorService;

@RestController
public class EmpComplaintController {
	
	@Autowired
	EmpComplaintService empComplaintService;
	
	@Autowired
	VendorService vendorService;
	
	//save employee complaint having id {id} and body with type/job as Mpbile/Laptop/Table
	@RequestMapping( value ="/empComplaint/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> register(@PathVariable(name = "id")Long empId,@RequestBody EmpComplaint complaint)
	{
		empComplaintService.registerComplaint(empId,complaint);
		return new ResponseEntity<>("Complaint registered successfully",HttpStatus.CREATED);
	}
	
	//resolving employee with id {id} complaint by vendor
	@RequestMapping( value ="/vendor/resolveCom/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> resolveComp(@PathVariable(name = "id") Long compId)
	{
		vendorService.resolveComp(compId);
		return new ResponseEntity<>("Complaint id "+compId+" resolved successfully",HttpStatus.OK);
	}
	
	
	
	

}

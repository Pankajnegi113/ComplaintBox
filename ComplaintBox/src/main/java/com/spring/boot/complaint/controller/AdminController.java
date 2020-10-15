package com.spring.boot.complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.complaint.dto.AdminCompDTO;
import com.spring.boot.complaint.model.Admin;
import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.model.Vendor;
import com.spring.boot.complaint.response.ResponseDTO;
import com.spring.boot.complaint.response.ResponseHandler;
import com.spring.boot.complaint.service.AdminService;
import com.spring.boot.complaint.service.EmployeeService;
import com.spring.boot.complaint.service.VendorService;

import antlr.collections.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	VendorService vendorService;
	
	//registeration of admin by providing email and password
	@RequestMapping( value ="/register", method = RequestMethod.POST  )
	public ResponseEntity<String> register(@RequestBody Admin admin)
	{
		adminService.registerAdmin(admin);
		return new ResponseEntity<>("Admin registered successfully",HttpStatus.CREATED);
	}
	
	//registeration of employee by admin (admin with id{id})
	@RequestMapping( value ="/{id}/registerEmp", method = RequestMethod.POST  )
	public ResponseEntity<String> registerEmployee(@PathVariable(name = "id") Long adminId ,@RequestBody Employee employee)
	{
		empService.registerEmpByAdmin( adminId, employee);
		return new ResponseEntity<>("Employee registered by Admin successfully",HttpStatus.CREATED);
	}
	
	//registeration of vendor by admin (admin with id{id})
	@RequestMapping( value ="/{id}/registerVendor", method = RequestMethod.POST  )
	public ResponseEntity<String> registerVendor(@PathVariable(name = "id") Long adminId ,@RequestBody Vendor vendor)
	{
		vendorService.registerVendorByAdmin( adminId, vendor);
		return new ResponseEntity<>("Vendor registered by Admin successfully",HttpStatus.CREATED);
	}
	
	//delete employee with id {id} by admin
	@RequestMapping( value ="/deleteEmp/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long empId )
	{
		empService.deleteEmp( empId );
		return new ResponseEntity<>("Employee with id "+empId+" deleted successfully",HttpStatus.OK);
	}
	
	//delete vendor with id {id} by admin
	@RequestMapping( value ="/deleteVendor/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> deleteVendor(@PathVariable(name = "id") Long vendorId )
	{
		vendorService.deleteVendor( vendorId );
		return new ResponseEntity<>("Vendor with id "+vendorId+" deleted successfully",HttpStatus.OK);
	}
	
	//find all complaints of employee with empId,their email and status
	@RequestMapping( value ="/findAllComplaints", method = RequestMethod.GET  )
	public ResponseEntity <ResponseDTO>  findAllComplaints()
	{
		ResponseDTO responseDTO = adminService.findAllJobs();
        if(responseDTO.isSuccess()) {
           return ResponseHandler.generateResponse(HttpStatus.OK,true,responseDTO,"Success");
        } else {
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,responseDTO,"Internal Server Error");
        }
	}
	
	
	//resolving employee with id {id} complaint by admin
	@RequestMapping( value ="/resolveCom/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> resolveComp(@PathVariable(name = "id") Long compId)
	{
		adminService.resolveComp(compId);
		return new ResponseEntity<>("Complaint id "+compId+" resolved successfully",HttpStatus.OK);
	}


}

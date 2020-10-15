package com.spring.boot.complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.response.ResponseDTO;
import com.spring.boot.complaint.response.ResponseHandler;
import com.spring.boot.complaint.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//registeration of employee by providing email and password
	@RequestMapping( value ="/register", method = RequestMethod.POST  )
	public ResponseEntity<String> register(@RequestBody Employee emp)
	{
		employeeService.register(emp);
		return new ResponseEntity<>("Employee registered successfully",HttpStatus.CREATED);
	}
	
	//deletion of employee by id
	@RequestMapping( value ="/deleteEmp/{id}", method = RequestMethod.POST  )
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long empId )
	{
		employeeService.deleteEmp( empId );
		return new ResponseEntity<>("Employee with id "+empId+" deleted successfully",HttpStatus.OK);
	}
	
	//find employee with id {id} complaint by providing type(he enetered while making compalint/job ) 
	@RequestMapping( value ="{id}/findByType/{type}", method = RequestMethod.GET  )
	public ResponseEntity <ResponseDTO> findCompByType(@PathVariable("id") Long empId,@PathVariable("type") String type )
	{
		ResponseDTO responseDTO = employeeService.findCompByType(empId,type);
        if(responseDTO.isSuccess()) {
           return ResponseHandler.generateResponse(HttpStatus.OK,true,responseDTO,"Success");
        } else {
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,responseDTO,"Internal Server Error");
        }
	}
	
	//find employee with id {id} complaint by providing status(resolved/unresolved ) 
	@RequestMapping( value ="{id}/findByStatus/{status}", method = RequestMethod.GET  )
	public ResponseEntity <ResponseDTO> findCompByStatus(@PathVariable("id") Long empId,@PathVariable("status") String status )
	{
		ResponseDTO responseDTO = employeeService.findCompByStatus(empId,status);
        if(responseDTO.isSuccess()) {
           return ResponseHandler.generateResponse(HttpStatus.OK,true,responseDTO,"Success");
        } else {
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,responseDTO,"Internal Server Error");
        }
	}
	
	//find employee with id {id} all complaints 
	@RequestMapping( value ="{id}/findAllComp", method = RequestMethod.GET  )
	public ResponseEntity <ResponseDTO> findAllComp(@PathVariable("id") Long empId)
	{
		ResponseDTO responseDTO = employeeService.findAllComp(empId);
        if(responseDTO.isSuccess()) {
           return ResponseHandler.generateResponse(HttpStatus.OK,true,responseDTO,"Success");
        } else {
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,responseDTO,"Internal Server Error");
        }
	}
		
}

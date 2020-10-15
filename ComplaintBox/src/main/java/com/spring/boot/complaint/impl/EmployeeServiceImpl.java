package com.spring.boot.complaint.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.complaint.dto.AdminCompDTO;
import com.spring.boot.complaint.model.Admin;
import com.spring.boot.complaint.model.EmpComplaint;
import com.spring.boot.complaint.model.Employee;
import com.spring.boot.complaint.repository.AdminRepository;
import com.spring.boot.complaint.repository.EmpComplaintRepository;
import com.spring.boot.complaint.repository.EmployeeRepository;
import com.spring.boot.complaint.response.ResponseDTO;
import com.spring.boot.complaint.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	EmpComplaintRepository empCompRepository;
	
	//register by employee himself
	@Override
	public void register(Employee emp) {
		employeeRepository.save(emp);
		
	}
	
	//register employee by admin
	public void registerEmpByAdmin(Long adminId,Employee emp) {
		Admin currentAdmin = adminRepository.findById(adminId).orElseThrow(()-> new NullPointerException("Admin id"+adminId+"doesn't exist"));
		currentAdmin.getEmployee().add(emp);
		emp.setAdmin(currentAdmin);
		adminRepository.save(currentAdmin);
	}

	//delete emplpyee from database
	@Override
	public void deleteEmp(Long empId) {
			if(employeeRepository.existsById(empId))
				employeeRepository.deleteById(empId);
		else
			throw new RuntimeException("No such id present to be deleted");	

	}

	//find complaints of employee by type
	@Override
	public ResponseDTO findCompByType(Long id, String type) {

		ResponseDTO responseDTO = new ResponseDTO<>();
		List<AdminCompDTO> empComp = empCompRepository.findByIdAndType(id,type);
        if (Objects.nonNull(empComp) && empComp.size()>0) {
            responseDTO = new ResponseDTO<>();
            responseDTO.setMessage("All Complaints Fetched SuccessFully");
            responseDTO.setSuccess(true);
            responseDTO.setData(empComp);
        } else {
            responseDTO.setMessage("No Data Found");
            responseDTO.setSuccess(false);
        }
        return responseDTO;
	}
	
	//find complaints of employee by status - resolved or unresolved
	@Override
	public ResponseDTO findCompByStatus(Long id, String status) {

		ResponseDTO responseDTO = new ResponseDTO<>();
		List<AdminCompDTO> empComp = empCompRepository.findByIdAndStatus(id,status);
        if (Objects.nonNull(empComp) && empComp.size()>0) {
            responseDTO = new ResponseDTO<>();
            responseDTO.setMessage("All Complaints Fetched SuccessFully");
            responseDTO.setSuccess(true);
            responseDTO.setData(empComp);
        } else {
            responseDTO.setMessage("No Data Found");
            responseDTO.setSuccess(false);
        }
        return responseDTO;
	}

	
	//find all complaints of a employee
	@Override
	public ResponseDTO findAllComp(Long id) {

		ResponseDTO responseDTO = new ResponseDTO<>();
		List<AdminCompDTO> empComp = empCompRepository.findAllById(id);
        if (Objects.nonNull(empComp) && empComp.size()>0) {
            responseDTO = new ResponseDTO<>();
            responseDTO.setMessage("All Complaints Fetched SuccessFully");
            responseDTO.setSuccess(true);
            responseDTO.setData(empComp);
        } else {
            responseDTO.setMessage("No Data Found");
            responseDTO.setSuccess(false);
        }
        return responseDTO;
	}

	
}

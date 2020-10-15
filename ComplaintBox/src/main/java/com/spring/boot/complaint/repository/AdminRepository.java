package com.spring.boot.complaint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.complaint.dto.AdminCompDTO;
import com.spring.boot.complaint.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	
	@Query(value = "select new com.spring.boot.complaint.dto.AdminCompDTO(emp.id,emp.email,comp.status) FROM EmpComplaint comp left join comp.employee emp")
	List<AdminCompDTO>findAllComplaints();

}

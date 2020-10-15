package com.spring.boot.complaint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.complaint.dto.AdminCompDTO;
import com.spring.boot.complaint.model.EmpComplaint;
@Repository
public interface EmpComplaintRepository extends CrudRepository<EmpComplaint, Long> {
	
	@Query(value = "select new com.spring.boot.complaint.dto.AdminCompDTO(emp.id,emp.email,comp.status) FROM EmpComplaint comp left join comp.employee emp where emp.id=:id and comp.type=:type")
	List<AdminCompDTO>findByIdAndType(Long id,String type);
	
	@Query(value = "select new com.spring.boot.complaint.dto.AdminCompDTO(emp.id,emp.email,comp.status) FROM EmpComplaint comp left join comp.employee emp where emp.id=:id and comp.status=:status")
	List<AdminCompDTO>findByIdAndStatus(Long id,String status);
	
	@Query(value = "select new com.spring.boot.complaint.dto.AdminCompDTO(emp.id,emp.email,comp.status) FROM EmpComplaint comp left join comp.employee emp where emp.id=:id ")
	List<AdminCompDTO>findAllById(Long id);
}

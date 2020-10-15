package com.spring.boot.complaint.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.complaint.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	

}

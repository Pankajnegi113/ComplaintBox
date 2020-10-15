package com.spring.boot.complaint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.complaint.model.Vendor;
@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long>{

}

package com.spring.boot.complaint.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private Set<Employee>employee=new HashSet<>();
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private Set<Vendor>vendor=new HashSet<>();
	
	public Admin()
	{
		
	}
	
	public Admin(String email, String password, Set<Employee> employee, Set<Vendor> vendor) {
		super();
		this.email = email;
		this.password = password;
		this.employee = employee;
		this.vendor = vendor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public Set<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + ", employee=" + employee
				+ ", vendor=" + vendor + "]";
	}
	
}

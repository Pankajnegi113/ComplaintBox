package com.spring.boot.complaint.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private Set<EmpComplaint>empComplaint=new HashSet<>();

	public Employee()
	{
		
	}
	
	public Employee(String email, String password, Admin admin, Set<EmpComplaint> empComplaint) {
		super();
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.empComplaint = empComplaint;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<EmpComplaint> getEmpComplaint() {
		return empComplaint;
	}

	public void setEmpComplaint(Set<EmpComplaint> empComplaint) {
		this.empComplaint = empComplaint;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", password=" + password + ", admin=" + admin
				+ ", empComplaint=" + empComplaint + "]";
	}
	
}

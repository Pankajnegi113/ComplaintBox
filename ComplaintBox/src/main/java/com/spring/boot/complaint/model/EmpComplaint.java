package com.spring.boot.complaint.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class EmpComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String status;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date created_at; 
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	public EmpComplaint() {
		
	}

	public EmpComplaint(String type, String status, Date created_at, Employee employee) {
		super();
		this.type = type;
		this.status = status;
		this.created_at = created_at;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpComplaint [id=" + id + ", type=" + type + ", status=" + status + ", created_at=" + created_at
				+ ", employee=" + employee + "]";
	}
	
	
}

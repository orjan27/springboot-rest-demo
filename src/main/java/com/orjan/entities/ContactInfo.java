package com.orjan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contact_info")

public class ContactInfo implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactInfoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employeeId", nullable = true)
	@JsonBackReference
	private Employee employee;
	
	private String val;
	private boolean primry;
	public Integer getContactInfoId() {
		return contactInfoId;
	}
	public void setContactInfoId(Integer contactInfoId) {
		this.contactInfoId = contactInfoId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public boolean isPrimry() {
		return primry;
	}
	public void setPrimry(boolean primry) {
		this.primry = primry;
	}
	
	

}

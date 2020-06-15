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
@Table(name = "address_info")

public class AddressInfo implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressInfoId;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employeeId", nullable = true)
	private Employee employee;
	
	private String address1;
	private String address2;
	private boolean primry;
	
	public Integer getAddressInfoId() {
		return addressInfoId;
	}
	public void setAddressInfoId(Integer addressInfoId) {
		this.addressInfoId = addressInfoId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public boolean isPrimry() {
		return primry;
	}
	public void setPrimry(boolean primry) {
		this.primry = primry;
	}
	
	
	
}

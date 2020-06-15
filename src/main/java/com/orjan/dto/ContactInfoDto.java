package com.orjan.dto;

import java.io.Serializable;

import com.orjan.entities.ContactInfo;

public class ContactInfoDto implements Serializable{

    private Integer contactInfoId;
	private Integer employeeId;
	private String val;
	private boolean primry;

	public ContactInfoDto() {}
	
	public ContactInfoDto(ContactInfo contactInfo) {
		this.contactInfoId = contactInfo.getContactInfoId();
		this.employeeId = contactInfo.getEmployee().getEmployeeId();
		this.val = contactInfo.getVal();
		this.primry = contactInfo.isPrimry();
	}
	public Integer getContactInfoId() {
		return contactInfoId;
	}
	public void setContactInfoId(Integer contactInfoId) {
		this.contactInfoId = contactInfoId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

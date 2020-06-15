package com.orjan.dto;

import java.io.Serializable;

import com.orjan.entities.AddressInfo;

public class AddressInfoDto implements Serializable{

	private Integer addressInfoId;
	private Integer employeeId;

	private String address1;
	private String address2;
	private boolean primry;

	public AddressInfoDto() {}
	public AddressInfoDto(AddressInfo addressInfo) {
		this.addressInfoId = addressInfo.getAddressInfoId();
		this.employeeId = addressInfo.getEmployee().getEmployeeId();
		this.address1 = addressInfo.getAddress1();
		this.address2 = addressInfo.getAddress2();
		this.primry = addressInfo.isPrimry();
	}

	public Integer getAddressInfoId() {
		return addressInfoId;
	}

	public void setAddressInfoId(Integer addressInfoId) {
		this.addressInfoId = addressInfoId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

package com.orjan.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.orjan.commons.DateUtil;
import com.orjan.entities.AddressInfo;
import com.orjan.entities.ContactInfo;
import com.orjan.entities.Employee;

public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8869253028357123244L;
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthDate;
	private String gender;
	private String maritalStatus;
	private String position;
	private String dateHired;
	private List<ContactInfoDto> contactInfos = new ArrayList<>();
	private List<AddressInfoDto> addressInfos = new ArrayList<>();
	private String nYearsInTheCompany;
	private String age;
	private String primaryContactInfo;
	private String primayAddressInfo;
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	
	public EmployeeDto() {}

	public EmployeeDto(Employee employee) {
		this.employeeId = employee.getEmployeeId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.middleName = employee.getMiddleName();
		this.birthDate = null != employee.getBirthDate() ? employee.getBirthDate().toString() : "";
		this.gender = employee.getGender();
		this.maritalStatus = employee.getMaritalStatus();
		this.position = employee.getPosition();
		this.dateHired = null != employee.getDateHired() ? employee.getDateHired().toString() : "";
		for (AddressInfo addressInfo : employee.getAddressInfos()) {
			if(addressInfo.isPrimry()) {
				this.primayAddressInfo = addressInfo.getAddress1() + ", "+ addressInfo.getAddress2();
			}
			this.addressInfos.add(new AddressInfoDto(addressInfo));
		}
		for (ContactInfo contactInfo : employee.getContactInfos()) {
			if(contactInfo.isPrimry()) {
				this.primaryContactInfo = contactInfo.getVal();
			}
			this.contactInfos.add(new ContactInfoDto(contactInfo));
		}

		this.nYearsInTheCompany = DateUtil.getDateDiffAsToday(employee.getDateHired());
		this.age = DateUtil.getDateDiffAsToday(employee.getBirthDate());		
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public List<ContactInfoDto> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(List<ContactInfoDto> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public List<AddressInfoDto> getAddressInfos() {
		return addressInfos;
	}

	public void setAddressInfos(List<AddressInfoDto> addressInfos) {
		this.addressInfos = addressInfos;
	}

	public String getnYearsInTheCompany() {
		return nYearsInTheCompany;
	}

	public void setnYearsInTheCompany(String nYearsInTheCompany) {
		this.nYearsInTheCompany = nYearsInTheCompany;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPrimaryContactInfo() {
		return primaryContactInfo;
	}

	public void setPrimaryContactInfo(String primaryContactInfo) {
		this.primaryContactInfo = primaryContactInfo;
	}

	public String getPrimayAddressInfo() {
		return primayAddressInfo;
	}

	public void setPrimayAddressInfo(String primayAddressInfo) {
		this.primayAddressInfo = primayAddressInfo;
	}

}

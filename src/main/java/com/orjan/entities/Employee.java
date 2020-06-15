package com.orjan.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.orjan.commons.DateUtil;
import com.orjan.commons.LocalDateConverter;
import com.orjan.commons.LocalDateDeserializer;
import com.orjan.commons.LocalDateSerializer;
import com.orjan.dto.AddressInfoDto;
import com.orjan.dto.ContactInfoDto;
import com.orjan.dto.EmployeeDto;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	private String firstName;
	private String lastName;
	private String middleName;

	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate birthDate;
	private String gender;
	private String maritalStatus;
	private String position;

	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateHired;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.REMOVE })
	private List<ContactInfo> contactInfos = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.REMOVE })
	private List<AddressInfo> addressInfos = new ArrayList<>();

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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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

	public LocalDate getDateHired() {
		return dateHired;
	}

	public void setDateHired(LocalDate dateHired) {
		this.dateHired = dateHired;
	}

	public List<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(List<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public List<AddressInfo> getAddressInfos() {
		return addressInfos;
	}

	public void setAddressInfos(List<AddressInfo> addressInfos) {
		this.addressInfos = addressInfos;
	}

	@Transient
	public void addContactInfo(ContactInfo contactInfo) {
		contactInfo.setEmployee(this);
		contactInfos.add(contactInfo);
	}

	@Transient
	public void addAddressInfo(AddressInfo addressInfo) {
		addressInfo.setEmployee(this);
		addressInfos.add(addressInfo);
	}
	

}

package com.wsa.dto;

public class RegistrationDto {
	int registrationId;
	String name;
	String mobileNumber;
	String email;
	String aadherNumber;
	String userName;
	String password;
	AddressDto adr;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadherNumber() {
		return aadherNumber;
	}

	public void setAadherNumber(String aadherNumber) {
		this.aadherNumber = aadherNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressDto getAdr() {
		return adr;
	}

	public void setAdr(AddressDto adr) {
		this.adr = adr;
	}

}
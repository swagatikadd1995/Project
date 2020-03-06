package com.wsa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	int addressId;
	
	@Column(name="area_name ", length=50, nullable=false, unique=false)
	String areaName;
	
	@Column(name="country_id ", length=50, nullable=false, unique=false)
	int countryId;
	
	@Column(name="state_id ", length=50, nullable=false, unique=false)
	int stateId;
	
	@Column(name="city_id ", length=50, nullable=false, unique=false)
	int cityId;
	
	@Column(name="pincode ")
	int pincode;
	
	@OneToOne(mappedBy = "addressEntity")
	RegistrationEntity registrationEntity;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public RegistrationEntity getRegistrationEntity() {
		return registrationEntity;
	}

	public void setRegistrationEntity(RegistrationEntity registrationEntity) {
		this.registrationEntity = registrationEntity;
	}
	
	
	
	
}

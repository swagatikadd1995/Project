package com.wsa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "registration")
public class RegistrationEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_id")
	int registrationId;

	@Column(name = "name ", length = 50, nullable = false, unique = false)
	String name;

	@Column(name = "mobile_number")
	String mobNumber;

	@Column(name = "email ")
	String email;

	@Column(name = "aadhar_number ")
	String aadherNum;

	// @Column(name="address_id ")
	@OneToOne
	@JoinColumn(name = "addressId")
	@Cascade(CascadeType.ALL)
	AddressEntity addressEntity;

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
			}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadherNum() {
		return aadherNum;
	}

	public void setAadherNum(String aadherNum) {
		this.aadherNum = aadherNum;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

}

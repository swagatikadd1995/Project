package com.wsa.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wsa.entity.StateEntity;

@Component
public class CountryDto {

	private int countryId;
	private String countryName;
	private List<StateEntity> stateEntity;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<StateEntity> getStateEntity() {
		return stateEntity;
	}

	public void setStateEntity(List<StateEntity> stateEntity) {
		this.stateEntity = stateEntity;
	}

}

package com.wsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wsa.dto.AddressDto;
import com.wsa.dto.CountryDto;
import com.wsa.dto.RegistrationDto;
import com.wsa.entity.AddressEntity;
import com.wsa.entity.CityEntity;
import com.wsa.entity.CountryEntity;
import com.wsa.entity.LoginEntity;
import com.wsa.entity.RegistrationEntity;
import com.wsa.entity.StateEntity;
import com.wsa.repository.CityRepository;
import com.wsa.repository.CountryRepository;
import com.wsa.repository.LoginRepository;
import com.wsa.repository.RegistrationRepository;
import com.wsa.repository.StateRepository;

@Service
public class LoginService {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CountryDto countryDto;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	LoginRepository loginRepository;

	public List<CountryEntity> getCountryNameService() {

		return countryRepository.findAll();
	}

	public List<StateEntity> getStateNameService() {

		return stateRepository.findAll();
	}

	public List<StateEntity> getStateByCountryIdService(int countryId) {
		List<StateEntity> listState = stateRepository.findByCountryId(countryId);
		return listState;

	}

	public List<CityEntity> getCityByStateIdService(int stateId) {
		List<CityEntity> listCity = cityRepository.findByStateId(stateId);
		return listCity;

	}

	public String createUserRegistration(RegistrationDto registrationDto) {
		RegistrationEntity regEntity = new RegistrationEntity();
		LoginEntity loginentity = new LoginEntity();

		AddressEntity adrEntity = new AddressEntity();
		AddressDto adrDto = registrationDto.getAdr();

		regEntity.setName(registrationDto.getName());
		regEntity.setMobNumber(registrationDto.getMobileNumber());
		regEntity.setEmail(registrationDto.getEmail());
		regEntity.setAadherNum(registrationDto.getAadherNumber());
		regEntity.setAddressEntity(adrEntity);

		adrEntity.setAreaName(adrDto.getAreaName());
		adrEntity.setCityId(adrDto.getCity());
		adrEntity.setCountryId(adrDto.getCountry());
		adrEntity.setPincode(adrDto.getPincode());
		adrEntity.setStateId(adrDto.getState());

		loginentity.setUserName(registrationDto.getUserName());
		loginentity.setPassword(registrationDto.getPassword());

		try {
			
			regEntity = registrationRepository.save(regEntity);
			loginentity.setRegistrationId(regEntity.getRegistrationId());
			loginRepository.save(loginentity);

			return "Account created sucessfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Falied to create an account";
		}

	}

	public RegistrationDto getLoginUserNameAndPasswordByRegistraionId(String userName, String password) {
		LoginEntity loginEntity = loginRepository.findByUserNameAndPassword(userName, password);
		if (loginEntity != null) {
			RegistrationEntity regEntity = registrationRepository.findById(loginEntity.getRegistrationId()).get();

			RegistrationDto registrationDto = new RegistrationDto();
			AddressEntity adrEntity = regEntity.getAddressEntity();
			AddressDto adrDto = new AddressDto();

			registrationDto.setName(regEntity.getName());
			registrationDto.setMobileNumber(regEntity.getMobNumber());
			registrationDto.setEmail(regEntity.getEmail());

			// AddressDto adrDto = registrationDto.getAdr();

			adrDto.setAreaName(adrEntity.getAreaName());
			adrDto.setCountry(adrEntity.getCountryId());
			adrDto.setCity(adrEntity.getCityId());
			adrDto.setState(adrEntity.getStateId());
			adrDto.setPincode(adrEntity.getPincode());

			registrationDto.setAdr(adrDto);

			return registrationDto;
		} else {
			return null;
		}

	}

	public boolean getRegistarUserName(String username) {
		LoginEntity loginEntity = loginRepository.findByUserName(username);
		// System.out.println(loginEntity);
		if (loginEntity != null) {
			return true;
		}
		return false;

	}

	public String validateRegistarMobNumberService(String mobile) {
		String mobNum = registrationRepository.findByMobNumber(mobile);
		return mobNum;

	}

}

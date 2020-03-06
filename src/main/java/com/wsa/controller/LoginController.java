package com.wsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wsa.dto.CountryDto;
import com.wsa.dto.RegistrationDto;
import com.wsa.entity.CityEntity;
import com.wsa.entity.CountryEntity;
//import com.wsa.entity.RegistrationEntity;
import com.wsa.entity.StateEntity;
import com.wsa.exception.InvalidLoginException;
import com.wsa.exception.InvalidMobNumberException;
import com.wsa.service.LoginService;
import com.wsa.validate.LoginValidation;
import com.wsa.validate.MobNumberValidation;

@RestController

public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	CountryDto countryDto;
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/countries")
	public List<CountryEntity> getCountryName() {

		return loginService.getCountryNameService();
	}

	@GetMapping("/states")
	public List<StateEntity> getStateName() {

		return loginService.getStateNameService();
	}

	@GetMapping("/country/{id}")
	public ResponseEntity<?> getStateByCountryId(@PathVariable("id") int countryId) {
		
		log.info("Get County By Id " + countryId);
		
		List<StateEntity> listState = loginService.getStateByCountryIdService(countryId);
		if (listState.size() == 0) {
			return new ResponseEntity<String>("No State for this countryId " + countryId, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<StateEntity>>(listState, HttpStatus.OK);

	}

	@GetMapping("/state/{id}")
	public ResponseEntity<?> getCityByStateId(@PathVariable("id") int stateId) {
		log.info("Get state By Id " + stateId);
		List<CityEntity> listCity = loginService.getCityByStateIdService(stateId);
		if (listCity.size() == 0) {
			return new ResponseEntity<String>("No State for this stateId " + stateId, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<CityEntity>>(listCity, HttpStatus.OK);

	}

	@PostMapping("/registar")
	public ResponseEntity<String> userRegistration(@RequestBody RegistrationDto registrationDto) {
		log.info("Post a new Registration ");
		try {
			LoginValidation.registarDtoValidation(registrationDto);
			
			
		} catch (InvalidLoginException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
			}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(loginService.createUserRegistration(registrationDto), HttpStatus.OK);
	}

	@GetMapping("/login")
	public ResponseEntity<?> getLoginUserNameAndPassword(@RequestHeader String userName,
			@RequestHeader String password) {

		try {
			LoginValidation.validateUserNameAndPassword(userName, password);

			RegistrationDto regDto = loginService.getLoginUserNameAndPasswordByRegistraionId(userName, password);
			if (regDto != null) {
				return new ResponseEntity<RegistrationDto>(regDto, HttpStatus.OK);
			}
		} catch (InvalidLoginException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ResponseEntity<String>("Invalid UserName and Password", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/registar/user/{username}")
	public boolean registarUserNameValidate(@PathVariable String username) {
		boolean status = loginService.getRegistarUserName(username);
		return status;

	}

	@GetMapping("/registar/mobile/{mobile}")
	public ResponseEntity<String> validateRegistarMobNumber(@PathVariable String mobile) {

		try {
			MobNumberValidation.validateMobNumber(mobile);
			String mobNum = loginService.validateRegistarMobNumberService(mobile);
			if (mobNum == null) {
				return new ResponseEntity<String>("Mobile Number cannot be null", HttpStatus.BAD_REQUEST);

			}

		} catch (InvalidMobNumberException e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Mobile Number is valid", HttpStatus.OK);

	}

}

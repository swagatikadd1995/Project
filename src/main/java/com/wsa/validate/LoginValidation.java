package com.wsa.validate;

import com.wsa.dto.RegistrationDto;
import com.wsa.exception.InvalidLoginException;
import com.wsa.exception.InvalidMobNumberException;

public class LoginValidation {

	public static void validateUserNameAndPassword(String userName, String password) throws InvalidLoginException {

		if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
			throw new InvalidLoginException("UserName and Password should not be null or empty");
		}
		if (userName.length() >= 5 || password.length() >= 5) {
			throw new InvalidLoginException("UserName and Password should be more than 5 Character");
		}

	}
	
	public static void registarDtoValidation(RegistrationDto registrationDto) throws InvalidLoginException {
		
		if(!registrationDto.getMobileNumber().matches( "(0/91)?[7-9][0-9]{9}")){
			throw new InvalidLoginException("Mobile Number is invalid");
			
			}
		if(!registrationDto.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			
			throw new InvalidLoginException("Email is invalid");
		}
	}

}

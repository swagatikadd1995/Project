package com.wsa.validate;

import com.wsa.exception.InvalidMobNumberException;

public class MobNumberValidation {
	
	public static void validateMobNumber(String mobile) 
			throws InvalidMobNumberException {
		
		if(!mobile.matches( "(0/91)?[7-9][0-9]{9}")){
			throw new InvalidMobNumberException("Mobile Number is invalid");
			
			
		}
		
		
	}

}

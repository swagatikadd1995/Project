package com.wsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsa.entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer>{
	
	String findByMobNumber(String mobNumber );
	

}

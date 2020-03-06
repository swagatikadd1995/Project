package com.wsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsa.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
	

}

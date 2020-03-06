package com.wsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsa.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

	List<StateEntity> findByCountryId(int countryId);
}

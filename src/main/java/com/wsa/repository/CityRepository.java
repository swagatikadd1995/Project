package com.wsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsa.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	List<CityEntity> findByStateId(int stateId);
}

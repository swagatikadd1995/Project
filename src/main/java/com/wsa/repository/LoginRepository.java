package com.wsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsa.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer>  {
	
	LoginEntity findByUserNameAndPassword(String UserName,String password);
	
	LoginEntity findByUserName(String UserName);

}

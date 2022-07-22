package com.drps.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drps.ams.entity.UserDetailsEntity;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
	
	

}

package com.drps.ams.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;
import com.drps.ams.entity.UserDetailsEntity;
import com.drps.ams.repository.UserDetailsRepository;
import com.drps.ams.service.UserDetailsService;
import com.drps.ams.util.ApiConstants;

import lombok.NonNull;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public ApiResponseEntity saveOrUpdate(@NonNull UserDetailsDTO userDetailsDTO) throws Exception {
		
		UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
			
		BeanUtils.copyProperties(userDetailsEntity, userDetailsDTO);
			
		userDetailsRepository.save(userDetailsEntity);
			
		BeanUtils.copyProperties(userDetailsDTO, userDetailsEntity);	
		
		return new ApiResponseEntity(ApiConstants.RESP_STATUS_SUCCESS, userDetailsDTO);
	}
	

}

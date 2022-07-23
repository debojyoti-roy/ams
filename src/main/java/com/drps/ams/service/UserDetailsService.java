package com.drps.ams.service;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;

public interface UserDetailsService {

	public ApiResponseEntity saveOrUpdate(UserDetailsDTO userDetailsDTO) throws Exception;
	public ApiResponseEntity getListView() throws Exception;
	public ApiResponseEntity getById(Long id) throws Exception;
	ApiResponseEntity deleteById(Long id) throws Exception;
}

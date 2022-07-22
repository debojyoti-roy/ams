package com.drps.ams.service;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;

public interface UserDetailsService {

	public ApiResponseEntity saveOrUpdate(UserDetailsDTO userDetailsDTO) throws Exception;

}

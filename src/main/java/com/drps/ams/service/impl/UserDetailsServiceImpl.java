package com.drps.ams.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;
import com.drps.ams.entity.UserDetailsEntity;
import com.drps.ams.exception.NoRecordFoundException;
import com.drps.ams.exception.RecordIdNotFoundException;
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
			
		BeanUtils.copyProperties(userDetailsDTO, userDetailsEntity);
			
		userDetailsRepository.save(userDetailsEntity);
			
		BeanUtils.copyProperties(userDetailsEntity, userDetailsDTO);	
		
		return new ApiResponseEntity(ApiConstants.RESP_STATUS_SUCCESS, userDetailsDTO);
	}

	@Override
	public ApiResponseEntity getListView() throws Exception {
		List<UserDetailsEntity> list = userDetailsRepository.findAll();
		
		List<UserDetailsDTO> rtnList = new ArrayList<>();
		if(list != null) {
			UserDetailsDTO userDetailsDTO = null;
			for(UserDetailsEntity userDetailsEntity : list) {
				userDetailsDTO = new UserDetailsDTO();
				BeanUtils.copyProperties(userDetailsEntity, userDetailsDTO);
				rtnList.add(userDetailsDTO);
			}
		}
		return new ApiResponseEntity(ApiConstants.RESP_STATUS_SUCCESS, rtnList);
	}

	@Override
	public ApiResponseEntity getById(Long id) throws Exception {
		if(id != null && id > 0) {
			UserDetailsEntity userDetailsEntity = userDetailsRepository.findById(id).get();
			if(userDetailsEntity != null) {
				UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
				BeanUtils.copyProperties(userDetailsEntity, userDetailsDTO);
				return new ApiResponseEntity(ApiConstants.RESP_STATUS_SUCCESS, userDetailsDTO);
			} else {
				throw new NoRecordFoundException(ApiConstants.STATUS_MESSAGE.get(ApiConstants.RESP_STATUS_NO_RECORD_FOUND_EXCEPTION));
			}
		} else {
			throw new RecordIdNotFoundException(ApiConstants.STATUS_MESSAGE.get(ApiConstants.RESP_STATUS_RECORD_ID_NOT_FOUND_EXCEPTION));
		}
	}
	
	@Override
	public ApiResponseEntity deleteById(Long id) throws Exception {
		if(id != null && id > 0) {
			userDetailsRepository.deleteById(id);
			return new ApiResponseEntity(ApiConstants.RESP_STATUS_SUCCESS, ApiConstants.STATUS_MESSAGE.get(ApiConstants.RESP_STATUS_SUCCESS));
		} else {
			throw new RecordIdNotFoundException(ApiConstants.STATUS_MESSAGE.get(ApiConstants.RESP_STATUS_RECORD_ID_NOT_FOUND_EXCEPTION));
		}
	}
}

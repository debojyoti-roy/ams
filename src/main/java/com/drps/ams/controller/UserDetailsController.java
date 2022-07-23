package com.drps.ams.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;
import com.drps.ams.service.UserDetailsService;



@RestController
@RequestMapping("/api/user")
public class UserDetailsController {	
	
	private static final  Logger logger = LogManager.getLogger(UserDetailsController.class);
	
	@Autowired
	UserDetailsService userDetailsService;	
	
	@PostMapping(value = "/create_or_update")
	public ResponseEntity<ApiResponseEntity> createOrUpdate(@RequestBody UserDetailsDTO userDetailsDTO) throws Exception {
		logger.info("AMS - UserDetailsController createOrUpdate: {}", userDetailsDTO);
		return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.saveOrUpdate(userDetailsDTO));		
	}
	
	@GetMapping(value = "/list_view/get")
	public ResponseEntity<ApiResponseEntity> getListView() throws Exception {
		logger.info("AMS - UserDetailsController getListView");
		return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.getListView());		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ApiResponseEntity> getById(@PathVariable("id") Long id) throws Exception {
		logger.info("AMS - UserDetailsController getById");
		return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.getById(id));		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ApiResponseEntity> deleteById(@PathVariable("id") Long id) throws Exception {
		logger.info("AMS - UserDetailsController deleteById");
		return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.deleteById(id));		
	}
	

}

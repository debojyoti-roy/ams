package com.drps.ams.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.dto.UserDetailsDTO;
import com.drps.ams.service.UserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@CrossOrigin(origins = {"${app.api.settings.cross-origin.urls}"})

@RestController
@RequestMapping("/api")
@Api(value = "User Details Controller", description = "Manages User records")
public class UserDetailsController {	
	
	private static final  Logger logger = LogManager.getLogger(UserDetailsController.class);
	
	@Autowired
	UserDetailsService userDetailsService;	
	
	
	
	@ApiOperation(value = "Creates User Details record")	
	@PostMapping(value = "/user/create_or_update")
	@Consumes("application/json")
	@Produces("application/json")
	public ResponseEntity<ApiResponseEntity> createOrUpdate(@RequestBody UserDetailsDTO userDetailsDTO) throws Exception {
		logger.info("AMS - UserDetailsController createOrUpdate:");
		return ResponseEntity.status(HttpStatus.OK).body(userDetailsService.saveOrUpdate(userDetailsDTO));		
	}
	

}

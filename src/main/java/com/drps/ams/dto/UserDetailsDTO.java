package com.drps.ams.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailsDTO {


	private Long id;	
	
	private String loginId;	
	
	private String firstName;	
	
	private String middleName;	
	
	private String lastName;	
	
	private String adharCardNo;	
	
	private String userAddress;	
	
	private String contactNo1;	
	
	private String contactNo2;	
	
	private String emailId;	
	
	private Boolean isDeleted;	
	
	private Boolean isActive;

}

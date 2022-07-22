package com.drps.ams.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetailsEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;	
	
	@Column(name = "LOGIN_ID")
	private String loginId;	
	
	@Column(name = "FIRST_NAME")
	private String firstName;	
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;	
	
	@Column(name = "LAST_NAME")
	private String lastName;	
	
	@Column(name = "ADHAR_CARD_NO")
	private String adharCardNo;	
	
	@Column(name = "USER_ADDRESS")
	private String userAddress;
	
	@Column(name = "CONTACT_NO_1")
	private String contactNo1;	
	
	@Column(name = "CONTACT_NO_2")
	private String contactNo2;
	
	@Column(name = "EMAIL_ID")
	private String emailId;	
	
	@Column(name = "IS_DELETED")
	private Boolean isDeleted;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name = "CREATED_BY")
	private String createdBy;	
	
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;	
	
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;	

}

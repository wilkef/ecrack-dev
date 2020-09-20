/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Satya
 * Sep 20, 2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDataDTO {
	
	private Long UserId;
	private String UserName;
	private String FirstName;
	private String LastName;
	private String MESSAGE_TEXT;
	
	public Long getUserId() {
		return UserId;
	}


	public void setUserId(Long userId) {
		UserId = userId;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getMESSAGE_TEXT() {
		return MESSAGE_TEXT;
	}


	public void setMESSAGE_TEXT(String mESSAGE_TEXT) {
		MESSAGE_TEXT = mESSAGE_TEXT;
	}


	@Override
	public String toString() {
		return "RegistrationDataDTO [UserId=" + UserId + ", UserName=" + UserName + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", MESSAGE_TEXT=" + MESSAGE_TEXT + "]";
	}
	
}

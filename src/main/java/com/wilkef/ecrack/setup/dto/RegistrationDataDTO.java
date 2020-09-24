/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The Class RegistrationDataDTO.
 *
 * @author Satya
 * Sep 20, 2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDataDTO {
	
	/** The User id. */
	private Long UserId;
	
	/** The User name. */
	private String UserName;
	
	/** The First name. */
	private String FirstName;
	
	/** The Last name. */
	private String LastName;
	
	/** The message text. */
	private String MESSAGE_TEXT;
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return UserId;
	}


	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		UserId = userId;
	}


	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return UserName;
	}


	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}


	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return FirstName;
	}


	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return LastName;
	}


	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}


	/**
	 * Gets the message text.
	 *
	 * @return the message text
	 */
	public String getMESSAGE_TEXT() {
		return MESSAGE_TEXT;
	}


	/**
	 * Sets the message text.
	 *
	 * @param mESSAGE_TEXT the new message text
	 */
	public void setMESSAGE_TEXT(String mESSAGE_TEXT) {
		MESSAGE_TEXT = mESSAGE_TEXT;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "RegistrationDataDTO [UserId=" + UserId + ", UserName=" + UserName + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", MESSAGE_TEXT=" + MESSAGE_TEXT + "]";
	}
	
}

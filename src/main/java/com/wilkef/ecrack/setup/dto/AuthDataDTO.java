/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to Authentication
 *
 */

package com.wilkef.ecrack.setup.dto;

/**
 * The Class AuthDataDTO.
 */
public class AuthDataDTO {

	
	/** The User. */
	private String User;
	
	/** The Token. */
	private String Token;
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return User;
	}
	
	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		User = user;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return Token;
	}
	
	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		Token = token;
	}
}

/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */
 
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dto.ValidationDTO;

/**
 * The Interface ValidationDao.
 */
@Repository
public interface ValidationDao {

	/**
	 * Validate email.
	 *
	 * @param email the email
	 * @return the list
	 */
	List<ValidationDTO> validateEmail(String email);

	/**
	 * Validate mobile no.
	 *
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	List<ValidationDTO> validateMobileNo(String mobileNo);
	
	/**
	 * Save otp.
	 *
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	List<ValidationDTO> saveOtp(String mobileNo);

	/**
	 * Verify otp.
	 *
	 * @param otp the otp
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	String verifyOtp(String otp, String mobileNo);

	List<ValidationDTO> validateLogin( String input);
	
	

}

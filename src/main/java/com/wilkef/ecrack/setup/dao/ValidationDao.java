/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */
 
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dto.ValidationDTO;

@Repository
public interface ValidationDao {

	List<ValidationDTO> validateEmail(String email);

	List<ValidationDTO> validateMobileNo(String mobileNo);
	
	List<ValidationDTO> saveOtp(String mobileNo);

	List<ValidationDTO> verifyOtp(String otp, String mobileNo);
	
	

}

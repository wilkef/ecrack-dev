/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */

package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class UserProfileController.
 */
@RestController
@RequestMapping("/user")
public class UserProfileController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(UserProfileController.class.getName());
	
	/** The user profile dao. */
	@Autowired
	private  UserProfileDao userProfileDao;
	
	
	@Autowired
	private ServiceOutputTransformer serviceOutput;
	

	/**
	 * Update profile.
	 *
	 * @param input the input
	 * @param userId the user id
	 * @return the response entity
	 */
	
	@PutMapping(value = "/updateProfile")
	public ResponseEntity<Object> updateProfile(@Valid @RequestBody String input){
		LOG.info("START-Inside updateProfile");
		LOG.log(Level.INFO, () -> " updateProfile Inputs: " + input); 
		ResponseEntity<Object> response=null;
		List<UserProfileDTO> userProfileDTOList=new ArrayList<>();
		try {
			userProfileDTOList = userProfileDao.updateProfile(input);
			if(userProfileDTOList.get(0).getUpdateCount().equals(1)) {
				response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
				        .body(serviceOutput.responseOutput("isSuccess", true));
			}
			else {
				throw new CustomException(ErrorConstants.USER_NOT_EXISTS);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside updateProfile");
		return  response;
	}
	
	
	/**
	 * View profile.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@GetMapping(value = "/viewProfile/{userId}")
	public ResponseEntity<Object> viewProfile(@Valid @PathVariable int userId){
		LOG.info("START-Inside viewProfile");
		LOG.log(Level.INFO, () -> "viewProfile Inputs: " + userId); 
		ResponseEntity<Object> response=null;
		List<UserProfileDTO> userProfileDTOList=new ArrayList<>();
		try {
			userProfileDTOList = userProfileDao.viewProfile(userId);
			if(!userProfileDTOList.get(0).getDataOutput().isEmpty()) {
				response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
				        .body(userProfileDTOList.get(0).getDataOutput());
			}
			else {
				throw new CustomException(ErrorConstants.USER_NOT_EXISTS);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside viewProfile");
		return  response;
	}
	
}

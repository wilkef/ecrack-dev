/*
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

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.exception.RecordNotFoundException;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;
// TODO: Auto-generated Javadoc

/**
 * The Class ValidationController.
 */
@RestController
@RequestMapping("/api.ecrack/api/user")
public class ValidationController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ValidationController.class.getName());


	/** The validation dao. */
	@Autowired
	private ValidationDao validationDao;
	
	
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	/**
	 * Validate email id.
	 *
	 * @param email the email
	 * @return the response entity
	 */
	@PostMapping(value = "/validateEmailId")
	public ResponseEntity<Object> validateEmailId(@Valid @RequestBody String email ){
		LOG.info("START-Inside validateEmailId");
		ResponseEntity<Object> response=null;
		List<ValidationDTO> validDto=new ArrayList<>();
		try {
			JSONObject obj = new JSONObject(email);
			LOG.info("Inside find validateEmailId based on email");
			LOG.log(Level.INFO,() -> "Before geting validateEmailId information ");
			validDto = validationDao.validateEmail(obj.opt("EmailId").toString());
			if(validDto.get(0).getP_isValidEmailId()>0) {
				response = new ResponseEntity<>(serviceOutput.responseOutput("isSuccess", true),HttpStatus.OK);
			}
			else {
				throw new RecordNotFoundException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateEmailId");
		return  response;
	}


	/**
	 * Validate mobile no.
	 *
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	@PostMapping(value = "/validateMobileNumber/{mobileNo}")
	public ResponseEntity<Object> validateMobileNo(@Valid @PathVariable("mobileNo")String mobileNo ){
		LOG.info("START-Inside validateMobileNumber");
		ResponseEntity<Object> response=null;
		List<ValidationDTO> validDto=new ArrayList<>();
		try {
			LOG.info("Inside find validateMobileNumber based on email");
			LOG.log(Level.INFO,() -> "Before geting validateMobileNumber information ");
			validDto = validationDao.validateMobileNo(mobileNo);
			if(validDto.get(0).getP_isValidMobile()>0) {
				response = new ResponseEntity<>(serviceOutput.responseOutput("isSuccess", true),HttpStatus.OK);
			}
			else {
				//throw new RecordNotFoundException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateMobileNumber");
		return  response;
	}


	/**
	 * Send OTP.
	 *
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	@PostMapping(value = "/SendOTP/{mobileNo}")
	public ResponseEntity<Object> sendOTP(@Valid @PathVariable("mobileNo")String mobileNo ){
		LOG.info("START-Inside sendOTP");
		ResponseEntity<Object> response=null;
		List<ValidationDTO> validDto=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting sendOTP information ");
			validDto = validationDao.saveOtp(mobileNo);

			if(!validDto.isEmpty()) { 
				response = new ResponseEntity<>(serviceOutput.responseOutput("isSuccess", true),HttpStatus.OK); } 
			else { 
				//throw new RecordNotFoundException("No Record Found"); 
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside sendOTP");
		return  response;
	}




	/**
	 * Verify otp.
	 *
	 * @param otp the otp
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	@PostMapping(value = "/VerifyOTP/{otp}/{mobileNo}")
	public ResponseEntity<Object> verifyOtp(@Valid @PathVariable("otp")String otp,@Valid @PathVariable("mobileNo")String mobileNo ){
		LOG.info("START-Inside verifyOtp");
		ResponseEntity<Object> response=null;
		List<ValidationDTO> validDto=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting verifyOtp information ");
			validDto = validationDao.verifyOtp(otp,mobileNo);
			if(!validDto.isEmpty()) { 
				response = new ResponseEntity<>(serviceOutput.responseOutput("isSuccess", true),HttpStatus.OK); } 
			else { 
				throw new RecordNotFoundException("No Record Found"); 
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside verifyOtp");
		return  response;
	}


}

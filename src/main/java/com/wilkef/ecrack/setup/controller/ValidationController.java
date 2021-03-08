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
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.SMSResponseDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.RegistrationService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class ValidationController.
 */

@RestController
@RequestMapping("/user")
public class ValidationController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ValidationController.class.getName());

	/** The validation dao. */
	@Autowired
	private ValidationDao validationDao;

	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private RegistrationService registrationService;

	/**
	 * Validate email id.
	 *
	 * @param email the email
	 * @return the response entity
	 */
	@PostMapping(value = "/validateEmailId")
	public ResponseEntity<Object> validateEmailId(@Valid @RequestBody String email) {
		LOG.info("START-Inside validateEmailId");
		LOG.log(Level.INFO, () -> "validateEmailId Inputs email: " + email);
		ResponseEntity<Object> response = null;
		List<ValidationDTO> validDto = new ArrayList<>();
		try {
			JSONObject obj = new JSONObject(email);
			LOG.info("Inside find validateEmailId based on email");
			LOG.log(Level.INFO, () -> "Before geting validateEmailId information ");
			validDto = validationDao.validateEmail(obj.opt("EmailId").toString());
			if (validDto.get(0).getP_isValidEmailId() > 0) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateEmailId");
		return response;
	}

	/**
	 * Validate mobile no.
	 *
	 * @param mobileNumber the mobile number
	 * @return the response entity
	 */
	@PostMapping(value = "/validateMobileNumber/{mobileNo}")
	public ResponseEntity<Object> validateMobileNo(@Valid @PathVariable("mobileNo") String mobileNumber) {
		LOG.info("START-Inside validateMobileNumber");
		LOG.log(Level.INFO, () -> "validateMobileNumber Inputs mobileNumber: " + mobileNumber);
		ResponseEntity<Object> response = null;
		List<ValidationDTO> validDto = new ArrayList<>();
		boolean mobileNo = Pattern.compile("\\d{10}").matcher(mobileNumber).matches();
		try {
			LOG.info("Inside find validateMobileNumber based on email");
			LOG.log(Level.INFO, () -> "Before geting validateMobileNumber information ");

			if (mobileNo) {
				validDto = validationDao.validateMobileNo(mobileNumber);
				if (validDto.get(0).getP_isValidMobile() > 0) {
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
				} else {
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
				}
			} else
				throw new CustomException("Please Enter a Valid Mobile No.");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateMobileNumber");
		return response;
	}

	/**
	 * Send OTP.
	 *
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	/**
	 * 
	 * public ResponseEntity<Object> sendOTP(@Valid @PathVariable("mobileNo")String
	 * mobileNo, @Valid @PathVariable("purpose")String purpose){
	 * LOG.info("START-Inside sendOTP"); LOG.log(Level.INFO, () -> "sendOTP Inputs
	 * mobileNumber: " + mobileNo); ResponseEntity<Object> response=null;
	 * List<ValidationDTO> validDto=new ArrayList<>(); try { LOG.log(Level.INFO,()
	 * -> "Before geting sendOTP information "); if(purpose.equals("RGSTRN")) {
	 * validDto = validationDao.validateMobileNo(mobileNo);
	 * if(validDto.get(0).getP_isValidMobile()>0) { throw new
	 * CustomException(ErrorConstants.USER_ALREADY_EXISTS); } else {
	 * LOG.info(ErrorConstants.NO_RECORD_FOUND); validDto =
	 * validationDao.saveOtp(mobileNo);
	 * 
	 * if(!validDto.isEmpty()) { response =
	 * ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
	 * .body(serviceOutput.responseOutput("status", "success")); } else { throw new
	 * CustomException(ErrorConstants.OTP_ERROR); } } } else
	 * if(purpose.equals("FRGTPWD")){
	 * 
	 * validDto = validationDao.saveOtp(mobileNo);
	 * 
	 * if(!validDto.isEmpty()) { response =
	 * ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
	 * .body(serviceOutput.responseOutput("status", "success")); } else { throw new
	 * CustomException(ErrorConstants.OTP_ERROR); } } else { throw new
	 * CustomException(ErrorConstants.PURPOSE_NOT_VALID); } } catch (Exception e) {
	 * LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG +
	 * e.getMessage()); return new CustomExceptionHandler().handleAllExceptions(e);
	 * } LOG.info("END-Inside sendOTP"); return response; }
	 * 
	 */

	@PostMapping(value = "/checkMobAvailability/{mobileNo}")
	public ResponseEntity<Object> checkMobAvailability(@Valid @PathVariable("mobileNo") String mobileNo) {
		LOG.info("Start checkMobAvailability");
		ResponseEntity<Object> response = null;
		try {
			boolean isExist = registrationService.checkMobAvailability(mobileNo);
			if (!isExist) {
				validationDao.saveOtp(mobileNo);
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}

	@PostMapping(value = "/SendOTP/{mobileNo}")
	public ResponseEntity<Object> sendOTP(@Valid @PathVariable("mobileNo") String mobileNo) {
		/*
		 * LOG.info("START-Inside sendOTP"); LOG.log(Level.INFO, () ->
		 * "sendOTP Inputs mobileNumber: " + mobileNo); ResponseEntity<Object> response
		 * = null; List<ValidationDTO> validDto = new ArrayList<>(); try {
		 * LOG.log(Level.INFO, () -> "Before geting sendOTP information "); validDto =
		 * validationDao.saveOtp(mobileNo); if (!validDto.isEmpty()) { response =
		 * ResponseEntity.status(HttpStatus.OK).contentType(MediaType.
		 * APPLICATION_JSON_UTF8)
		 * .body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true)); } else
		 * { response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.
		 * APPLICATION_JSON_UTF8)
		 * .body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false)); } }
		 * catch (Exception e) { LOG.log(Level.SEVERE, () ->
		 * ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage()); return new
		 * CustomExceptionHandler().handleAllExceptions(e); }
		 * LOG.info("END-Inside sendOTP"); return response;
		 */

		LOG.info("START-Inside sendSMSOTP");
		LOG.log(Level.INFO, () -> "sendSMSOTP Inputs mobileNumber: " + mobileNo);
		ResponseEntity<Object> response = null;
		SMSResponseDTO validDto = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting sendSMSOTP information ");
			validDto = validationDao.saveSMS(mobileNo);
			System.out.println(validDto);
			if ("Success".equals(validDto.getStatus())) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside sendOTP");
		return response;
	}

//	@PostMapping(value = "/SendSMSOTP/{mobileNo}")
//	public ResponseEntity<Object> sendSMSOTP(@Valid @PathVariable("mobileNo") String mobileNo) {
//		LOG.info("START-Inside sendSMSOTP");
//		LOG.log(Level.INFO, () -> "sendSMSOTP Inputs mobileNumber: " + mobileNo);
//		ResponseEntity<Object> response = null;
//		SMSResponseDTO validDto = null;
//		try {
//			LOG.log(Level.INFO, () -> "Before geting sendSMSOTP information ");
//			validDto = validationDao.saveSMS(mobileNo);
//			if ("Success".equals(validDto.getStatus())) {
//				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
//						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
//			} else {
//				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
//						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
//			}
//
//		} catch (Exception e) {
//			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
//			return new CustomExceptionHandler().handleAllExceptions(e);
//		}
//		LOG.info("END-Inside sendOTP");
//		return response;
//	}

	/**
	 * Verify otp.
	 *
	 * @param otp      the otp
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	@PostMapping(value = "/VerifyOTP/{otp}/{mobileNo}")
	public ResponseEntity<Object> verifyOtp(@Valid @PathVariable("otp") String otp,
			@Valid @PathVariable("mobileNo") String mobileNo) {
		LOG.info("START-Inside verifyOtp");
		LOG.log(Level.INFO, () -> "verifyOtp Inputs otp: " + otp);
		LOG.log(Level.INFO, () -> "verifyOtp Inputs mobileNo: " + mobileNo);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting verifyOtp information ");
			String msg = validationDao.verifyOtp(otp, mobileNo);
			if (msg.contains("OTP Verified")) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside verifyOtp");
		return response;
	}

	@PostMapping("/validateLogin")
	public ResponseEntity<Object> validateLogin(@Valid @RequestBody String input) {
		LOG.info("START-Inside validateLogin");
		LOG.log(Level.INFO, () -> "validateLogin Inputs input: " + input);
		ResponseEntity<Object> response = null;
		List<ValidationDTO> validDto = new ArrayList<>();
		try {
			LOG.log(Level.INFO, () -> "Before geting validateLogin information ");
			validDto = validationDao.validateCredentials(input);
			if (!validDto.isEmpty() && validationDao.setLoginStatus(1, input)) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateLogin");
		return response;
	}

	@PostMapping("/validateLogout")
	public ResponseEntity<Object> validateLogout(@Valid @RequestBody String input) {
		LOG.info("START-Inside validateLogout");
		LOG.log(Level.INFO, () -> "v Inputs input: " + input);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting validateLogout information ");
			if (validationDao.setLoginStatus(0, input)) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateLogout");
		return response;

	}
}
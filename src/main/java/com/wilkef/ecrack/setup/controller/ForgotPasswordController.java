/**
 * This Class is Used to Execute ForgotPassword Execution
 * 
 * @author Satya
 * Sep 19, 2020
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.ForgotPasswordService;
import com.wilkef.ecrack.setup.service.RegistrationService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class ForgotPasswordController.
 */
@RestController
@RequestMapping("/user")
public class ForgotPasswordController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ForgotPasswordController.class.getName());

	@Autowired
	public ForgotPasswordService forgotPasswordService;

	@Autowired
	public RegistrationService registrationService;

	@Autowired
	public ValidationDao validationDao;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@PostMapping(value = "/forgotPassword/{mobileNo}")
	public ResponseEntity<Object> sendOTP(@Valid @PathVariable("mobileNo") String mobileNo) {
		LOG.info("START-Inside forgotPassword");
		LOG.log(Level.INFO, () -> "sendOTP Inputs mobileNumber: " + mobileNo);
		ResponseEntity<Object> response = null;
		List<ValidationDTO> validDto = new ArrayList<>();
		try {
			LOG.log(Level.INFO, () -> "Before geting sendOTP information ");
			boolean isExist = registrationService.checkMobAvailability(mobileNo);
			LOG.log(Level.INFO, () -> "isExist=" + isExist);
			if (isExist) {
				validDto = validationDao.saveOtp(mobileNo);
				if (!validDto.isEmpty()) {					
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
				} else {
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
				}
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside forgotPassword");
		return response;
	}

	/**
	 * Verify otp.
	 *
	 * @param otp      the otp
	 * @param mobileNo the mobile no
	 * @return the response entity
	 */
	@PostMapping(value = "/forgotPasswordVerifyOtp/{otp}/{mobileNo}")
	public ResponseEntity<Object> forgotPasswordVerifyOtp(@Valid @PathVariable("otp") String otp,
			@Valid @PathVariable("mobileNo") String mobileNo) {
		LOG.info("START-Inside verifyOtp");
		LOG.log(Level.INFO, () -> "verifyOtp Inputs otp: " + otp);
		LOG.log(Level.INFO, () -> "verifyOtp Inputs mobileNo: " + mobileNo);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting verifyOtp information ");
			String msg = validationDao.verifyOtp(otp, mobileNo);
			LOG.log(Level.INFO, () -> "verifyOtp Message:" + msg);
			if (msg.contains("OTP Verified")) {
				String verificationCode = forgotPasswordService.setVerificationCode(mobileNo);
				LOG.log(Level.INFO, () -> "verificationCode: " + verificationCode);
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.TRUE, verificationCode));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.FALSE, null, "Wrong OTP"));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside verifyOtp");
		return response;
	}

	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the response entity
	 */
	@PostMapping("/resetPassword")
	public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordDataDTO resetPasswordData) {
		LOG.info("START ResetPassword ");
		LOG.log(Level.INFO, () -> " resetPassword Inputs forgotPwd: " + resetPasswordData);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before updating ForgotPassword : ");
			String mobileNo = resetPasswordData.getUserName();
			String newPassword = resetPasswordData.getNewPassword();
			String confirmPassword = resetPasswordData.getConfirmPassword();

			if (newPassword.equals(confirmPassword)) {
				Boolean status = forgotPasswordService.resetPassword(resetPasswordData);
				if (status) {
					forgotPasswordService.removeVerificationCode(mobileNo);
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
					return response;
				} else {
					LOG.log(Level.INFO, () -> ErrorConstants.INVALID_USER);
					response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
				}
			} else {
				LOG.log(Level.INFO, () -> ErrorConstants.PASSWORD_MISMATCH);
				response = ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput("StatusMessage", ErrorConstants.PROMPT_VALID_PASSWORD));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("End Reset Password ");
		return response;
	}
}
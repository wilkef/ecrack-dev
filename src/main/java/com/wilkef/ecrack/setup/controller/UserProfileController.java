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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ChangePasswordDataDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.UserProfileService;
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
	private UserProfileDao userProfileDao;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest request;

	/**
	 * Update profile.
	 *
	 * @param input  the input
	 * @param userId the user id
	 * @return the response entity
	 */

	@PutMapping(value = "/updateProfile")
	public ResponseEntity<Object> updateProfile(@Valid @RequestBody String input) {
		LOG.info("START-Inside updateProfile");
		LOG.log(Level.INFO, () -> " updateProfile Inputs: " + input);

		String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX,
				"");
		LoggedinUserInfo loggedinUserInfo = validationDao.getLoggedinUserInfo(jwtToken);

		ResponseEntity<Object> response = null;
		List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
		try {
			userProfileDTOList = userProfileDao.updateProfile(input, loggedinUserInfo.getMobileNumber());
			if (userProfileDTOList.get(0).getUpdateCount().equals(1)) {
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
		LOG.info("END-Inside updateProfile");
		return response;
	}

	/**
	 * View profile.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@GetMapping(value = "/viewProfile/{userName}")
	public ResponseEntity<Object> viewProfile(@Valid @PathVariable String userName) {
		LOG.info("START-Inside viewProfile");
		LOG.log(Level.INFO, () -> "viewProfile Inputs: " + userName);

		String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX,
				"");
		LoggedinUserInfo loggedinUserInfo = validationDao.getLoggedinUserInfo(jwtToken);

		ResponseEntity<Object> response = null;
		List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
		try {
			userProfileDTOList = userProfileDao.viewProfile(loggedinUserInfo.getMobileNumber());
			if (!userProfileDTOList.isEmpty()) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(userProfileDTOList.get(0).getDataOutput());
			} else {
				response = new ResponseEntity<>(userProfileDTOList, HttpStatus.OK);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside viewProfile");
		return response;
	}

	/**
	 * Change Password
	 *
	 * @param resetPwd the reset pwd
	 * @return the response entity
	 */
	@PostMapping(value = "/changePassword", consumes = "application/json")
	public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordDataDTO changePasswordData) {
		LOG.info("START-Inside changePassword");
		LOG.log(Level.INFO, () -> " changePassword Inputs:" + changePasswordData);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before Changing Password");

			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX,
					"");
			LoggedinUserInfo loggedinUserInfo = validationDao.getLoggedinUserInfo(jwtToken);

			boolean validCurrPwd = validationDao.validateCurrentPassword(changePasswordData.getCurrentPassword(),
					loggedinUserInfo.getUserId());

			if (validCurrPwd) {
				userProfileService.changePassword(changePasswordData, loggedinUserInfo.getMobileNumber());
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
				return response;
			} else {
				LOG.log(Level.INFO, () -> "Current Password is not correct");
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("End-Inside changePassword ");
		return response;
	}

}

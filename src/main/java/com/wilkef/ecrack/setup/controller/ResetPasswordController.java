/**
 * This Class is Used to execute ResetPassword Controller
 * 
 * @author Satya
 *Sep 19, 2020
 */
package com.wilkef.ecrack.setup.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.ResetPasswordService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class ResetPasswordController.
 */
@RestController
@RequestMapping("/user")
public class ResetPasswordController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ResetPasswordController.class.getName());

	/** The service. */
	@Autowired
	public ResetPasswordService service;

	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	/**
	 * Reset pwd.
	 *
	 * @param resetPwd the reset pwd
	 * @return the response entity
	 */
	@PostMapping(value = "/resetPassword", consumes = "application/json")
	public ResponseEntity<Object> resetPwd(@RequestBody ResetPasswordDataDTO resetPwd) {
		LOG.info("START-Inside ResetPassword ");
		LOG.log(Level.INFO, () -> " ResetPassword Inputs resetPwd:" + resetPwd);
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before updating resetPassword : ");
			Integer resetPassword = service.resetPassword(resetPwd);
			if (resetPassword != null) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
				return response;
			} else {
				LOG.log(Level.INFO, () -> "UserId And OldPassword is InValid");
				response = ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("START-Inside ResetPassword ");
		return response;
	}
}

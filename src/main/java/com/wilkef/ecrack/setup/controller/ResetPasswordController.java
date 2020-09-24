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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.service.ResetPasswordService;



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
	
	/**
	 * Reset pwd.
	 *
	 * @param resetPwd the reset pwd
	 * @return the response entity
	 */
	@PostMapping(value = "/resetPassword",consumes = "application/json")
	public ResponseEntity<Boolean> resetPwd(@RequestBody ResetPasswordDataDTO resetPwd) {
		LOG.info("START-Inside ResetPassword ");
		LOG.log(Level.INFO, () -> " ResetPassword Inputs resetPwd:"+resetPwd); 
		ResponseEntity<Boolean> response=null;
		try {
			LOG.log(Level.INFO, () -> "Before updating resetPassword : " );
			Integer resetPassword = service.resetPassword(resetPwd);
			if (resetPassword!=null) {
				response =new ResponseEntity<>(true,HttpStatus.OK);
				return response;
			}else {
				LOG.log(Level.INFO, () -> "UserId is InValid" );
				throw new CustomException(ErrorConstants.INVALID_CUSTOMER);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
		}
		LOG.info("START-Inside ResetPassword ");
		return response;
	}
}

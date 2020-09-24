/**
 * This Class is Used to Execute ForgotPassword Execution
 * 
 * @author Satya
 * Sep 19, 2020
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
import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.service.ForgotPasswordService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;



/**
 * The Class ForgotPasswordController.
 */
@RestController
@RequestMapping("/user")
public class ForgotPasswordController {
	
/** The Constant LOG. */
private static final Logger LOG = Logger.getLogger(ForgotPasswordController.class.getName());
	
	/** The forgotservice. */
	@Autowired
	public ForgotPasswordService forgotservice;
	
	/** The service output transformer. */
	@Autowired
	private ServiceOutputTransformer serviceOutputTransformer;

	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the response entity
	 */
	@PostMapping("/forgotPassword")
	public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDataDTO forgotPwd){
		LOG.info("START-Inside ForgotPassword ");
		LOG.log(Level.INFO, () -> " forgotPassword Inputs forgotPwd: "+forgotPwd); 
		ResponseEntity<Object> response=null;
		try {
			LOG.log(Level.INFO, () -> "Before updating ForgotPassword : " );
			String newPassword = forgotPwd.getNewPassword();
			String confirmPassword = forgotPwd.getConfirmPassword();
			
			if (newPassword.equals(confirmPassword)) {
				Integer forgotPassword = forgotservice.forgotPassword(forgotPwd);
				if (forgotPassword!=null) {
					response =new ResponseEntity<>(true,HttpStatus.OK);
					return response;
				}else {
					throw new CustomException(ErrorConstants.INVALID_CUSTOMER);
				}
			}else {
				LOG.log(Level.INFO, () -> ErrorConstants.PASSWORD_MISMATCH);
				response = new ResponseEntity<>(serviceOutputTransformer.responseOutput(ErrorConstants.PROMPT_VALID_PASSWORD,false),HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
		}
		LOG.info("START-Inside ForgotPassword ");
		return response;
	}
}
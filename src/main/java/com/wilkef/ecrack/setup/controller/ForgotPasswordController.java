/**
 * 
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

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;
import com.wilkef.ecrack.setup.service.ForgotPasswordService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * This Class is Used to Execute ForgotPassword Execution
 * 
 * @author Satya
 * Sep 19, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/user")
public class ForgotPasswordController {
	
private static final Logger LOG = Logger.getLogger(ForgotPasswordController.class.getName());
	
	@Autowired
	public ForgotPasswordService forgotservice;
	
	@Autowired
	private ServiceOutputTransformer serviceOutputTransformer;

	@PostMapping("/forgotPassword")
	public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDataDTO forgotPwd){
		ResponseEntity<Object> response=null;
		LOG.info("Inside ForgotPassword ");
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
					LOG.log(Level.INFO, () -> "Invalid UserName ");
					response = new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
					return response;
				}
			}else {
				LOG.log(Level.INFO, () -> "NewPasswor And ConformPassword Both Are not Same ");
				response = new ResponseEntity<>(serviceOutputTransformer.responseOutput("Please Enter NewPassword and ConformPassword Both are Same",false),HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while Updating the Password : " + e.getMessage());
		}
		return response;
	}
}
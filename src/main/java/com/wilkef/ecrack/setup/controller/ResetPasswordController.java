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

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.service.ResetPasswordService;

/**
 * This Class is Used to execute ResetPassword Controller
 * 
 * @author Satya
 *Sep 19, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/user")
public class ResetPasswordController {
	
	private static final Logger LOG = Logger.getLogger(ResetPasswordController.class.getName());
	
	@Autowired
	public ResetPasswordService service;
	
	@PostMapping(value = "/resetPassword",consumes = "application/json")
	public ResponseEntity<Boolean> resetPwd(@RequestBody ResetPasswordDataDTO resetPwd) {
		
		ResponseEntity<Boolean> response=null;
		LOG.info("Inside ResetPassword ");
		try {
			LOG.log(Level.INFO, () -> "Before updating resetPassword : " );
			Integer resetPassword = service.resetPassword(resetPwd);
	
			if (resetPassword!=null) {
				response =new ResponseEntity<>(true,HttpStatus.OK);
				return response;
			}else {
				LOG.log(Level.INFO, () -> "UserId is InValid" );
				response = new ResponseEntity<>(false,HttpStatus.OK);
				return response;
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while Updating the Password : " + e.getMessage());
		}
		return response;
	}
}

/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.RegistrationService;

/**
 * This Class is Identify to execute Registration Controller
 * 
 * @author Satya
 *Sep 20, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/user")
public class RegistrationController {

	private static final Logger LOG = Logger.getLogger(RegistrationController.class.getName());
	
	@Autowired
	private RegistrationService registerationService;

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody String register) {
		LOG.info("Inside Registration Controller ");
		ResponseEntity<?> response=null;
		List<RegistrationDataDTO> save = null;
		try {
			LOG.log(Level.INFO, () -> "Before Registration : " );
			JSONObject obj = new JSONObject(register);
			save = registerationService.save(obj);
			
			if (save.get(0).getMESSAGE_TEXT()==null) {
				response=new ResponseEntity<>(save,HttpStatus.OK);
			}else if(save.get(0).getMESSAGE_TEXT()!=null && save.get(0).getMESSAGE_TEXT().equals("User already exist.")) {		
				LOG.log(Level.INFO, () -> "User Already Exists" );
				throw new CustomException("User Already Exists");
			}
			else {
				LOG.log(Level.INFO, () -> "Some Problem Occored at the Registration Time" );
				response=new ResponseEntity<>("Unable to Store Record",HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while Registration Process : " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
}

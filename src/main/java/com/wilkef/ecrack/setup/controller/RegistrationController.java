/**
 * This Class is Identify to execute Registration Controller
 * 
 * @author Satya
 *Sep 20, 2020
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.RegistrationService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class RegistrationController.
 */
@RestController
@RequestMapping("/user")
public class RegistrationController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RegistrationController.class.getName());

	/** The registeration service. */
	@Autowired
	private RegistrationService registerationService;

	/** The service output transformer. */
	@Autowired
	private ServiceOutputTransformer serviceOutputTransformer;

	/**
	 * Save user.
	 *
	 * @param register the register
	 * @return the response entity
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> saveUser(@RequestBody String register) {

		LOG.info("START-Inside saveUser");
		LOG.log(Level.INFO, () -> " get All User Details to register: " + register);
		ResponseEntity<Object> response = null;
		List<RegistrationDataDTO> save = null;
		try {
			JSONObject obj = new JSONObject(register);

			String fname = (String) obj.get("FirstName");
			String strGender = (String) obj.get("Gender");
			String mobile = (String) obj.get("MobileNumber");

			if (!fname.equals("") && !fname.isEmpty()) {
				if (!strGender.equals("") && !strGender.isEmpty()) {
					boolean name = Pattern.compile("[A-Za-z]*").matcher(fname).matches();
					boolean gender = Pattern.compile("[A-Za-z]{2,6}").matcher(strGender).matches();
					boolean mobileNo = Pattern.compile("\\d{10}").matcher(mobile).matches();

					if (name) {
						if (gender) {
							if (mobileNo) {
								save = registerationService.save(obj);
							} else
								throw new CustomException("Please Enter a Valid Mobile No.");
						} else
							throw new CustomException("Please Enter a Valid Gender");
					} else
						throw new CustomException("Please Enter a Valid Name");
				} else
					throw new CustomException("Please Enter Gender");
			} else
				throw new CustomException("Please Enter Name");

			if (save.get(0).getMESSAGE_TEXT() == null) {
				response = new ResponseEntity<>(save, HttpStatus.OK);
			} else if (save.get(0).getMESSAGE_TEXT() != null
					&& save.get(0).getMESSAGE_TEXT().equals("User already exist.")) {
				throw new CustomException(ErrorConstants.USER_ALREADY_EXISTS);
			} else {
				LOG.log(Level.INFO, () -> "Some Problem Occored at the Registration Time");
				response = new ResponseEntity<>(
						serviceOutputTransformer.responseOutput(ErrorConstants.UNABLE_TO_STORE, false),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside saveUser");
		return response;
	}
}

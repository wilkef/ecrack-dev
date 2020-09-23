/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ForgotPasswordDao;
import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;
import com.wilkef.ecrack.setup.service.ForgotPasswordService;

/**
 * This Class is Used to Execute Forgot Password Service Class Implementation
 * 
 * @author Satya
 * Sep 19, 2020
 */

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService{

	public static final Logger LOG = Logger.getLogger(ForgotPasswordServiceImpl.class.getName());
	
	@Autowired
	private ForgotPasswordDao forgotpwd;
	
	@Override
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd) {
		Integer forgotPassword=null;
		try {
			forgotPassword = forgotpwd.forgotPassword(forgotPwd);
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With Forgot Passsword : " + exception.getMessage());
		}
		return forgotPassword;
	}
}

/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ForgotPasswordDao;
import com.wilkef.ecrack.setup.dao.ResetPasswordDao;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.service.ForgotPasswordService;

/**
 * This Class is Used to Execute Forgot Password Service Class Implementation.
 *
 * @author Satya Sep 19, 2020
 */

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ForgotPasswordServiceImpl.class.getName());

	@Autowired
	private ResetPasswordDao resetPasswordDao;

	@Autowired
	private ForgotPasswordDao forgotPasswordDao;

	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the integer
	 */
	@Override
	public Boolean resetPassword(ResetPasswordDataDTO resetPasswordData) {
		Boolean status = Boolean.FALSE;
		try {
			status = resetPasswordDao.resetPassword(resetPasswordData);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With Reset Password : " + e.getMessage());
		}
		return status;
	}

	@Override
	public String setVerificationCode(String mobileNo) {
		String verificationCode = null;
		try {
			verificationCode = forgotPasswordDao.setVerificationCode(mobileNo);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while setting verificationCode : " + e.getMessage());
		}
		return verificationCode;
	}

	@Override
	public boolean removeVerificationCode(String mobileNo) {
		boolean status = Boolean.FALSE;
		try {
			status = forgotPasswordDao.removeVerificationCode(mobileNo);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while removing VerificationCode : " + e.getMessage());
		}
		return status;
	}

}

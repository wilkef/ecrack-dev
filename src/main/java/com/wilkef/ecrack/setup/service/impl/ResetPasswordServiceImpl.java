/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ResetPasswordDao;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.service.ResetPasswordService;


/**
 * This Class is Used to Execute Reset Password Service Class Implementation.
 *
 * @author Satya
 * Sep 19, 2020
 */

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService{

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ResetPasswordServiceImpl.class.getName());
	
	/** The reset dao. */
	@Autowired
	public ResetPasswordDao resetDao;
	
	/**
	 * Reset password.
	 *
	 * @param resetPwd the reset pwd
	 * @return the integer
	 */
	@Override
	public Integer resetPassword(ResetPasswordDataDTO resetPwd) {
		Integer resetPasswords=null;
		try {
			resetPasswords = resetDao.resetPassword(resetPwd);
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With Reset Passsword : " + exception.getMessage());
		}
		return resetPasswords;
	}
}

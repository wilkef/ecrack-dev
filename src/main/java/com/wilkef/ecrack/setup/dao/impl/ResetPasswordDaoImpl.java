/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ResetPasswordDao;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;

/**
 * This Class is Used to implement DB Operation in ResetPassword.
 *
 * @author Satya Sep 19, 2020
 */

@Repository
public class ResetPasswordDaoImpl implements ResetPasswordDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ResetPasswordDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Reset password.
	 *
	 * @param resetPwd the reset pwd
	 * @return the integer
	 */
	@Override
	public Boolean resetPassword(ResetPasswordDataDTO resetPasswordData) {
		LOG.fine("ResetPassword DB Operation Started ");
		String userName = resetPasswordData.getUserName();
		String newPassword = resetPasswordData.getNewPassword();
		String verificationCode = resetPasswordData.getVerificationCode();
		Boolean status = Boolean.TRUE;
		try {
			String sql = WilkefConstants.RESET_PASSWORD;
			appJdbcTemplate.update(sql, newPassword, null, userName, verificationCode);
		} catch (Exception e) {
			status = Boolean.FALSE;
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return status;
	}
}

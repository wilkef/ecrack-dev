/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ForgotPasswordDao;

/**
 * This Class is Used to execute DB operation of Forgot Password.
 *
 * @author Satya Sep 19, 2020
 */

@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ForgotPasswordDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public String setVerificationCode(String mobileNo) {
		String verificationCode = UUID.randomUUID().toString();
		try {
			String query = WilkefConstants.SET_VERIFICATION_CDOE;
			appJdbcTemplate.update(query, verificationCode, mobileNo);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while ForgotPassword ");
		}
		return verificationCode;
	}

	@Override
	public boolean removeVerificationCode(String mobileNo) {
		String verificationCode = null;
		try {
			String query = WilkefConstants.SET_VERIFICATION_CDOE;
			appJdbcTemplate.update(query, verificationCode, mobileNo);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while ForgotPassword ");
		}
		return true;
	}

}

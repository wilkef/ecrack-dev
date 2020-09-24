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
import com.wilkef.ecrack.setup.dao.ForgotPasswordDao;
import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;


/**
 * This Class is Used to execute DB operation of Forgot Password.
 *
 * @author Satya
 * Sep 19, 2020
 */

@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ForgotPasswordDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the integer
	 */
	@Override
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd) {

		String confirmPassword = forgotPwd.getConfirmPassword();
		Long userName = forgotPwd.getUserName();
		Integer status=null;

		try {
			LOG.fine("Forgot Password DB Execution Started");
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.FORGOTPASSWORD);

			Map<String, Object> execute = simpleJdbcCall.execute(userName,confirmPassword);
			status = (Integer) execute.get("v_IsSuccess");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while ForgotPassword ");
		}
		return status;
	}
}

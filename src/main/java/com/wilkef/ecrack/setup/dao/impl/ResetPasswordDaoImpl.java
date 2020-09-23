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
 * This Class is Used to implement DB Operation in ResetPassword
 * 
 * @author Satya
 * Sep 19, 2020
 */

@Repository
public class ResetPasswordDaoImpl implements ResetPasswordDao{

	public static final Logger LOG = Logger.getLogger(ResetPasswordDaoImpl.class.getName());
	
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@Override
	public Integer resetPassword(ResetPasswordDataDTO resetPwd) {
		
		Integer userId = resetPwd.getUserId();
		String oldPassword = resetPwd.getOldPassword();
		String newPassword = resetPwd.getNewPassword();
		Integer status=null;
		
		try {
			LOG.fine("ResetPassword DB Operation Started ");
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
			           .withProcedureName(WilkefConstants.RESETPASSWORD);
			           
			    Map<String, Object> execute = simpleJdbcCall.execute(userId,oldPassword,newPassword);
			    status = (Integer) execute.get("v_IsSuccess");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while ResetPassword ");
		}
		return status;
	}
}
/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;

/**
 * The Interface ForgotPasswordDao.
 *
 * @author Satya
 * Sep 19, 2020
 */
public interface ForgotPasswordDao {
	
	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the integer
	 */
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd);
}

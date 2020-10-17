/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;


/**
 * The Interface ResetPasswordDao.
 *
 * @author Satya
 * Sep 19, 2020
 */

public interface ResetPasswordDao {
	
	/**
	 * Reset password.
	 *
	 * @param resetPwd the reset pwd
	 * @return the integer
	 */
	public Integer resetPassword(ResetPasswordDataDTO resetPwd);
}

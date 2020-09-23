/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;

/**
 * @author Satya
 *Sep 19, 2020
 */
public interface ForgotPasswordDao {
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd);
}

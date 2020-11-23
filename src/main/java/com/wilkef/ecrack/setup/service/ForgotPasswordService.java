/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;

/**
 * This interface will be holding all the service methods related to Forgot
 * Password.
 * 
 * @author Satya Sep 19, 2020
 */
public interface ForgotPasswordService {

	/**
	 * Forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 * @return the integer
	 */
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd);
}

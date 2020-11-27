/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;

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
	public Boolean resetPassword(ResetPasswordDataDTO resetPasswordData);
	
	public String setVerificationCode(String mobileNo);
	
	public boolean removeVerificationCode(String mobileNo);
}

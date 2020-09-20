/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;

/**
 * This interface will be holding all the service methods related to Forgot Password.
 * 
 * @author Satya
 *Sep 19, 2020
 */
public interface ForgotPasswordService {
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd);
}

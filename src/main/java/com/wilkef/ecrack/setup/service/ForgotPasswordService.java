/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;

/**
 * @author Satya
 *Sep 19, 2020
 */
public interface ForgotPasswordService {
	public Integer forgotPassword(ForgotPasswordDataDTO forgotPwd);
}

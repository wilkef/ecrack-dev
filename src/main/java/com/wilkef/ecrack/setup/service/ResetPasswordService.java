/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;

/**
 * This interface will be holding all the service methods related to ResetPassword.
 * 
 * @author Satya
 * Sep 19, 2020
 */
public interface ResetPasswordService {
	public Integer resetPassword(ResetPasswordDataDTO resetPwd);
}

/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;

/**
 * @author Satya
 * Sep 19, 2020
 */
public interface ResetPasswordService {
	public Integer resetPassword(ResetPasswordDataDTO resetPwd);
}

/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;

/**
 * @author Satya
 *Sep 19, 2020
 */

public interface ResetPasswordDao {
	public Integer resetPassword(ResetPasswordDataDTO resetPwd);
}

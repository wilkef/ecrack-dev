package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.ChangePasswordDataDTO;

/**
 * The Interface UserProfileService.
 */
public interface UserProfileService {

	/**
	 * Change Password.
	 *
	 * @param ChangePassword changePasswordData
	 * @param String         userId
	 * @return the integer
	 */
	public Integer changePassword(ChangePasswordDataDTO changePasswordData, String userId);

}

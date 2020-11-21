package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.ChangePasswordDataDTO;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;

/**
 * The Interface UserProfileDao.
 */
public interface UserProfileDao {

	/**
	 * Update profile.
	 *
	 * @param input the input
	 * @param userId the user id
	 * @return the list
	 */
	List<UserProfileDTO> updateProfile(@Valid String input, String userId);

	/**
	 * View profile.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	List<UserProfileDTO> viewProfile(@Valid String userId);
	
	/**
	 * Change Password.
	 *
	 * @param ChangePasswordDataDTO changePasswordData
	 * @param String userName
	 * @return the status (int)
	 */
	Integer changePassword(ChangePasswordDataDTO changePasswordData, String userName);

}

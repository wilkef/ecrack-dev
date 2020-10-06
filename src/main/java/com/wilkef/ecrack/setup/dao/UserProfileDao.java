package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

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
	List<UserProfileDTO> updateProfile(@Valid String input);

	/**
	 * View profile.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	List<UserProfileDTO> viewProfile(@Valid int userId);

}

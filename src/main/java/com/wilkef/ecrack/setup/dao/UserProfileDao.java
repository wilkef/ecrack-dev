package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.UserProfileDTO;

public interface UserProfileDao {

	List<UserProfileDTO> updateProfile(@Valid String input, @Valid int userId);

	List<UserProfileDTO> viewProfile(@Valid int userId);

}

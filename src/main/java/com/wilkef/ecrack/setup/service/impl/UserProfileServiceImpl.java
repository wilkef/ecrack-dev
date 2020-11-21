package com.wilkef.ecrack.setup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.BoardDao;
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dto.ChangePasswordDataDTO;
import com.wilkef.ecrack.setup.service.UserProfileService;

/**
 * The Class UserProfileServiceImpl.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService{
 
	@Autowired
	private UserProfileDao userProfileDao;
	
	@Override
	public Integer changePassword(ChangePasswordDataDTO changePasswordData, String userId) {
		return this.userProfileDao.changePassword(changePasswordData, userId);
	}
	
}

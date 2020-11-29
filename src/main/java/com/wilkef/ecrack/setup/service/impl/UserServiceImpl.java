package com.wilkef.ecrack.setup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.AuthDataDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ValidationDao validationDao;

	@Override
	public Boolean isValidUser(String username, String password) {
		return validationDao.validateUserLogin(username, password);
	}

	@Override
	public AuthDataDTO getAuthData(String username, String token) {
		return validationDao.getAuthData(username, token);
	}
	
	@Override
	public LoggedinUserInfo getLoggedinUserInfo(String token) {
		return validationDao.getLoggedinUserInfo(token);
	}

}

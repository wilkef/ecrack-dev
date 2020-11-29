package com.wilkef.ecrack.setup.service;

import com.wilkef.ecrack.setup.dto.AuthDataDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;

public interface UserService {

	public Boolean isValidUser(String username, String password);
	
	public AuthDataDTO getAuthData(String username, String token);
	
	public LoggedinUserInfo getLoggedinUserInfo(String token);

}

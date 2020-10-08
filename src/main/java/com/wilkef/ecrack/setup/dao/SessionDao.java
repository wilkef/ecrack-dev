package com.wilkef.ecrack.setup.dao;

public interface SessionDao {

	long sessionLogin(String input);

	String sessionLogout(long sessionId, long userId);

	
}

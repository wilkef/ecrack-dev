package com.wilkef.ecrack.setup.dto;

public class SessionDTO {

	private long lastInserId;

	private String SessionStatus;

	public String getSessionStatus() {
		return SessionStatus;
	}

	public void setSessionStatus(String sessionStatus) {
		SessionStatus = sessionStatus;
	}

	public long getLastInserId() {
		return lastInserId;
	}

	public void setLastInserId(long lastInserId) {
		this.lastInserId = lastInserId;
	}

}

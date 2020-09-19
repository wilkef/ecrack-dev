/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * This class is representing POJO class
 * 
 * @author Satya
 * Sep 19, 2020
 */


public class ResetPasswordDataDTO {
	
	private Integer userId;
	private String oldPassword;
	private String newPassword;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	@Override
	public String toString() {
		return "ResetPasswordDataDTO [userId=" + userId + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
}

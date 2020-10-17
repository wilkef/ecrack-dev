/**
 * 
 */
package com.wilkef.ecrack.setup.dto;


/**
 * This class is representing POJO class.
 *
 * @author Satya
 * Sep 19, 2020
 */


public class ResetPasswordDataDTO {
	
	/** The user id. */
	private String userName;
	
	/** The old password. */
	private String oldPassword;
	
	/** The new password. */
	private String newPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "ResetPasswordDataDTO [userName=" + userName + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
}

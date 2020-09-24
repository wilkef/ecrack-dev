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
	private Integer userId;
	
	/** The old password. */
	private String oldPassword;
	
	/** The new password. */
	private String newPassword;
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the old password.
	 *
	 * @return the old password
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	
	/**
	 * Sets the old password.
	 *
	 * @param oldPassword the new old password
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	/**
	 * Gets the new password.
	 *
	 * @return the new password
	 */
	public String getNewPassword() {
		return newPassword;
	}
	
	/**
	 * Sets the new password.
	 *
	 * @param newPassword the new new password
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ResetPasswordDataDTO [userId=" + userId + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
}

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
public class ForgotPasswordDataDTO {
	private Long userName;
	private String newPassword;
	private String confirmPassword;
	
	public Long getUserName() {
		return userName;
	}
	public void setUserName(Long userName) {
		this.userName = userName;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "ForgotPasswordDataDTO [userName=" + userName + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
}

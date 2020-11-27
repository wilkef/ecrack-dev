/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * This class is representing POJO class.
 *
 * @author Satya Sep 19, 2020
 */

public class ResetPasswordDataDTO {

	private String userName;
	private String newPassword;
	private String confirmPassword;
	private String verificationCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		return "ResetPasswordDataDTO [userName=" + userName + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "verificationCode=" + verificationCode + "]";
	}
}

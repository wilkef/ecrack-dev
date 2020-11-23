/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * This class is representing POJO class.
 *
 * @author Satya Sep 19, 2020
 */
public class ForgotPasswordDataDTO {

	/** The user name. */
	private Long userName;

	/** The new password. */
	private String newPassword;

	/** The confirm password. */
	private String confirmPassword;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public Long getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(Long userName) {
		this.userName = userName;
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
	 * Gets the confirm password.
	 *
	 * @return the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ForgotPasswordDataDTO [userName=" + userName + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}

}

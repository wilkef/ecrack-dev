/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to Authentication
 *
 */

package com.wilkef.ecrack.setup.dto;

/**
 * The Class AuthDataDTO.
 */
public class AuthDataDTO {

	
	/** The Token. */
	private String token;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String firstName;
	
	private String lastName;
	
	private int gradeId;
	
	private String gradeName;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "AuthDataDTO [token=" + token + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gradeId=" + gradeId + ", gradeName="
				+ gradeName + "]";
	}
	
	
}

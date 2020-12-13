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
	private String middleName;
	private String lastName;
	private String name;
	private int gradeId;
	private String gradeName;
	private String userType;

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "AuthDataDTO [token=" + token + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", name="
				+ name + ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", userType=" + userType + "]";
	}

}

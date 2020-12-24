package com.wilkef.ecrack.setup.dto;

public class LoggedinUserInfo {
	private int userId;
	private String emailId;
	private String mobileNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private int gradeId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "LoggedinUserInfo [userId=" + userId + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", name="
				+ name + ", gradeId=" + gradeId + "]";
	}
	
	

}

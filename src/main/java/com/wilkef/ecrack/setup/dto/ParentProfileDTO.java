package com.wilkef.ecrack.setup.dto;

public class ParentProfileDTO {

	private String MobileNumber;
	private String EmailId;
	private String FirstName;
	private String MiddleName;
	private String Gender;
	private String DateOfBirth;
	private String ProfileImagePath;
	private String PrimaryAddress;
	
	private int StateId;
	private int CountryId;
	private String CityName;
	private String CountryName;
	private String StateName;
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getProfileImagePath() {
		return ProfileImagePath;
	}
	public void setProfileImagePath(String profileImagePath) {
		ProfileImagePath = profileImagePath;
	}
	public String getPrimaryAddress() {
		return PrimaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		PrimaryAddress = primaryAddress;
	}

	/*
	 * public int getCityId() { return CityId; } public void setCityId(int cityId) {
	 * CityId = cityId; }
	 */
	public int getStateId() {
		return StateId;
	}
	public void setStateId(int stateId) {
		StateId = stateId;
	}
	public int getCountryId() {
		return CountryId;
	}
	public void setCountryId(int countryId) {
		CountryId = countryId;
	}
}

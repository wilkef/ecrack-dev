package com.wilkef.ecrack.setup.dto;

import java.util.List;

public class ProfileDTO {


	private String CityId ;
	private String Gender ;
	private  List <ParentDTO> Parent ;
	private String EmailId;
	private String StateId ;
	private String CityName ;
	private String CountryId ;
	private String FirstName;
	private String StateName ;
	private String MiddleName ;
	private String LastName;
	private String CountryName ;
	private String DateOfBirth ;
	private String MobileNumber;
	private String PrimaryAddress ;
	private String ProfileImagePath ;


	// Getter Methods

	public List<ParentDTO> getParent() {
		return Parent;
	}

	public void setParent(List<ParentDTO> parent) {
		Parent = parent;
	}

	public String getCityId() {
		return CityId;
	}

	public String getGender() {
		return Gender;
	}

	public String getEmailId() {
		return EmailId;
	}

	public String getStateId() {
		return StateId;
	}

	public String getCityName() {
		return CityName;
	}

	public String getCountryId() {
		return CountryId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getStateName() {
		return StateName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getCountryName() {
		return CountryName;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public String getPrimaryAddress() {
		return PrimaryAddress;
	}

	public String getProfileImagePath() {
		return ProfileImagePath;
	}

	// Setter Methods 

	public void setCityId(String CityId) {
		this.CityId = CityId;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public void setEmailId(String EmailId) {
		this.EmailId = EmailId;
	}

	public void setStateId(String StateId) {
		this.StateId = StateId;
	}

	public void setCityName(String CityName) {
		this.CityName = CityName;
	}

	public void setCountryId(String CountryId) {
		this.CountryId = CountryId;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public void setStateName(String StateName) {
		this.StateName = StateName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public void setCountryName(String CountryName) {
		this.CountryName = CountryName;
	}

	public void setDateOfBirth(String DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}

	public void setMobileNumber(String MobileNumber) {
		this.MobileNumber = MobileNumber;
	}

	public void setPrimaryAddress(String PrimaryAddress) {
		this.PrimaryAddress = PrimaryAddress;
	}

	public void setProfileImagePath(String ProfileImagePath) {
		this.ProfileImagePath = ProfileImagePath;
	}
}

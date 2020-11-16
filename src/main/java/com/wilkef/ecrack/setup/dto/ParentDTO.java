package com.wilkef.ecrack.setup.dto;

public class ParentDTO {
	

	    private String CountryId;

	    private String DateOfBirth;

	    private String EmailId;

	    private String PrimaryAddress;

	    private String ProfileImagePath;

	    private String CountryName;

	    private String FirstName;

	    private String StateName;

	    private String StateId;

	    private String Gender;

	    private String CityName;

	    private String MiddleName;

	    private String MobileNumber;

	    private String CityId;

	    public String getCountryId ()
	    {
	        return CountryId;
	    }

	    public void setCountryId (String CountryId)
	    {
	        this.CountryId = CountryId;
	    }

	    public String getDateOfBirth ()
	    {
	        return DateOfBirth;
	    }

	    public void setDateOfBirth (String DateOfBirth)
	    {
	        this.DateOfBirth = DateOfBirth;
	    }

	    public String getEmailId ()
	    {
	        return EmailId;
	    }

	    public void setEmailId (String EmailId)
	    {
	        this.EmailId = EmailId;
	    }

	    public String getPrimaryAddress ()
	    {
	        return PrimaryAddress;
	    }

	    public void setPrimaryAddress (String PrimaryAddress)
	    {
	        this.PrimaryAddress = PrimaryAddress;
	    }

	    public String getProfileImagePath ()
	    {
	        return ProfileImagePath;
	    }

	    public void setProfileImagePath (String ProfileImagePath)
	    {
	        this.ProfileImagePath = ProfileImagePath;
	    }

	    public String getCountryName ()
	    {
	        return CountryName;
	    }

	    public void setCountryName (String CountryName)
	    {
	        this.CountryName = CountryName;
	    }

	    public String getFirstName ()
	    {
	        return FirstName;
	    }

	    public void setFirstName (String FirstName)
	    {
	        this.FirstName = FirstName;
	    }

	    public String getStateName ()
	    {
	        return StateName;
	    }

	    public void setStateName (String StateName)
	    {
	        this.StateName = StateName;
	    }

	    public String getStateId ()
	    {
	        return StateId;
	    }

	    public void setStateId (String StateId)
	    {
	        this.StateId = StateId;
	    }

	    public String getGender ()
	    {
	        return Gender;
	    }

	    public void setGender (String Gender)
	    {
	        this.Gender = Gender;
	    }

	    public String getCityName ()
	    {
	        return CityName;
	    }

	    public void setCityName (String CityName)
	    {
	        this.CityName = CityName;
	    }

	    public String getMiddleName ()
	    {
	        return MiddleName;
	    }

	    public void setMiddleName (String MiddleName)
	    {
	        this.MiddleName = MiddleName;
	    }

	    public String getMobileNumber ()
	    {
	        return MobileNumber;
	    }

	    public void setMobileNumber (String MobileNumber)
	    {
	        this.MobileNumber = MobileNumber;
	    }

	    public String getCityId ()
	    {
	        return CityId;
	    }

	    public void setCityId (String CityId)
	    {
	        this.CityId = CityId;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [CountryId = "+CountryId+", DateOfBirth = "+DateOfBirth+", EmailId = "+EmailId+", PrimaryAddress = "+PrimaryAddress+", ProfileImagePath = "+ProfileImagePath+", CountryName = "+CountryName+", FirstName = "+FirstName+", StateName = "+StateName+", StateId = "+StateId+", Gender = "+Gender+", CityName = "+CityName+", MiddleName = "+MiddleName+", MobileNumber = "+MobileNumber+", CityId = "+CityId+"]";
	    }
	
}

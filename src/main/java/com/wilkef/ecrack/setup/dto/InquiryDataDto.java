/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 *Dec 2, 2020
 */
public class InquiryDataDto {
	
	private Integer inquiryId;
	private String name;
	private String phoneNumber;
	private String email;
	private String message;
	
	public Integer getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(Integer inquiryId) {
		this.inquiryId = inquiryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "InquiryDataDto [inquiryId=" + inquiryId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", message=" + message + "]";
	}
}

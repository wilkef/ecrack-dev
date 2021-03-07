/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya Dec 2, 2020
 * @modified by Pradeepta Khatoi on 7th Mar 2021
 */
public class InquiryDataDto {

	private Integer inquiryId;
	private String name;
	private String phone;
	private String email;
	private String subject;
	private String message;
	private String createdAt;
	private Boolean isReplied;
	private String reply;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsReplied() {
		return isReplied;
	}

	public void setIsReplied(Boolean isReplied) {
		this.isReplied = isReplied;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "InquiryDataDto [inquiryId=" + inquiryId + ", name=" + name + ", phoneNumber=" + phone + ", email="
				+ email + ", subject=" + subject + ", message=" + message + ", createdAt=" + createdAt + ", isReplied="
				+ isReplied + ", reply=" + reply + "]";
	}

}

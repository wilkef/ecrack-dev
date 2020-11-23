/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */

package com.wilkef.ecrack.setup.dto;

/**
 * The Class ValidationDTO.
 */
public class ValidationDTO {

	/** The p is valid email id. */
	private Integer p_isValidEmailId;

	/** The p is valid mobile. */
	private Integer p_isValidMobile;

	/** The p mobile no. */
	private String p_mobileNo;

	/** The p otp. */
	private String p_otp;

	/** The p msg. */
	private String p_msg;

	private String p_UserId;

	public String getP_UserId() {
		return p_UserId;
	}

	public void setP_UserId(String p_UserId) {
		this.p_UserId = p_UserId;
	}

	private Boolean isSuccess = Boolean.TRUE;

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	/**
	 * Gets the p msg.
	 *
	 * @return the p msg
	 */
	public String getP_msg() {
		return p_msg;
	}

	/**
	 * Sets the p msg.
	 *
	 * @param p_msg the new p msg
	 */
	public void setP_msg(String p_msg) {
		this.p_msg = p_msg;
	}

	/**
	 * Gets the p mobile no.
	 *
	 * @return the p mobile no
	 */
	public String getP_mobileNo() {
		return p_mobileNo;
	}

	/**
	 * Sets the p mobile no.
	 *
	 * @param p_mobileNo the new p mobile no
	 */
	public void setP_mobileNo(String p_mobileNo) {
		this.p_mobileNo = p_mobileNo;
	}

	/**
	 * Gets the p otp.
	 *
	 * @return the p otp
	 */
	public String getP_otp() {
		return p_otp;
	}

	/**
	 * Sets the p otp.
	 *
	 * @param p_otp the new p otp
	 */
	public void setP_otp(String p_otp) {
		this.p_otp = p_otp;
	}

	/**
	 * Gets the p is valid mobile.
	 *
	 * @return the p is valid mobile
	 */
	public Integer getP_isValidMobile() {
		return p_isValidMobile;
	}

	/**
	 * Sets the p is valid mobile.
	 *
	 * @param p_isValidMobile the new p is valid mobile
	 */
	public void setP_isValidMobile(Integer p_isValidMobile) {
		this.p_isValidMobile = p_isValidMobile;
	}

	/**
	 * Gets the p is valid email id.
	 *
	 * @return the p is valid email id
	 */
	public Integer getP_isValidEmailId() {
		return p_isValidEmailId;
	}

	/**
	 * Sets the p is valid email id.
	 *
	 * @param p_isValidEmailId the new p is valid email id
	 */
	public void setP_isValidEmailId(Integer p_isValidEmailId) {
		this.p_isValidEmailId = p_isValidEmailId;
	}
}

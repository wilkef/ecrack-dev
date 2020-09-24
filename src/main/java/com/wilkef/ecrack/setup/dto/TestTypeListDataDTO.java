/**
 * 
 */
package com.wilkef.ecrack.setup.dto;


/**
 * The Class TestTypeListDataDTO.
 *
 * @author Satya
 * Sep 20, 2020
 */
public class TestTypeListDataDTO {
	
	/** The test type id. */
	private Integer testTypeId;
	
	/** The test type. */
	private String testType; 
	
	/** The test time. */
	private String testTime;
	
	/** The no of question. */
	private Integer noOfQuestion;
	
	/** The is active. */
	private Integer isActive;
	
	/**
	 * Gets the test type id.
	 *
	 * @return the test type id
	 */
	public Integer getTestTypeId() {
		return testTypeId;
	}
	
	/**
	 * Sets the test type id.
	 *
	 * @param testTypeId the new test type id
	 */
	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}
	
	/**
	 * Gets the test type.
	 *
	 * @return the test type
	 */
	public String getTestType() {
		return testType;
	}
	
	/**
	 * Sets the test type.
	 *
	 * @param testType the new test type
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	/**
	 * Gets the test time.
	 *
	 * @return the test time
	 */
	public String getTestTime() {
		return testTime;
	}
	
	/**
	 * Sets the test time.
	 *
	 * @param testTime the new test time
	 */
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	
	/**
	 * Gets the no of question.
	 *
	 * @return the no of question
	 */
	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}
	
	/**
	 * Sets the no of question.
	 *
	 * @param noOfQuestion the new no of question
	 */
	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	
	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public Integer getIsActive() {
		return isActive;
	}
	
	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TestTypeListDataDTO [testTypeId=" + testTypeId + ", testType=" + testType + ", testTime=" + testTime
				+ ", noOfQuestion=" + noOfQuestion + ", isActive=" + isActive + "]";
	}
	
	}

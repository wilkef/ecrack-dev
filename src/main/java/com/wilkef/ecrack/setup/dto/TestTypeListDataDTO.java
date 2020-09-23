/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 *Sep 20, 2020
 */
public class TestTypeListDataDTO {
	
	private Integer testTypeId;
	private String testType; 
	private String testTime;
	private Integer noOfQuestion;
	private Integer isActive;
	
	public Integer getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}
	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "TestTypeListDataDTO [testTypeId=" + testTypeId + ", testType=" + testType + ", testTime=" + testTime
				+ ", noOfQuestion=" + noOfQuestion + ", isActive=" + isActive + "]";
	}
	
	}

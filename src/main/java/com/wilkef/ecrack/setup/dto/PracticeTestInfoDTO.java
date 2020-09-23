/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 *Sep 21, 2020
 */
public class PracticeTestInfoDTO {
	
	 private Integer studentTestId;
	 private Integer testTypeId;  
	 private String testType;   
	 private Integer testTime;   
	 private Integer noOfQuestion;     
	 private Integer isActive;
	 
	public Integer getStudentTestId() {
		return studentTestId;
	}
	public void setStudentTestId(Integer studentTestId) {
		this.studentTestId = studentTestId;
	}
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
	public Integer getTestTime() {
		return testTime;
	}
	public void setTestTime(Integer testTime) {
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
		return "PracticeTestInfoDTO [studentTestId=" + studentTestId + ", testTypeId=" + testTypeId + ", testType="
				+ testType + ", testTime=" + testTime + ", noOfQuestion=" + noOfQuestion + ", isActive=" + isActive
				+ "]";
	}
}

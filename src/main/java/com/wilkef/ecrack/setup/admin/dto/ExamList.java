package com.wilkef.ecrack.setup.admin.dto;

public class ExamList {
	private Integer testId;
	private String testName;
	private String startDateTime;
	private String createdBy;
	private Boolean isActive;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Override
	public String toString() {
		return "ExamList [testId=" + testId + ", testName=" + testName + ", startDateTime=" + startDateTime + "]";
	}

}

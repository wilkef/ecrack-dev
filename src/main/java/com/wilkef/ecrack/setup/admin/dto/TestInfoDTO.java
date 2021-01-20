package com.wilkef.ecrack.setup.admin.dto;

import java.util.List;

public class TestInfoDTO {
	private Integer testId;
	private String testName;
	private Integer testTypeId;
	private Integer boardId;
	private Integer gradeId;
	private Integer difficultyLevel;
	private String startDateTime;
	private String endDateTime;
	private List<TestLineDTO> subjects;
	// private TestLineDTO[] subjects;
	
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

	public Integer getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public List<TestLineDTO> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<TestLineDTO> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "TestInfoDTO [testId=" + testId + ", testName=" + testName + ", testTypeId=" + testTypeId + ", boardId="
				+ boardId + ", gradeId=" + gradeId + ", difficultyLevel=" + difficultyLevel + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", subjects=" + subjects + "]";
	}

}

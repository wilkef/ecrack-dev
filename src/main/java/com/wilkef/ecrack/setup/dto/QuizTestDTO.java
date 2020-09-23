package com.wilkef.ecrack.setup.dto;

public class QuizTestDTO {

	private String TestId;
	
	private String TestName;
	
	private String DifficultyLevel;
	
	private String DifficultyCode;
	
	private String IsScheduled;
	private String ScheduledDateTime;
	
	private String EndDateTime;
	
	private String TotalQuestion;
	
	private String TotalMark;
	
	private String IsNegativeMarking;
	
	private String NegativeMark;
	
	private String IsActive;

	public String getTestId() {
		return TestId;
	}

	public void setTestId(String testId) {
		TestId = testId;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

	public String getDifficultyLevel() {
		return DifficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		DifficultyLevel = difficultyLevel;
	}

	public String getDifficultyCode() {
		return DifficultyCode;
	}

	public void setDifficultyCode(String difficultyCode) {
		DifficultyCode = difficultyCode;
	}

	public String getIsScheduled() {
		return IsScheduled;
	}

	public void setIsScheduled(String isScheduled) {
		IsScheduled = isScheduled;
	}

	public String getScheduledDateTime() {
		return ScheduledDateTime;
	}

	public void setScheduledDateTime(String scheduledDateTime) {
		ScheduledDateTime = scheduledDateTime;
	}

	public String getEndDateTime() {
		return EndDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		EndDateTime = endDateTime;
	}

	public String getTotalQuestion() {
		return TotalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		TotalQuestion = totalQuestion;
	}

	public String getTotalMark() {
		return TotalMark;
	}

	public void setTotalMark(String totalMark) {
		TotalMark = totalMark;
	}

	public String getIsNegativeMarking() {
		return IsNegativeMarking;
	}

	public void setIsNegativeMarking(String isNegativeMarking) {
		IsNegativeMarking = isNegativeMarking;
	}

	public String getNegativeMark() {
		return NegativeMark;
	}

	public void setNegativeMark(String negativeMark) {
		NegativeMark = negativeMark;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	
	
}

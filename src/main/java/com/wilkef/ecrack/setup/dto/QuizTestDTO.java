package com.wilkef.ecrack.setup.dto;

/**
 * The Class QuizTestDTO.
 */
public class QuizTestDTO {

	/** The Test id. */
	private Integer TestId;

	/** The Test name. */
	private String TestName;

	/** The Difficulty level. */
	private String DifficultyLevel;

	/** The Difficulty code. */
	private String DifficultyCode;

	/** The Is scheduled. */
	private String IsScheduled;

	/** The Scheduled date time. */
	private String ScheduledDateTime;

	/** The End date time. */
	private String EndDateTime;

	/** The Total question. */
	private Integer TotalQuestion;

	/** The Total mark. */
	private Integer TotalMark;

	/** The Is negative marking. */
	private String IsNegativeMarking;

	/** The Negative mark. */
	private String NegativeMark;

	/** The Is active. */
	private String IsActive;

	public Integer getTestId() {
		return TestId;
	}

	public void setTestId(Integer testId) {
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

	public Integer getTotalQuestion() {
		return TotalQuestion;
	}

	public void setTotalQuestion(Integer totalQuestion) {
		TotalQuestion = totalQuestion;
	}

	public Integer getTotalMark() {
		return TotalMark;
	}

	public void setTotalMark(Integer totalMark) {
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

	@Override
	public String toString() {
		return "QuizTestDTO [TestId=" + TestId + ", TestName=" + TestName + ", DifficultyLevel=" + DifficultyLevel
				+ ", DifficultyCode=" + DifficultyCode + ", IsScheduled=" + IsScheduled + ", ScheduledDateTime="
				+ ScheduledDateTime + ", EndDateTime=" + EndDateTime + ", TotalQuestion=" + TotalQuestion
				+ ", TotalMark=" + TotalMark + ", IsNegativeMarking=" + IsNegativeMarking + ", NegativeMark="
				+ NegativeMark + ", IsActive=" + IsActive + "]";
	}

}

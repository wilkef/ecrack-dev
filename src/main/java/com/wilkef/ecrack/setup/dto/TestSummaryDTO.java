package com.wilkef.ecrack.setup.dto;

import java.util.List;

public class TestSummaryDTO {
	private Integer activityId;
	private String lessonName;
	private Integer userId;
	private String uniqueId;
	private Integer lessonId;
	private Integer difficultyLevel;
	private Integer totalQuestion;
	private Integer correctAnswers;
	private Integer wrongAnswers;
	private Integer timeTaken;
	private List<TestSummaryQuestionDTO> questions;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(Integer totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Integer getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public Integer getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(Integer wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public List<TestSummaryQuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TestSummaryQuestionDTO> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "TestSummaryDTO [activityId=" + activityId + ", lessonName=" + lessonName + ", userId=" + userId
				+ ", uniqueId=" + uniqueId + ", lessonId=" + lessonId + ", difficultyLevel=" + difficultyLevel
				+ ", totalQuestion=" + totalQuestion + ", correctAnswers=" + correctAnswers + ", wrongAnswers="
				+ wrongAnswers + ", timeTaken=" + timeTaken + ", questions=" + questions + "]";
	}

}

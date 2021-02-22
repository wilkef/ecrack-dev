package com.wilkef.ecrack.setup.dto;

import java.util.ArrayList;
import java.util.List;

public class TestSummaryDTO {
	private Integer activityId;
	private Integer userId;
	private String uniqueId;
	private Integer lessonId;
	private Integer difficultyLevel;
	private List<TestSummaryQuestionDTO> questions;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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

	public List<TestSummaryQuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TestSummaryQuestionDTO> mcqList) {
		this.questions = mcqList;
	}

	@Override
	public String toString() {
		return "TestSummaryDTO [userId=" + userId + ", uniqueId=" + uniqueId + ", lessonId=" + lessonId
				+ ", difficultyLevel=" + difficultyLevel + ", questions=" + questions + "]";
	}
}

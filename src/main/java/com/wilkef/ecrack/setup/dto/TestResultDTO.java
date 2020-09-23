package com.wilkef.ecrack.setup.dto;

public class TestResultDTO {

	private String TotalQuestion;
	private String SkippedQuestion;
	private String AttendedQuestion;
	private String RightQuestion;
	private String WrongQuestion;
	private String TotalMark;
	private String MarkSecured;
	
	
	private String v_activityId;
	private String QuestionId;
	private String AnswerStatusId;
	private String TimeTaken;
	private String v_userid;
	
	public String getV_activityId() {
		return v_activityId;
	}
	public void setV_activityId(String v_activityId) {
		this.v_activityId = v_activityId;
	}
	public String getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(String questionId) {
		QuestionId = questionId;
	}
	public String getAnswerStatusId() {
		return AnswerStatusId;
	}
	public void setAnswerStatusId(String answerStatusId) {
		AnswerStatusId = answerStatusId;
	}
	public String getTimeTaken() {
		return TimeTaken;
	}
	public void setTimeTaken(String timeTaken) {
		TimeTaken = timeTaken;
	}
	public String getV_userid() {
		return v_userid;
	}
	public void setV_userid(String v_userid) {
		this.v_userid = v_userid;
	}
	public String getTotalQuestion() {
		return TotalQuestion;
	}
	public void setTotalQuestion(String totalQuestion) {
		TotalQuestion = totalQuestion;
	}
	public String getSkippedQuestion() {
		return SkippedQuestion;
	}
	public void setSkippedQuestion(String skippedQuestion) {
		SkippedQuestion = skippedQuestion;
	}
	public String getAttendedQuestion() {
		return AttendedQuestion;
	}
	public void setAttendedQuestion(String attendedQuestion) {
		AttendedQuestion = attendedQuestion;
	}
	public String getRightQuestion() {
		return RightQuestion;
	}
	public void setRightQuestion(String rightQuestion) {
		RightQuestion = rightQuestion;
	}
	public String getWrongQuestion() {
		return WrongQuestion;
	}
	public void setWrongQuestion(String wrongQuestion) {
		WrongQuestion = wrongQuestion;
	}
	public String getTotalMark() {
		return TotalMark;
	}
	public void setTotalMark(String totalMark) {
		TotalMark = totalMark;
	}
	public String getMarkSecured() {
		return MarkSecured;
	}
	public void setMarkSecured(String markSecured) {
		MarkSecured = markSecured;
	}
}

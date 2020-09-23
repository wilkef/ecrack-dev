package com.wilkef.ecrack.setup.dto;

public class QuizQuestionDTO {

	
	private String McqId;
	private String LessonId;
	private String Question;
	private String QuestionDesc;
	private String QuestionImg;
	private String OptionList;
	private String Solution;
	private String DifficultyCode;
	private String LessonName;
	public String getLessonName() {
		return LessonName;
	}
	public void setLessonName(String lessonName) {
		LessonName = lessonName;
	}
	public String getMcqId() {
		return McqId;
	}
	public void setMcqId(String mcqId) {
		McqId = mcqId;
	}
	public String getLessonId() {
		return LessonId;
	}
	public void setLessonId(String lessonId) {
		LessonId = lessonId;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getQuestionDesc() {
		return QuestionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		QuestionDesc = questionDesc;
	}
	public String getQuestionImg() {
		return QuestionImg;
	}
	public void setQuestionImg(String questionImg) {
		QuestionImg = questionImg;
	}
	public String getOptionList() {
		return OptionList;
	}
	public void setOptionList(String optionList) {
		OptionList = optionList;
	}
	public String getSolution() {
		return Solution;
	}
	public void setSolution(String solution) {
		Solution = solution;
	}
	public String getDifficultyCode() {
		return DifficultyCode;
	}
	public void setDifficultyCode(String difficultyCode) {
		DifficultyCode = difficultyCode;
	}
	
	
}

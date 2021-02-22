package com.wilkef.ecrack.setup.dto;

import java.util.Arrays;

public class QuizQuestionDTO {

	private String mcqId;
	private String question;
	private String questionDesc;
	private String questionImg;
	private QuestionOptionsDTO[] optionList;
	private String solution;
	private String difficultyCode;
	private String answer;

	public String getMcqId() {
		return mcqId;
	}

	public void setMcqId(String mcqId) {
		this.mcqId = mcqId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getQuestionImg() {
		return questionImg;
	}

	public void setQuestionImg(String questionImg) {
		this.questionImg = questionImg;
	}

	public QuestionOptionsDTO[] getOptionList() {
		return optionList;
	}

	public void setOptionList(QuestionOptionsDTO[] optionList) {
		this.optionList = optionList;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDifficultyCode() {
		return difficultyCode;
	}

	public void setDifficultyCode(String difficultyCode) {
		this.difficultyCode = difficultyCode;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QuizQuestionDTO [mcqId=" + mcqId + ", question=" + question + ", questionDesc=" + questionDesc
				+ ", questionImg=" + questionImg + ", optionList=" + Arrays.toString(optionList) + ", solution="
				+ solution + ", difficultyCode=" + difficultyCode + ", answer=" + answer + "]";
	}

}

package com.wilkef.ecrack.setup.dto;

import java.util.Arrays;

import com.wilkef.ecrack.setup.dto.QuestionOptionsDTO;

public class TestSummaryQuestionDTO {
	private Long mcqId;
	private String question;
	private String questionDesc;
	private String questionImg;
	private QuestionOptionsDTO[] optionList;
	public String answer;
	public Integer answerStatus;
	private String solution;
	public Integer timeTaken;
	public String selectedOptions;
	public Boolean isMultiChoice;

	public Long getMcqId() {
		return mcqId;
	}

	public void setMcqId(Long mcqId) {
		this.mcqId = mcqId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionImg() {
		return questionImg;
	}

	public void setQuestionImg(String questionImg) {
		this.questionImg = questionImg;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public QuestionOptionsDTO[] getOptionList() {
		return optionList;
	}

	public void setOptionList(QuestionOptionsDTO[] optionList) {
		this.optionList = optionList;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(Integer answerStatus) {
		this.answerStatus = answerStatus;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Boolean getIsMultiChoice() {
		return isMultiChoice;
	}

	public void setIsMultiChoice(Boolean isMultiChoice) {
		this.isMultiChoice = isMultiChoice;
	}

	public String getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(String selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	@Override
	public String toString() {
		return "TestSummaryQuestionDTO [mcqId=" + mcqId + ", question=" + question + ", questionDesc=" + questionDesc
				+ ", questionImg=" + questionImg + ", optionList=" + Arrays.toString(optionList) + ", answer=" + answer
				+ ", answerStatus=" + answerStatus + ", solution=" + solution + ", timeTaken=" + timeTaken
				+ ", selectedOptions=" + selectedOptions + ", isMultiChoice=" + isMultiChoice + "]";
	}

}

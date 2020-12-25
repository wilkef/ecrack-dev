package com.wilkef.ecrack.setup.admin.dto;

import java.util.Arrays;

/**
 * The Class CreateMCQDTO.
 */
public class McqDTO {

	private Long mcqId;
	private Long lessonId;
	private String question;
	private String questionDesc;
	private String solution;
	private McqOptionsDTO[] questionOptionsJson;
	public String answer;
	public Integer difficultyLevel;

	public Long getMcqId() {
		return mcqId;
	}

	public void setMcqId(Long mcqId) {
		this.mcqId = mcqId;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
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

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public McqOptionsDTO[] getQuestionOptionsJson() {
		return questionOptionsJson;
	}

	public void setQuestionOptionsJson(McqOptionsDTO[] questionOptionsJson) {
		this.questionOptionsJson = questionOptionsJson;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	@Override
	public String toString() {
		return "McqDTO [lessonId=" + lessonId + ", question=" + question + ", questionDesc=" + questionDesc
				+ ", solution=" + solution + ", questionOptionsJson=" + Arrays.toString(questionOptionsJson)
				+ ", answer=" + answer + ", difficultyLevel=" + difficultyLevel + "]";
	}

}

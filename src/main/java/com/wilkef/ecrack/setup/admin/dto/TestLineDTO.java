package com.wilkef.ecrack.setup.admin.dto;

public class TestLineDTO {
	private Long testLineId;
	private String questionSet;
	private Integer subjectId;
	private Integer noOfQuestion;
	private Boolean isSelected;

	public Long getTestLineId() {
		return testLineId;
	}

	public void setTestLineId(Long testLineId) {
		this.testLineId = testLineId;
	}

	public String getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(String questionSet) {
		this.questionSet = questionSet;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}

	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {
		return "TestLineDTO [testLineId=" + testLineId + ", questionSet=" + questionSet + "]";
	}

}

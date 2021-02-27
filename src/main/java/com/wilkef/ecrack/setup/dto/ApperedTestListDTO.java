package com.wilkef.ecrack.setup.dto;

public class ApperedTestListDTO {

	private String uniqueId;
	private String creationDate;
	private String subjectName;
	private Integer totalQuestion;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(Integer totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	@Override
	public String toString() {
		return "ApperedTestListDTO [uniqueId=" + uniqueId + ", creationDate=" + creationDate + ", subjectName="
				+ subjectName + ", totalQuestion=" + totalQuestion + "]";
	}

}

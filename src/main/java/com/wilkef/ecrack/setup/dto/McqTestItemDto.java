package com.wilkef.ecrack.setup.dto;

public class McqTestItemDto {
	private Integer mcqId;
	private Integer timeTaken;
	private String selectedAnswers;
	private Boolean isAttempted;

	public Integer getMcqId() {
		return mcqId;
	}

	public void setMcqId(Integer mcqId) {
		this.mcqId = mcqId;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getSelectedAnswers() {
		return selectedAnswers;
	}

	public void setSelectedAnswers(String selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}

	public Boolean getIsAttempted() {
		return isAttempted;
	}

	public void setIsAttempted(Boolean isAttempted) {
		this.isAttempted = isAttempted;
	}

	@Override
	public String toString() {
		return "McqTestItemDto [mcqId=" + mcqId + ", timeTaken=" + timeTaken + ", selectedAnswers=" + selectedAnswers
				+ ", isAttempted=" + isAttempted + "]";
	}

}

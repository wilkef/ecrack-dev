package com.wilkef.ecrack.setup.dto;

/**
 * This Class is used QuestionLevel DTO Class
 * 
 * @author Satya
 * Sep 16, 2020
 */

public class QuestionLevelDataDTO {
	
	private Integer difficultyId;
	private String difficultyCode;
	
	public Integer getDifficultyId() {
		return difficultyId;
	}
	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}
	public String getDifficultyCode() {
		return difficultyCode;
	}
	public void setDifficultyCode(String difficultyCode) {
		this.difficultyCode = difficultyCode;
	}
	
	@Override
	public String toString() {
		return "QuestionLevelDataDTO [difficultyId=" + difficultyId + ", difficultyCode=" + difficultyCode + "]";
	}
}

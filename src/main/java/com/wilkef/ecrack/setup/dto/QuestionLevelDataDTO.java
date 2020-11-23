package com.wilkef.ecrack.setup.dto;

/**
 * This Class is used QuestionLevel DTO Class.
 *
 * @author Satya Sep 16, 2020
 */

public class QuestionLevelDataDTO {

	/** The difficulty id. */
	private Integer difficultyId;

	/** The difficulty code. */
	private String difficultyCode;

	/**
	 * Gets the difficulty id.
	 *
	 * @return the difficulty id
	 */
	public Integer getDifficultyId() {
		return difficultyId;
	}

	/**
	 * Sets the difficulty id.
	 *
	 * @param difficultyId the new difficulty id
	 */
	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}

	/**
	 * Gets the difficulty code.
	 *
	 * @return the difficulty code
	 */
	public String getDifficultyCode() {
		return difficultyCode;
	}

	/**
	 * Sets the difficulty code.
	 *
	 * @param difficultyCode the new difficulty code
	 */
	public void setDifficultyCode(String difficultyCode) {
		this.difficultyCode = difficultyCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "QuestionLevelDataDTO [difficultyId=" + difficultyId + ", difficultyCode=" + difficultyCode + "]";
	}
}

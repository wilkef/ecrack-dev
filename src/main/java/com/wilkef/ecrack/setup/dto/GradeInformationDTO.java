/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Chinmaya.dehury
 *
 *         29-Sep-2020
 *
 */
public class GradeInformationDTO {
	private int gradeId;
	private String gradeName;
	private int gradeCode;
	private int boardId;

	/**
	 * @return the gradeId
	 */
	public int getGradeId() {
		return gradeId;
	}

	/**
	 * @param gradeId the gradeId to set
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	/**
	 * @return the gradeName
	 */
	public String getGradeName() {
		return gradeName;
	}

	/**
	 * @param gradeName the gradeName to set
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	/**
	 * @return the gradeCode
	 */
	public int getGradeCode() {
		return gradeCode;
	}

	/**
	 * @param gradeCode the gradeCode to set
	 */
	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	/**
	 * @return the boardId
	 */
	public int getBoardId() {
		return boardId;
	}

	/**
	 * @param boardId the boardId to set
	 */
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "GradeInformationDTO [gradeId=" + gradeId + ", gradeName=" + gradeName + ", gradeCode=" + gradeCode
				+ ", boardId=" + boardId + "]";
	}

}

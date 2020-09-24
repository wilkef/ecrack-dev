package com.wilkef.ecrack.setup.dto;


/**
 * This Class is used Subject DTO Class.
 *
 * @author Satya
 * Sep 16, 2020
 */

public class SubjectDataDTO {
	
	/** The subject id. */
	private Integer subjectId;
	
	/** The subject name. */
	private String subjectName;
	
	/** The subject code. */
	private String subjectCode;
	
	/** The max mark. */
	private Integer maxMark;
	
	/** The no of period. */
	private Integer noOfPeriod;
	
	/** The grade name. */
	private String gradeName;
	
	/**
	 * Gets the subject id.
	 *
	 * @return the subject id
	 */
	public Integer getSubjectId() {
		return subjectId;
	}
	
	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the new subject id
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	/**
	 * Gets the subject name.
	 *
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}
	
	/**
	 * Sets the subject name.
	 *
	 * @param subjectName the new subject name
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	/**
	 * Gets the subject code.
	 *
	 * @return the subject code
	 */
	public String getSubjectCode() {
		return subjectCode;
	}
	
	/**
	 * Sets the subject code.
	 *
	 * @param subjectCode the new subject code
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	/**
	 * Gets the max mark.
	 *
	 * @return the max mark
	 */
	public Integer getMaxMark() {
		return maxMark;
	}
	
	/**
	 * Sets the max mark.
	 *
	 * @param maxMark the new max mark
	 */
	public void setMaxMark(Integer maxMark) {
		this.maxMark = maxMark;
	}
	
	/**
	 * Gets the no of period.
	 *
	 * @return the no of period
	 */
	public Integer getNoOfPeriod() {
		return noOfPeriod;
	}
	
	/**
	 * Sets the no of period.
	 *
	 * @param noOfPeriod the new no of period
	 */
	public void setNoOfPeriod(Integer noOfPeriod) {
		this.noOfPeriod = noOfPeriod;
	}
	
	/**
	 * Gets the grade name.
	 *
	 * @return the grade name
	 */
	public String getGradeName() {
		return gradeName;
	}
	
	/**
	 * Sets the grade name.
	 *
	 * @param gradeName the new grade name
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SubjectDataDTO [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode="
				+ subjectCode + ", maxMark=" + maxMark + ", noOfPeriod=" + noOfPeriod + ", gradeName=" + gradeName
				+ "]";
	}
		
}

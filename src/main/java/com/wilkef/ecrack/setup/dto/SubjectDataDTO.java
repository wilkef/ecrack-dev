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
	
	private String thumbNail;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Integer getMaxMark() {
		return maxMark;
	}

	public void setMaxMark(Integer maxMark) {
		this.maxMark = maxMark;
	}

	public Integer getNoOfPeriod() {
		return noOfPeriod;
	}

	public void setNoOfPeriod(Integer noOfPeriod) {
		this.noOfPeriod = noOfPeriod;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	@Override
	public String toString() {
		return "SubjectDataDTO [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode="
				+ subjectCode + ", maxMark=" + maxMark + ", noOfPeriod=" + noOfPeriod + ", gradeName=" + gradeName
				+ ", thumbNail=" + thumbNail + "]";
	}
		
}

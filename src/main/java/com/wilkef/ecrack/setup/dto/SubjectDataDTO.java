package com.wilkef.ecrack.setup.dto;

/**
 * This Class is used Subject DTO Class
 * 
 * @author Satya
 * Sep 16, 2020
 */

public class SubjectDataDTO {
	private Integer subjectId;
	private String subjectName;
	private String subjectCode;
	private Integer maxMark;
	private Integer noOfPeriod;
	private String gradeName;
	
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
	
	@Override
	public String toString() {
		return "SubjectDataDTO [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode="
				+ subjectCode + ", maxMark=" + maxMark + ", noOfPeriod=" + noOfPeriod + ", gradeName=" + gradeName
				+ "]";
	}
		
}

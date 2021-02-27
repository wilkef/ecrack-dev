package com.wilkef.ecrack.setup.admin.dto;

public class ManageSubjectDTO {
	private Integer subjectId;
	private Integer subjectName;
	private Integer subjectCode;
	private Boolean isActive;
	private Integer gradeName;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(Integer subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(Integer subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getGradeName() {
		return gradeName;
	}

	public void setGradeName(Integer gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "ManageSubjectDTO [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode="
				+ subjectCode + ", isActive=" + isActive + ", gradeName=" + gradeName + "]";
	}

}

package com.wilkef.ecrack.setup.admin.dto;

public class ManageUnitDTO {
	private Integer unitId;
	private String unitName;
	private Integer maxMark;
	private Integer noOfPeriod;
	private Boolean isActive;
	private String subjectName;

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "ManageUnitDTO [unitId=" + unitId + ", unitName=" + unitName + ", maxMark=" + maxMark + ", noOfPeriod="
				+ noOfPeriod + ", isActive=" + isActive + ", subjectName=" + subjectName + "]";
	}

}

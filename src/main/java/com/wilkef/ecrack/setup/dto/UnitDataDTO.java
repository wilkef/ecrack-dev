package com.wilkef.ecrack.setup.dto;

public class UnitDataDTO {

	private Integer unitId;
	private String unitName;
	private Integer subjectId;

	/**
	 * @return the unitId
	 */
	public Integer getUnitId() {
		return unitId;
	}

	@Override
	public String toString() {
		return "UnitDataDTO [unitId=" + unitId + ", unitName=" + unitName + ", subjectId=" + subjectId + "]";
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the subjectId
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

}

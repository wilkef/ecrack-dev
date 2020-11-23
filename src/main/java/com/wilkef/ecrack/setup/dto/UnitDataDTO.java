package com.wilkef.ecrack.setup.dto;

/**
 * The Class UnitDataDTO.
 */
public class UnitDataDTO {

	/** The unit id. */
	private Integer unitId;

	/** The unit name. */
	private String unitName;

	/** The subject id. */
	private Integer subjectId;

	/**
	 * Gets the unit id.
	 *
	 * @return the unitId
	 */
	public Integer getUnitId() {
		return unitId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UnitDataDTO [unitId=" + unitId + ", unitName=" + unitName + ", subjectId=" + subjectId + "]";
	}

	/**
	 * Sets the unit id.
	 *
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	/**
	 * Gets the unit name.
	 *
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * Sets the unit name.
	 *
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * Gets the subject id.
	 *
	 * @return the subjectId
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

}

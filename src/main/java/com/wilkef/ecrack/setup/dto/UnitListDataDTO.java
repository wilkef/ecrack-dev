/**
 * 
 */
package com.wilkef.ecrack.setup.dto;


/**
 * The Class UnitListDataDTO.
 *
 * @author Satya
 * Sep 18, 2020
 */


public class UnitListDataDTO {
	
	/** The unit id. */
	private Integer unitId;
	
	/** The unit name. */
	private String unitName;
	
	/** The subject id. */
	private Integer subjectId;
	
	/** The subject name. */
	private String subjectName;
	
	/** The unit serial. */
	private Integer unitSerial;
	
	/** The max mark. */
	private Integer maxMark;
    
    /** The no of period. */
    private Integer noOfPeriod;
    
	/**
	 * Gets the unit id.
	 *
	 * @return the unit id
	 */
	public Integer getUnitId() {
		return unitId;
	}
	
	/**
	 * Sets the unit id.
	 *
	 * @param unitId the new unit id
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
	/**
	 * Gets the unit name.
	 *
	 * @return the unit name
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * Sets the unit name.
	 *
	 * @param unitName the new unit name
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
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
	 * Gets the unit serial.
	 *
	 * @return the unit serial
	 */
	public Integer getUnitSerial() {
		return unitSerial;
	}
	
	/**
	 * Sets the unit serial.
	 *
	 * @param unitSerial the new unit serial
	 */
	public void setUnitSerial(Integer unitSerial) {
		this.unitSerial = unitSerial;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UnitListDataDTO [unitId=" + unitId + ", unitName=" + unitName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", unitSerial=" + unitSerial + ", maxMark=" + maxMark
				+ ", noOfPeriod=" + noOfPeriod + "]";
	}
}

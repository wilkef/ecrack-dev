/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 *Sep 18, 2020
 */


public class UnitListDataDTO {
	
	private Integer unitId;
	private String unitName;
	private Integer subjectId;
	private String subjectName;
	private Integer unitSerial;
	private Integer maxMark;
    private Integer noOfPeriod;
    
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
	public Integer getUnitSerial() {
		return unitSerial;
	}
	public void setUnitSerial(Integer unitSerial) {
		this.unitSerial = unitSerial;
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
	@Override
	public String toString() {
		return "UnitListDataDTO [unitId=" + unitId + ", unitName=" + unitName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", unitSerial=" + unitSerial + ", maxMark=" + maxMark
				+ ", noOfPeriod=" + noOfPeriod + "]";
	}
}

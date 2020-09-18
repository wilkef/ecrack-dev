/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 *  This Class is Used to execute Lession DTO Class
 * 
 * @author Satya
 *Sep 18, 2020
 */

public class LessionListDataDTO {
	
	private Integer lessonId;
	private String unitName;
    private String lessonName;
    private Integer lessonSerial;
    private Integer lessonMark;
    private Integer noOfPeriod;
    private Integer noOfQuestion;
    private String videoId;
    private String videoUrl;
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public Integer getLessonSerial() {
		return lessonSerial;
	}
	public void setLessonSerial(Integer lessonSerial) {
		this.lessonSerial = lessonSerial;
	}
	public Integer getLessonMark() {
		return lessonMark;
	}
	public void setLessonMark(Integer lessonMark) {
		this.lessonMark = lessonMark;
	}
	public Integer getNoOfPeriod() {
		return noOfPeriod;
	}
	public void setNoOfPeriod(Integer noOfPeriod) {
		this.noOfPeriod = noOfPeriod;
	}
	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}
	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	@Override
	public String toString() {
		return "LessionListDataDTO [lessonId=" + lessonId + ", unitName=" + unitName + ", lessonName=" + lessonName
				+ ", lessonSerial=" + lessonSerial + ", lessonMark=" + lessonMark + ", noOfPeriod=" + noOfPeriod
				+ ", noOfQuestion=" + noOfQuestion + ", videoId=" + videoId + ", videoUrl=" + videoUrl + "]";
	}
	
	
}

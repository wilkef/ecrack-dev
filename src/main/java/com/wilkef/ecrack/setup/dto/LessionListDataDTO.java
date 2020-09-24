/**
 * 
 */
package com.wilkef.ecrack.setup.dto;


/**
 *  This Class is Used to execute Lession DTO Class.
 *
 * @author Satya
 * Sep 18, 2020
 */

public class LessionListDataDTO {
	
	/** The lesson id. */
	private Integer lessonId;
	
	/** The unit name. */
	private String unitName;
    
    /** The lesson name. */
    private String lessonName;
    
    /** The lesson serial. */
    private Integer lessonSerial;
    
    /** The lesson mark. */
    private Integer lessonMark;
    
    /** The no of period. */
    private Integer noOfPeriod;
    
    /** The no of question. */
    private Integer noOfQuestion;
    
    /** The video id. */
    private String videoId;
    
    /** The video url. */
    private String videoUrl;
	
	/**
	 * Gets the lesson id.
	 *
	 * @return the lesson id
	 */
	public Integer getLessonId() {
		return lessonId;
	}
	
	/**
	 * Sets the lesson id.
	 *
	 * @param lessonId the new lesson id
	 */
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
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
	 * Gets the lesson name.
	 *
	 * @return the lesson name
	 */
	public String getLessonName() {
		return lessonName;
	}
	
	/**
	 * Sets the lesson name.
	 *
	 * @param lessonName the new lesson name
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	/**
	 * Gets the lesson serial.
	 *
	 * @return the lesson serial
	 */
	public Integer getLessonSerial() {
		return lessonSerial;
	}
	
	/**
	 * Sets the lesson serial.
	 *
	 * @param lessonSerial the new lesson serial
	 */
	public void setLessonSerial(Integer lessonSerial) {
		this.lessonSerial = lessonSerial;
	}
	
	/**
	 * Gets the lesson mark.
	 *
	 * @return the lesson mark
	 */
	public Integer getLessonMark() {
		return lessonMark;
	}
	
	/**
	 * Sets the lesson mark.
	 *
	 * @param lessonMark the new lesson mark
	 */
	public void setLessonMark(Integer lessonMark) {
		this.lessonMark = lessonMark;
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
	 * Gets the no of question.
	 *
	 * @return the no of question
	 */
	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}
	
	/**
	 * Sets the no of question.
	 *
	 * @param noOfQuestion the new no of question
	 */
	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	
	/**
	 * Gets the video id.
	 *
	 * @return the video id
	 */
	public String getVideoId() {
		return videoId;
	}
	
	/**
	 * Sets the video id.
	 *
	 * @param videoId the new video id
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	/**
	 * Gets the video url.
	 *
	 * @return the video url
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	
	/**
	 * Sets the video url.
	 *
	 * @param videoUrl the new video url
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LessionListDataDTO [lessonId=" + lessonId + ", unitName=" + unitName + ", lessonName=" + lessonName
				+ ", lessonSerial=" + lessonSerial + ", lessonMark=" + lessonMark + ", noOfPeriod=" + noOfPeriod
				+ ", noOfQuestion=" + noOfQuestion + ", videoId=" + videoId + ", videoUrl=" + videoUrl + "]";
	}
	
	
}

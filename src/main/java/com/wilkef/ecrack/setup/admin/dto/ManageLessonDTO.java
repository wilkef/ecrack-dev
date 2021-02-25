package com.wilkef.ecrack.setup.admin.dto;

public class ManageLessonDTO {
	private Integer lessonId;
	private String lessonName;
	private String videoUrl;
	private Integer lessonMark;
	private Integer noOfPeriod;
	private Integer noOfQuestion;
	public Boolean isActive;
	public String unitName;

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public String toString() {
		return "ManageLessonDTO [lessonId=" + lessonId + ", lessonName=" + lessonName + ", videoUrl=" + videoUrl
				+ ", lessonMark=" + lessonMark + ", noOfPeriod=" + noOfPeriod + ", noOfQuestion=" + noOfQuestion
				+ ", isActive=" + isActive + ", unitName=" + unitName + "]";
	}

}

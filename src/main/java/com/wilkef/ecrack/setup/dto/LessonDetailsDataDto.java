/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 * Nov 2, 2020
 */

public class LessonDetailsDataDto {
	private String subjectName;
	private String unitName;
	private String lessonName;
	private String videoUrl;
	private String lessonThumbnail;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getLessonThumbnail() {
		return lessonThumbnail;
	}
	public void setLessonThumbnail(String lessonThumbnail) {
		this.lessonThumbnail = lessonThumbnail;
	}
	
	@Override
	public String toString() {
		return "LessonDetailsDataDto [subjectName=" + subjectName + ", unitName=" + unitName + ", lessonName="
				+ lessonName + ", videoUrl=" + videoUrl + ", lessonThumbnail=" + lessonThumbnail + "]";
	}
}

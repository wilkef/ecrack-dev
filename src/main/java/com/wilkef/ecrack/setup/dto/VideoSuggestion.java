/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya Nov 1, 2020
 */

public class VideoSuggestion {
	private Integer lessonId;
	private String lessonName;
	private String lessonUrl;
	private String lessonThumbnail;
	private String lessonThumbnail_Mob;

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

	public String getLessonUrl() {
		return lessonUrl;
	}

	public void setLessonUrl(String lessonUrl) {
		this.lessonUrl = lessonUrl;
	}

	public String getLessonThumbnail() {
		return lessonThumbnail;
	}

	public void setLessonThumbnail(String lessonThumbnail) {
		this.lessonThumbnail = lessonThumbnail;
	}

	public String getLessonThumbnail_Mob() {
		return lessonThumbnail_Mob;
	}

	public void setLessonThumbnail_Mob(String lessonThumbnail_Mob) {
		this.lessonThumbnail_Mob = lessonThumbnail_Mob;
	}

	@Override
	public String toString() {
		return "VideoSuggestion [lessonId=" + lessonId + ", lessonName=" + lessonName + ", lessonUrl=" + lessonUrl
				+ ", lessonThumbnail=" + lessonThumbnail + ", lessonThumbnail_Mob=" + lessonThumbnail_Mob + "]";
	}
}

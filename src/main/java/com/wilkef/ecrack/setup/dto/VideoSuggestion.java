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
	private String videoId;
	private String lessonThumbnail;
	private String lessonThumbnailMob;

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

	@Override
	public String toString() {
		return "VideoSuggestion [lessonId=" + lessonId + ", lessonName=" + lessonName + ", lessonUrl=" + lessonUrl
				+ ", videoId=" + videoId + ", lessonThumbnail=" + lessonThumbnail + ", lessonThumbnailMob="
				+ lessonThumbnailMob + "]";
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

	/**
	 * @return the videoId
	 */
	public String getVideoId() {
		return videoId;
	}

	/**
	 * @param videoId the videoId to set
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	/**
	 * @return the lessonThumbnailMob
	 */
	public String getLessonThumbnailMob() {
		return lessonThumbnailMob;
	}

	/**
	 * @param lessonThumbnailMob the lessonThumbnailMob to set
	 */
	public void setLessonThumbnailMob(String lessonThumbnailMob) {
		this.lessonThumbnailMob = lessonThumbnailMob;
	}
}

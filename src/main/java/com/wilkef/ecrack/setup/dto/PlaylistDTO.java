/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Chinmaya.dehury
 *
 *         16-Jan-2021
 *
 */
public class PlaylistDTO {
	private String lessonName;
	private String videoId;
	private String subjectName;
	private String thumbnail;
	private String thumbnailMobile;
	private String unitName;

	/**
	 * @return the lessonName
	 */
	public String getLessonName() {
		return lessonName;
	}

	@Override
	public String toString() {
		return "PlaylistDTO [lessonName=" + lessonName + ", videoId=" + videoId + ", subjectName=" + subjectName
				+ ", thumbnail=" + thumbnail + ", thumbnailMobile=" + thumbnailMobile + ", unitName=" + unitName + "]";
	}

	/**
	 * @param lessonName the lessonName to set
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
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
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the thumbnailMobile
	 */
	public String getThumbnailMobile() {
		return thumbnailMobile;
	}

	/**
	 * @param thumbnailMobile the thumbnailMobile to set
	 */
	public void setThumbnailMobile(String thumbnailMobile) {
		this.thumbnailMobile = thumbnailMobile;
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

}

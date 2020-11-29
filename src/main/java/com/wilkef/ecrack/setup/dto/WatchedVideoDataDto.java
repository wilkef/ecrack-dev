/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

import java.util.Date;

/**
 * @author Satya Oct 31, 2020
 */

public class WatchedVideoDataDto {
	private long watchedVideoId;
	private Integer userId;
	private Integer lessonId;
	private Date startDateTime;
	private Date endDateTime;
	private Integer timeWatched;
	private Integer watchCount;
	private Boolean isFinished;
	private String mobileNo;
	private String lessonName;
	private String lessonThumbnail;
	private Integer unitId;
	private String videoUrl;

	private String videoId;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getWatchedVideoId() {
		return watchedVideoId;
	}

	public void setWatchedVideoId(long watchedVideoId) {
		this.watchedVideoId = watchedVideoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonThumbnail() {
		return lessonThumbnail;
	}

	public void setLessonThumbnail(String lessonThumbnail) {
		this.lessonThumbnail = lessonThumbnail;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Integer getTimeWatched() {
		return timeWatched;
	}

	public void setTimeWatched(Integer timeWatched) {
		this.timeWatched = timeWatched;
	}

	public Integer getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(Integer watchCount) {
		this.watchCount = watchCount;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	@Override
	public String toString() {
		return "WatchedVideoDataDto [watchedVideoId=" + watchedVideoId + ", userId=" + userId + ", lessonId=" + lessonId
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", timeWatched=" + timeWatched
				+ ", mobileNo=" + mobileNo + ", lessonThumbnail=" + lessonThumbnail + ", watchCount=" + watchCount + ", isFinished=" + isFinished + "]";
	}

}

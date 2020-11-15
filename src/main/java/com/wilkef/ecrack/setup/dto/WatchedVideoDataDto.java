/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

import java.util.Date;

/**
 * @author Satya
 * Oct 31, 2020
 */

public class WatchedVideoDataDto {
	private Integer watchedVideoId;
	private String userId;
	private String lessonId;
	private Date startDateTime;
	private Date endDateTime;
	private Integer timeWatched;
	private String mobileNo;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Integer getWatchedVideoId() {
		return watchedVideoId;
	}
	public void setWatchedVideoId(Integer watchedVideoId) {
		this.watchedVideoId = watchedVideoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLessonId() {
		return lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
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
	@Override
	public String toString() {
		return "WatchedVideoDataDto [watchedVideoId=" + watchedVideoId + ", userId=" + userId + ", lessonId=" + lessonId
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", timeWatched=" + timeWatched
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
}

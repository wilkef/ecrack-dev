package com.wilkef.ecrack.setup.dto;

public class FavoriteVideoDTO {
	private long favoriteVideoId;
	private Integer userId;
	private Integer lessonId;
	private String lessonName;
	private String lessonThumbnail;
	private String videoUrl;
	
	public long getFavoriteVideoId() {
		return favoriteVideoId;
	}
	public void setFavoriteVideoId(long favoriteVideoId) {
		this.favoriteVideoId = favoriteVideoId;
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
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getLessonThumbnail() {
		return lessonThumbnail;
	}
	public void setLessonThumbnail(String lessonThumbnail) {
		this.lessonThumbnail = lessonThumbnail;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}	
	
	
}

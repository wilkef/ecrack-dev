/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;

/**
 * @author Satya Oct 31, 2020
 */
@Repository
public class WatchedVideoDaoImpl implements WatchedVideoDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(WatchedVideoDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	List<WatchedVideoDataDto> list;

	@Override
	public Integer saveWatchedVideo(WatchedVideoDataDto watchedVideo) {
		list = new ArrayList<>();
		int res = 0;
		String userId = appJdbcTemplate.queryForObject("Select userid from User where MobileNumber = ?",
				new Object[] { watchedVideo.getMobileNo() }, String.class);

		String userIdinWatchedVdo = appJdbcTemplate.queryForObject(
				"Select userid from WatchedVideo where WatchedVideoId = ? and userId =? ",
				new Object[] { watchedVideo.getWatchedVideoId(), userId }, String.class);

		if (!userIdinWatchedVdo.isEmpty()) {
			String updateSql = "update WatchedVideo set LessonId =? ,StartDateTime =?  ,EndDateTime =? , TimeWatched = TimeWatched+1 where WatchedVideoId=? and UserId= ?";
			res = appJdbcTemplate.update(updateSql, watchedVideo.getLessonId(), watchedVideo.getStartDateTime(),
					watchedVideo.getEndDateTime(), watchedVideo.getWatchedVideoId(), userId);
		} else {
			String sql = "INSERT INTO WatchedVideo (UserId, LessonId, StartDateTime,EndDateTime,TimeWatched) VALUES (?,?, ?, ?, ?, ?)";

			res = appJdbcTemplate.update(sql, watchedVideo.getWatchedVideoId(), userId, watchedVideo.getLessonId(),
					watchedVideo.getStartDateTime(), watchedVideo.getEndDateTime(), 1);
		}
		return res;
	}

	@Override
	public List<WatchedVideoDataDto> mostWatchedVideo(Integer userId) {
		LOG.log(Level.INFO, "Start mostWatchedVideo");
		String query = WilkefConstants.MOST_WATCHED_VIDEOS;
		List<WatchedVideoDataDto> mostWatchedVideoList = new ArrayList<>();
		try {
			mostWatchedVideoList = appJdbcTemplate.query(query, new Object[] { userId }, (result, rowNum) -> {
				WatchedVideoDataDto videoDto = new WatchedVideoDataDto();
				videoDto.setWatchedVideoId(result.getInt("WatchedVideoId"));
				videoDto.setUserId(result.getString("UserId"));
				videoDto.setLessonId(result.getInt("LessonId"));
				videoDto.setStartDateTime(result.getDate("StartDateTime"));
				videoDto.setEndDateTime(result.getDate("EndDateTime"));
				videoDto.setLessonId(result.getInt("LessonId"));
				videoDto.setLessonName(result.getString("LessonName"));
				videoDto.setLessonThumbnail(result.getString("LessonThumbnail"));
				return videoDto;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for mostWatchedVideo");
		}
		LOG.log(Level.INFO, "End mostWatchedVideo");
		return mostWatchedVideoList;
	}

	@Override
	public List<WatchedVideoDataDto> videoSuggestion(Integer userId) {
		LOG.log(Level.INFO, "Started videoSuggestion");
		String query = WilkefConstants.SUGGESTED_VIDEOS;
		List<WatchedVideoDataDto> suggestedVideoList = new ArrayList<>();
		try {
			suggestedVideoList = appJdbcTemplate.query(query, new Object[] { userId }, (result, rowNum) -> {
				WatchedVideoDataDto videoDto = new WatchedVideoDataDto();
				videoDto.setVideoId(result.getString("VideoId"));
				videoDto.setLessonId(result.getInt("LessonId"));
				videoDto.setLessonName(result.getString("LessonName"));
				videoDto.setLessonThumbnail(result.getString("LessonThumbnail"));
				videoDto.setUnitId(result.getInt("UnitId"));
				videoDto.setVideoUrl(result.getString("VideoUrl"));
				return videoDto;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for unit list");
		}
		LOG.log(Level.INFO, "Ended videoSuggestion");
		return suggestedVideoList;
	}

}

/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
import com.wilkef.ecrack.setup.dto.GradeInformationDTO;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;
import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;

/**
 * @author Satya
 * Oct 31, 2020
 */
@Repository
public class WatchedVideoDaoImpl implements WatchedVideoDao{
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(WatchedVideoDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Integer saveWatchedVideo(WatchedVideoDataDto watchedVideo) {
		List<WatchedVideoDataDto> list=new  ArrayList<>();
		int res=0;
		String userId = (String) appJdbcTemplate.queryForObject(
				"Select userid from User where MobileNumber = ?", new Object[] { watchedVideo.getMobileNo() }, String.class);
	
			String userIdinWatchedVdo = (String) appJdbcTemplate.queryForObject(
					"Select userid from WatchedVideo where WatchedVideoId = ? and userId =? ", new Object[] { watchedVideo.getWatchedVideoId() ,userId }, String.class);


			if(null!=userIdinWatchedVdo && !userIdinWatchedVdo.isEmpty()) {
				String updateSql="update WatchedVideo set LessonId =? ,StartDateTime =?  ,EndDateTime =? , TimeWatched = TimeWatched+1 where WatchedVideoId=? and UserId= ?";
				res=appJdbcTemplate.update(updateSql,watchedVideo.getLessonId(),watchedVideo.getStartDateTime(),watchedVideo.getEndDateTime(),watchedVideo.getWatchedVideoId(),userId);
			}
		else {
			String sql="INSERT INTO WatchedVideo (UserId, LessonId, StartDateTime,EndDateTime,TimeWatched) VALUES (?,?, ?, ?, ?, ?)";
			//String sql="insert into WatchedVideo values(?,?,?,?,?)";
			res=appJdbcTemplate.update(sql,watchedVideo.getWatchedVideoId(),userId,watchedVideo.getLessonId(),watchedVideo.getStartDateTime(),watchedVideo.getEndDateTime(),1);
		}
		return res;
	}

	@Override
	public List<WatchedVideoDataDto> mostWatchedVideo(WatchedVideoDataDto watchedVideo) {
		String query="SELECT UserId,LessonId,StartDateTime,EndDateTime FROM ecrack.WatchedVideo where UserId=? group by WatchedVideoId  order by TimeWatched desc limit 5";
		List<WatchedVideoDataDto> list=new  ArrayList<>();
		try {
		list = appJdbcTemplate.query(query, new Object[] { watchedVideo.getUserId() },
				(result, rowNum) -> {
					WatchedVideoDataDto videoDto = new WatchedVideoDataDto();
					videoDto.setUserId(result.getString("UserId"));
					videoDto.setLessonId(result.getInt("LessonId"));
					videoDto.setStartDateTime(result.getDate("StartDateTime"));
					videoDto.setEndDateTime(result.getDate("EndDateTime"));
					return videoDto;
				});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for unit list");
		}
		return list;
	}
	
	@Override
	public List<WatchedVideoDataDto> videoSuggestion(WatchedVideoDataDto watchedVideo) {
		String query="Select LessonId,LessonName,UnitId,VideoUrl from  ecrack.Lesson where IsActive=1 and VideoId not in(Select WatchedVideoId from WatchedVideo where UserId = ?)";
		List<WatchedVideoDataDto> list=new  ArrayList<>();
		try {
		list = appJdbcTemplate.query(query, new Object[] { watchedVideo.getUserId() },
				(result, rowNum) -> {
					WatchedVideoDataDto videoDto = new WatchedVideoDataDto();
					videoDto.setLessonId(result.getInt("LessonId"));
					videoDto.setLessonName(result.getString("LessonName"));
					videoDto.setUnitId(result.getInt("UnitId"));
					videoDto.setVideoUrl(result.getString("VideoUrl"));
					return videoDto;
				});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for unit list");
		}
		return list;
	}
	
}

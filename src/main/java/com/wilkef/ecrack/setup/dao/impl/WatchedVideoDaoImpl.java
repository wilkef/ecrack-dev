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
import com.wilkef.ecrack.setup.dto.GradeInformationDTO;
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
		if(null!=watchedVideo.getWatchedVideoId()) {
			String userIdinWatchedVdo = (String) appJdbcTemplate.queryForObject(
					"Select userid from WatchedVideo where WatchedVideoId = ?", new Object[] { watchedVideo.getWatchedVideoId() }, String.class);


			if(null!=userIdinWatchedVdo) {
				String updateSql="update WatchedVideo set UserId =? ,LessonId =? ,StartDateTime =?  ,EndDateTime =? , TimeWatched = TimeWatched+1 where WatchedVideoId=?";
				res=appJdbcTemplate.update(updateSql,userId,watchedVideo.getLessonId(),watchedVideo.getStartDateTime(),watchedVideo.getEndDateTime(),watchedVideo.getWatchedVideoId());
			}}
		else {
			String sql="INSERT INTO WatchedVideo (UserId, LessonId, StartDateTime,EndDateTime,TimeWatched) VALUES (?, ?, ?, ?, ?)";
			//String sql="insert into WatchedVideo values(?,?,?,?,?)";
			res=appJdbcTemplate.update(sql,userId,watchedVideo.getLessonId(),watchedVideo.getStartDateTime(),watchedVideo.getEndDateTime(),1);
		}
		return res;
	}
}

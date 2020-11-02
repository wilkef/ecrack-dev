/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
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
		String sql="insert into WatchedVideo values(?,?,?,?,?,?)";
		return appJdbcTemplate.update(sql,watchedVideo.getWatchedVideoId(),watchedVideo.getUserId(),watchedVideo.getLessonId(),watchedVideo.getStartDateTime(),watchedVideo.getEndDateTime(),watchedVideo.getTimeWatched());
	}
}

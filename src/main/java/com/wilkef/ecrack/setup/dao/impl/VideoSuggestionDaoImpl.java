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
import com.wilkef.ecrack.setup.dao.VideoSuggestionDao;
import com.wilkef.ecrack.setup.dto.VideoSuggestion;

/**
 * @author Satya Nov 1, 2020
 */

@Repository
public class VideoSuggestionDaoImpl implements VideoSuggestionDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(VideoSuggestionDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<VideoSuggestion> videoSuggestion() {

		List<VideoSuggestion> videoSuggestionList = new ArrayList<>();
		RowMapper<VideoSuggestion> rowMapper = (ResultSet result, int rowNum) -> {
			VideoSuggestion videoSuggestion = new VideoSuggestion();
			videoSuggestion.setLessonId(result.getInt(1));
			videoSuggestion.setLessonName(result.getString(2));
			videoSuggestion.setLessonThumbnail(result.getString(3));
			videoSuggestion.setLessonUrl(result.getString(4));
			videoSuggestion.setLessonThumbnailMob(result.getString(5));
			videoSuggestion.setVideoId(result.getString(6));
			return videoSuggestion;
		};
		try {
			videoSuggestionList = appJdbcTemplate.query(WilkefConstants.VIDEO_SUGGESTION, rowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, "Error while fetching records for VideoSuggestion");
		}
		return videoSuggestionList;
	}

}

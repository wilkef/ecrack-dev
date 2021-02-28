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
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;

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
	public List<LessionListDataDTO> videoSuggestion() {

		List<LessionListDataDTO> videoSuggestionList = new ArrayList<>();
		RowMapper<LessionListDataDTO> rowMapper = (ResultSet result, int rowNum) -> {
			LessionListDataDTO videoSuggestion = new LessionListDataDTO();
			videoSuggestion.setLessonId(result.getInt(1));
			videoSuggestion.setLessonName(result.getString(2));
			videoSuggestion.setLessonSerial(result.getInt(3));
			videoSuggestion.setLessonMark(result.getInt(4));
			videoSuggestion.setNoOfPeriod(result.getInt(5));
			videoSuggestion.setNoOfQuestion(result.getInt(6));
			videoSuggestion.setVideoId(result.getString(7));
			videoSuggestion.setVideoUrl(result.getString(8));
			videoSuggestion.setThumbNail(result.getString(9));
			videoSuggestion.setThumbnailMob(result.getString(10));
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

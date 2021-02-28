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
import com.wilkef.ecrack.setup.dao.VideoPlaylistDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.dto.PlaylistDTO;

/**
 * @author Chinmaya.dehury
 *
 *         16-Jan-2021
 *
 */
@Repository
public class VideoPlaylistDaoImpl implements VideoPlaylistDao {

	public static final Logger LOG = Logger.getLogger(VideoPlaylistDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<LessionListDataDTO> fetchDBPlaylist(int gradeId) {
		List<LessionListDataDTO> playList = new ArrayList<>();

		RowMapper<LessionListDataDTO> rowMapper = (ResultSet result, int rowNum) -> {

			LessionListDataDTO videoSuggestion = new LessionListDataDTO();
			videoSuggestion.setLessonId(result.getInt(1));
			videoSuggestion.setLessonName(result.getString(2));
			videoSuggestion.setLessonSerial(result.getInt(3));
			videoSuggestion.setUnitName(result.getString(4));
			videoSuggestion.setLessonMark(result.getInt(5));
			videoSuggestion.setNoOfPeriod(result.getInt(6));
			videoSuggestion.setNoOfQuestion(result.getInt(7));
			videoSuggestion.setVideoId(result.getString(8));
			videoSuggestion.setVideoUrl(result.getString(9));
			videoSuggestion.setThumbNail(result.getString(10));
			videoSuggestion.setThumbnailMob(result.getString(11));
			return videoSuggestion;
		};

		try {
			playList = appJdbcTemplate.query(WilkefConstants.VIDEO_PLAY_LIST, new Object[] { gradeId }, rowMapper);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return playList;
	}

}

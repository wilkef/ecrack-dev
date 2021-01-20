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
	public List<PlaylistDTO> fetchDBPlaylist(int gradeId) {
		List<PlaylistDTO> playList = new ArrayList<>();

		RowMapper<PlaylistDTO> rowMapper = (ResultSet result, int rowNum) -> {
			PlaylistDTO video = new PlaylistDTO();
			video.setLessonName(result.getString(1));
			video.setVideoId(result.getString(2));
			video.setSubjectName(result.getString(3));
			video.setThumbnail(result.getString(4));
			video.setThumbnailMobile(result.getString(5));
			video.setUnitName(result.getString(6));
			return video;
		};

		try {
			playList = appJdbcTemplate.query(WilkefConstants.VIDEO_PLAY_LIST, new Object[] { gradeId }, rowMapper);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return playList;
	}

}

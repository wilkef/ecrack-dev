package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.FavoriteVideoDao;
import com.wilkef.ecrack.setup.dto.FavoriteVideoDTO;

@Repository
public class FavoriteVideoDaoImpl implements FavoriteVideoDao {

	public static final Logger LOG = Logger.getLogger(FavoriteVideoDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Boolean addToFavorite(Integer lessonId, Integer userId) {
		Boolean isAdded = Boolean.TRUE;
		try {
			Integer count = appJdbcTemplate.queryForObject(WilkefConstants.CHECK_FAVORITE_VIDEO,
					new Object[] { lessonId, userId }, Integer.class);
			LOG.log(Level.INFO, "Count:" + count);
			if (count == 0) {
				appJdbcTemplate.update(WilkefConstants.ADD_FAVORITE_VIDEO, lessonId, userId);
			}
		} catch (Exception e) {
			isAdded = Boolean.FALSE;
			LOG.log(Level.SEVERE, "Add To Favorite:" + e.getMessage());
		}
		return isAdded;
	}

	@Override
	public Boolean removeFromFavorite(Integer lessonId, Integer userId) {
		Boolean isRemoved = Boolean.TRUE;
		try {
			appJdbcTemplate.update(WilkefConstants.REMOVE_FAVORITE_VIDEO, lessonId, userId);
		} catch (Exception e) {
			isRemoved = Boolean.FALSE;
			LOG.log(Level.SEVERE, "Remove From Favorite:" + e.getMessage());
		}
		return isRemoved;
	}

	@Override
	public List<FavoriteVideoDTO> favoriteVideoList(Integer userId) {
		List<FavoriteVideoDTO> favoriteVideoList = new ArrayList<>();
		try {
			String query = WilkefConstants.FAVORITE_VIDEO_LIST;
			LOG.log(Level.SEVERE, "FAVORITE_VIDEO_LIST:" + WilkefConstants.FAVORITE_VIDEO_LIST);
			LOG.log(Level.SEVERE, "userId:" + userId);
			favoriteVideoList = appJdbcTemplate.query(query, new Object[] { userId }, (result, rowNum) -> {
				FavoriteVideoDTO favoriteVideo = new FavoriteVideoDTO();
				favoriteVideo.setFavoriteVideoId(result.getInt("FavoriteVideoId"));
				favoriteVideo.setUserId(result.getInt("UserId"));
				favoriteVideo.setLessonId(result.getInt("LessonId"));
				favoriteVideo.setLessonName(result.getString("LessonName"));
				favoriteVideo.setLessonThumbnail(result.getString("LessonThumbnail"));
				favoriteVideo.setVideoUrl(result.getString("VideoUrl"));
				return favoriteVideo;
			});
			LOG.log(Level.SEVERE, "favoriteVideoList:" + favoriteVideoList.toString());
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching favoriteVideoList" + e.getMessage());
		}
		return favoriteVideoList;
	}

}

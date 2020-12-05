package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.FavoriteVideoDTO;

public interface FavoriteVideoDao {

	public Boolean addToFavorite(Integer lessonId, Integer userId);

	public Boolean removeFromFavorite(Integer lessonId, Integer userId);

	public List<FavoriteVideoDTO> favoriteVideoList(Integer userId);

}

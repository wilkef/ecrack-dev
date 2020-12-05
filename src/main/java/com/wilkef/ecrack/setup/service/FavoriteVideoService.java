package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.FavoriteVideoDTO;

public interface FavoriteVideoService {

	public Boolean addToFavorite(Integer lessonId, Integer userId);

	public Boolean removeFromFavorite(Integer lessonId, Integer userId);

	public List<FavoriteVideoDTO> favoriteVideoList(Integer userId);
}

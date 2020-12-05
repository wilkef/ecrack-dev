package com.wilkef.ecrack.setup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.FavoriteVideoDao;
import com.wilkef.ecrack.setup.dto.FavoriteVideoDTO;
import com.wilkef.ecrack.setup.service.FavoriteVideoService;

@Service
public class FavoriteVideoServiceImpl implements FavoriteVideoService {

	@Autowired
	private FavoriteVideoDao favoriteVideoDao;

	@Override
	public Boolean addToFavorite(Integer lessonId, Integer userId) {
		return favoriteVideoDao.addToFavorite(lessonId, userId);
	}

	@Override
	public Boolean removeFromFavorite(Integer lessonId, Integer userId) {
		return favoriteVideoDao.removeFromFavorite(lessonId, userId);
	}

	@Override
	public List<FavoriteVideoDTO> favoriteVideoList(Integer userId) {
		return favoriteVideoDao.favoriteVideoList(userId);
	}

}

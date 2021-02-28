/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.VideoPlaylistDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.service.VideoPlaylistService;

/**
 * @author Chinmaya.dehury
 *
 * 16-Jan-2021
 *
 */
@Service
public class VideoPlaylistServiceImpl implements VideoPlaylistService{
	
	@Autowired
	private VideoPlaylistDao videoPlaylistDao;

	@Override
	public List<LessionListDataDTO> fetchVideoPlaylist(int gradeId) {
		return videoPlaylistDao.fetchDBPlaylist(gradeId);
	}

}

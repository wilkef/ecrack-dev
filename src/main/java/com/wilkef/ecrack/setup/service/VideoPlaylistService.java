/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.PlaylistDTO;

/**
 * @author Chinmaya.dehury
 *
 * 16-Jan-2021
 *
 */
public interface VideoPlaylistService {
	public List<PlaylistDTO> fetchVideoPlaylist(int gradeId);

}

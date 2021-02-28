/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.LessionListDataDTO;

/**
 * @author Chinmaya.dehury
 *
 * 16-Jan-2021
 *
 */
public interface VideoPlaylistDao {
	public List<LessionListDataDTO> fetchDBPlaylist(int gradeId);

}

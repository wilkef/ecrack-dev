/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;

/**
 * @author Satya
 * Oct 31, 2020
 */

public interface WatchedVideoDao {
	public Integer saveWatchedVideo(WatchedVideoDataDto watchedVideo);
}

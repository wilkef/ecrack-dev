/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;

/**
 * @author Satya Oct 31, 2020
 */

public interface WatchedVideoDao {
	Boolean saveWatchedVideo(WatchedVideoDataDto watchedVideo, Integer userId);

	List<WatchedVideoDataDto> mostWatchedVideo(Integer userId);

	List<WatchedVideoDataDto> videoSuggestion(Integer userId);
}

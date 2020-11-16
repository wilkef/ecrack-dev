/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;

/**
 * @author Satya
 * Oct 31, 2020
 */

public interface WatchedVideoDao {
	 Integer saveWatchedVideo(WatchedVideoDataDto watchedVideo);

	 List<WatchedVideoDataDto> mostWatchedVideo(WatchedVideoDataDto watchedVideo);

	List<WatchedVideoDataDto> videoSuggestion(WatchedVideoDataDto watchedVideo);
}

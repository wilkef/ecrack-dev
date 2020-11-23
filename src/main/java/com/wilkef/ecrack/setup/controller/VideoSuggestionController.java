/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.VideoSuggestionDao;
import com.wilkef.ecrack.setup.dto.VideoSuggestion;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;

/**
 * @author Satya Nov 1, 2020
 */

@RestController
@RequestMapping("/user")
public class VideoSuggestionController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(VideoSuggestionController.class.getName());

	@Autowired
	private VideoSuggestionDao videoSuggestion;

	@GetMapping("/videoSuggestion")
	public ResponseEntity<Object> getVideoSuggestion() {
		LOG.info("START-Inside VideoSuggestion");
		ResponseEntity<Object> response = null;
		List<VideoSuggestion> videoSuggestionList = null;

		LOG.info("Inside VideoSuggestion Controller");
		try {
			LOG.log(Level.INFO, () -> "Before geting UnitList VideoSuggestion Record : ");
			videoSuggestionList = videoSuggestion.videoSuggestion();
			response = new ResponseEntity<>(videoSuggestionList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside VideoSuggestion");
		return response;
	}
}

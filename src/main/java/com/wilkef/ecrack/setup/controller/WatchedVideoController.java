/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * @author Satya
 * Oct 31, 2020
 */

@RestController
@RequestMapping("/user")
public class WatchedVideoController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(WatchedVideoController.class.getName());

	/** The service. */
	@Autowired
	public WatchedVideoDao dao; 

	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@PostMapping(value = "/Watchedvideo")
	public ResponseEntity<Object> saveWatchedVideo(@RequestBody WatchedVideoDataDto watchedVideo){
		ResponseEntity<Object> response=null;
		try {
			LOG.log(Level.INFO, () -> "save video record : " );
			Integer saveWatchedVideo = dao.saveWatchedVideo(watchedVideo);
			if (saveWatchedVideo>0) {
				response= ResponseEntity.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			}else {
				response= ResponseEntity.status(HttpStatus.OK)	
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
	
	

	@PostMapping(value = "/mostWatchedvideo")
	public ResponseEntity<Object> mostWatchedvideo(@RequestBody WatchedVideoDataDto watchedVideo){
		ResponseEntity<Object> response=null;
		try {
			LOG.log(Level.INFO, () -> "mostWatchedvideo: " );
			List<WatchedVideoDataDto>  list = dao.mostWatchedVideo(watchedVideo);
		
				response= ResponseEntity.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(list);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
	
	@PostMapping(value = "/videoSuggestion")
	public ResponseEntity<Object> videoSuggestion(@RequestBody WatchedVideoDataDto watchedVideo){
		ResponseEntity<Object> response=null;
		try {
			LOG.log(Level.INFO, () -> "videoSuggestion : " );
			List<WatchedVideoDataDto>  list = dao.videoSuggestion(watchedVideo);
		
				response= ResponseEntity.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(list);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
}

/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;
import com.wilkef.ecrack.setup.service.UserService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * @author Satya Oct 31, 2020
 * @modified by Pradeepta on 29 Nov 2020
 */

@RestController
@RequestMapping("/user")
public class WatchedVideoController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(WatchedVideoController.class.getName());

	@Autowired
	public WatchedVideoDao watchedVideoDao;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private HttpServletRequest request;

	@PostMapping(value = "/watchedVideo")
	public ResponseEntity<Object> saveWatchedVideo(@RequestBody WatchedVideoDataDto watchedVideo) {
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "save video record : " + watchedVideo);
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			Boolean isSaved = watchedVideoDao.saveWatchedVideo(watchedVideo, loggedinUserInfo.getUserId());
			if (isSaved) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.TRUE));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.FALSE, ErrorConstants.SMTHNG_WNT_WRONG));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		return response;
	}

	@PostMapping(value = "/mostWatchedvideo")
	public ResponseEntity<Object> mostWatchedvideo(@RequestBody WatchedVideoDataDto watchedVideo) {
		LOG.log(Level.INFO, () -> "Start mostWatchedvideo");
		ResponseEntity<Object> response = null;
		try {
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			List<WatchedVideoDataDto> mostWatchedvideoList = watchedVideoDao.mostWatchedVideo(loggedinUserInfo.getUserId());

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, mostWatchedvideoList));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE,null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End mostWatchedvideo");
		return response;
	}

	@PostMapping(value = "/videoSuggestion")
	public ResponseEntity<Object> videoSuggestion(@RequestBody WatchedVideoDataDto watchedVideo) {
		ResponseEntity<Object> response = null;
		LOG.log(Level.INFO, () -> "videoSuggestion Start");
		try {
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			List<WatchedVideoDataDto> suggestedVideoList = watchedVideoDao.videoSuggestion(loggedinUserInfo.getUserId());

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, suggestedVideoList));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "videoSuggestion End ");
		return response;
	}
	
}

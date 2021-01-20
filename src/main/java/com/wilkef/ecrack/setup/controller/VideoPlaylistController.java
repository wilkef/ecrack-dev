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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.PlaylistDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.VideoPlaylistService;

/**
 * @author Chinmaya.dehury
 *
 *         16-Jan-2021
 *
 */
@RestController
@RequestMapping("/user")
public class VideoPlaylistController {
	public static final Logger LOG = Logger.getLogger(VideoPlaylistController.class.getName());

	@Autowired
	private VideoPlaylistService videoPlaylistService;

	@GetMapping(value = "/playlist/{gradeId}")
	public ResponseEntity<Object> getVideoPlaylist(@PathVariable("gradeId") Integer gradeId) {
		LOG.info("video playlist method started...");
		LOG.log(Level.INFO, () -> "Before geting Subject information based on gradeId : " + gradeId);
		ResponseEntity<Object> response = null;
		List<PlaylistDTO> videoList = null;

		try {
			videoList = videoPlaylistService.fetchVideoPlaylist(gradeId);
			response = new ResponseEntity<>(videoList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}

}

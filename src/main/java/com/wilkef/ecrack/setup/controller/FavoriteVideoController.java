package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.WatchedVideoDao;
import com.wilkef.ecrack.setup.dto.FavoriteVideoDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.WatchedVideoDataDto;
import com.wilkef.ecrack.setup.service.FavoriteVideoService;
import com.wilkef.ecrack.setup.service.UserService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/video")
public class FavoriteVideoController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(FavoriteVideoController.class.getName());

	@Autowired
	public FavoriteVideoService favoriteVideoService;

	@Autowired
	private UserService userService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private HttpServletRequest request;

	@PostMapping(value = "/addToFavorite/{lessonId}")
	public ResponseEntity<Object> addToFavorite(@Valid @PathVariable("lessonId") Integer lessonId) {
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "lessonId:" + lessonId);
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			Boolean isSaved = favoriteVideoService.addToFavorite(lessonId, loggedinUserInfo.getUserId());
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

	@PostMapping(value = "/removeFromFavorite/{lessonId}")
	public ResponseEntity<Object> removeFromFavorite(@Valid @PathVariable("lessonId") Integer lessonId) {
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "lessonId:" + lessonId);
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			Boolean isRemoved = favoriteVideoService.removeFromFavorite(lessonId, loggedinUserInfo.getUserId());
			if (isRemoved) {
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

	@GetMapping(value = "/favoriteVideos")
	public ResponseEntity<Object> favoriteVideos() {
		LOG.log(Level.INFO, () -> "Start favoriteVideos");
		ResponseEntity<Object> response = null;
		try {
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER).replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			LoggedinUserInfo loggedinUserInfo = userService.getLoggedinUserInfo(jwtToken);

			List<FavoriteVideoDTO> favoriteVideoList = favoriteVideoService
					.favoriteVideoList(loggedinUserInfo.getUserId());

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, favoriteVideoList));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End favoriteVideos");
		return response;
	}

}

package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

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

import com.wilkef.ecrack.setup.admin.dao.ManageLessonDao;
import com.wilkef.ecrack.setup.admin.dto.ManageLessonDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class ManageLessonController {
	private static final Logger LOG = Logger.getLogger(ManageLessonController.class.getName());

	@Autowired
	private ManageLessonDao lessonService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@GetMapping(value = "getLessonList/{unitId}")
	public ResponseEntity<Object> getLessonList(@PathVariable("unitId") Integer unitId) {
		LOG.log(Level.INFO, () -> "Start getLessonList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> lessonList = lessonService.getLessonList(unitId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, lessonList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getLessonList Controller");
		return response;
	}

	@PostMapping(value = "/saveLession")
	public ResponseEntity<Object> saveLession(@RequestBody ManageLessonDTO data) {
		LOG.log(Level.INFO, () -> "Start saveLession");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));

		ResponseEntity<Object> response = null;
		try {
			lessonService.saveLesson(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End saveLession");
		return response;
	}

	@GetMapping(value = "/getLessionDetails/{lessionId}")
	public ResponseEntity<Object> getLessionDetails(@PathVariable Integer lessionId) {
		LOG.log(Level.INFO, () -> "Start getLessionDetails");
		ResponseEntity<Object> response = null;
		try {
			ManageLessonDTO item = lessonService.getLessonDetails(lessionId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, item));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getLessionDetails");
		return response;
	}

}

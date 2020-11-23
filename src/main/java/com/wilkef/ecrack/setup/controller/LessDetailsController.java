/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.LessonDetailsDao;
import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;

/**
 * @author Satya Nov 2, 2020
 */

@RestController
@RequestMapping("/user")
public class LessDetailsController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(LessDetailsController.class.getName());

	/** The validation dao. */
	@Autowired
	private LessonDetailsDao lessonDetailsDao;

	@GetMapping(value = "/LessonDetails/{lessonId}")
	public ResponseEntity<Object> lessonDetails(@Valid @PathVariable("lessonId") Integer lessonId) {
		LOG.info("START-Inside LessonDetails");
		ResponseEntity<Object> response = null;
		List<LessonDetailsDataDto> lessonDetails = new ArrayList<>();
		try {
			LOG.log(Level.INFO, () -> "Before geting LessonDetails information ");
			lessonDetails = lessonDetailsDao.getAllLessonDetails(lessonId);
			response = new ResponseEntity<>(lessonDetails, HttpStatus.OK);

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside LessonDetails");
		return response;
	}
}

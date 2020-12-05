/**
 *  This Class is Identify to execute Lession Controller Operation
 * 
 * @author Satya
 *Sep 18, 2020
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.LessonDetailsDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.LessionListService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class LessionListController.
 */
@RestController
@RequestMapping("/subject")
public class LessionController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(LessionController.class.getName());

	@Autowired
	private LessionListService lessionService;

	@Autowired
	private LessonDetailsDao lessonDetailsDao;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	/**
	 * Find by grade id.
	 *
	 * @param unitId the unit id
	 * @return the response entity
	 */
	@GetMapping(value = "/lessionList/{UnitId}")
	public ResponseEntity<Object> findByGradeId(@PathVariable("UnitId") Integer unitId) {
		LOG.info("START-Inside findByGradeId ");
		LOG.log(Level.INFO, () -> "updateProfile Inputs unitId: " + unitId);
		ResponseEntity<Object> response = null;
		List<LessionListDataDTO> lessionList = null;
		try {
			lessionList = lessionService.findByUnitId(unitId);
			response = new ResponseEntity<>(lessionList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("START-Inside findByGradeId ");
		return response;
	}

	@GetMapping(value = "/lessonDetails/{lessonId}")
	public ResponseEntity<Object> lessonDetails(@Valid @PathVariable("lessonId") Integer lessonId) {
		LOG.info("START-Inside LessonDetails");
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting LessonDetails information ");
			LessonDetailsDataDto lessonDetails = lessonDetailsDao.getLessonDetails(lessonId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, lessonDetails));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(
					serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage()));
		}
		LOG.info("END-Inside LessonDetails");
		return response;
	}

}

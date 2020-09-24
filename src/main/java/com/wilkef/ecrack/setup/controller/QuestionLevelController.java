
/**
 * This Class is Used to execute DifficultyLevel Execution 
 * 
 * @author Satya
 *Sep 16, 2020
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
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.QuestionLevelService;


/**
 * The Class QuestionLevelController.
 */
@RestController
@RequestMapping("/user")
public class QuestionLevelController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(QuestionLevelController.class.getName());
	
	/** The question service. */
	@Autowired
	private QuestionLevelService questionService;

	/**
	 * Find difficulty code.
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "/difficultyLevel")
	public ResponseEntity<Object> findDifficultyCode(){
		LOG.info("START-Inside findDifficultyCode ");
		LOG.log(Level.INFO, () -> "No findDifficultyCode Inputs "); 
		ResponseEntity<Object> response = null;
		List<QuestionLevelDataDTO> questionLevelList = null;
		LOG.info("Inside find the QuestionLevel ");
		try {
			LOG.log(Level.INFO, () -> "Before geting QuestionLevel information : " );
			questionLevelList = questionService.findQuestionLevel();
			if (!questionLevelList.isEmpty()) {
				response = new ResponseEntity<>(questionLevelList, HttpStatus.OK);
			} else {
				LOG.log(Level.INFO, () -> "QuestionLevel is Not There in DB " );
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside findDifficultyCode ");
		return response;
	}
}

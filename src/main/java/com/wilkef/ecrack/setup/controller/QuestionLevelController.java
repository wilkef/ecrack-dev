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

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;
import com.wilkef.ecrack.setup.exception.RecordNotFoundException;
import com.wilkef.ecrack.setup.service.QuestionLevelService;


/**
 * This Class is Used to execute DifficultyLevel Execution 
 * 
 * @author Satya
 *Sep 16, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/user")
public class QuestionLevelController {

	private static final Logger LOG = Logger.getLogger(QuestionLevelController.class.getName());
	
	@Autowired
	private QuestionLevelService questionService;

	@GetMapping(value = "/difficultyLevel")
	public ResponseEntity<Object> findDifficultyCode(){
		
		ResponseEntity<Object> response = null;
		List<QuestionLevelDataDTO> questionLevelList = null;
		LOG.info("Inside find the QuestionLevel ");
		try {
			LOG.log(Level.INFO, () -> "Before geting QuestionLevel information : " );
			questionLevelList = questionService.findQuestionLevel();
			if (!questionLevelList.isEmpty()) {
				response = new ResponseEntity<>(questionLevelList, HttpStatus.OK);
				return response;
			} else {
				LOG.log(Level.INFO, () -> "QuestionLevel is Not There in DB " );
				throw new RecordNotFoundException("No Record Found");
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching the Question Level information : " + e.getMessage());
		}
		return response;
	}
}

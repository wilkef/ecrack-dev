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
	public ResponseEntity<?> findDifficultyCode(){
		
		ResponseEntity<?> response = null;
		List<QuestionLevelDataDTO> questionLevelList = null;
		LOG.info("Inside find the QuestionLevel ");
		try {
			LOG.log(Level.INFO, () -> "Before geting QuestionLevel information : " );
			questionLevelList = questionService.findQuestionLevel();
			if (!questionLevelList.isEmpty()) {
				response = new ResponseEntity<>(questionLevelList, HttpStatus.OK);
				return response;
			} else {
				response = new ResponseEntity<>("Record Not Found ", HttpStatus.OK);
				return response;
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching the Question Level information : " + e.getMessage());
		}
		return response;
	}
}

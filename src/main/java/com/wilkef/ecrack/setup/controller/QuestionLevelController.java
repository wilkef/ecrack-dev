package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.QuestionLevelDao;
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

/**
 * This Class is Used to execute DifficultyLevel Execution 
 * 
 * @author Satya
 *Sep 16, 2020
 */

@RestController
@RequestMapping("/questionLevel")
public class QuestionLevelController {

	private static final Logger LOG = Logger.getLogger(QuestionLevelController.class.getName());
	List<QuestionLevelDataDTO> allQuestionLevel = null;
	
	@Autowired
	private QuestionLevelDao questionDao;

	@GetMapping(value = "/getDifficultyCode")
	public List<QuestionLevelDataDTO> findDifficultyCode(){
		
		LOG.info("Inside find difficulty code");
		try {
			LOG.log(Level.INFO,() -> "before geting question information ...");
			if (allQuestionLevel == null) {
				allQuestionLevel = questionDao.findQuestionLevel();
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "somthing wrong while fetching the information : " + e.getMessage());
		}
		return  allQuestionLevel;
	}
}

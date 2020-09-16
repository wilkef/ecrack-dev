package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.QuestionLevelDao;
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;


@RestController
@RequestMapping("/questionLevel")
public class QuestionLevelController {

	private static final Logger LOG = Logger.getLogger(QuestionLevelController.class.getName());

	@Autowired
	private QuestionLevelDao questionDao;

	@GetMapping(value = "/getDifficultyCode")
	public List<QuestionLevelDataDTO> findDifficultyCode(){
		LOG.info("No input");
		List<QuestionLevelDataDTO> allQuestionLevel = questionDao.findQuestionLevel();
		return allQuestionLevel;
	}
}

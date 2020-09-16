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

@RestController
@RequestMapping("/questionLevel")
public class QuestionLevelController {

	private static final Logger LOG = Logger.getLogger(QuestionLevelController.class.getName());
	List<QuestionLevelDataDTO> allQuestionLevel = null;

	@Autowired
	private QuestionLevelDao questionDao;

	@GetMapping(value = "/getDifficultyCode")
	public List<QuestionLevelDataDTO> findDifficultyCode() {
		LOG.info("Inside find difficulty code");
		try {
			LOG.log(Level.INFO, () -> "Before getting question information .. ");
			if (allQuestionLevel == null)
				allQuestionLevel = questionDao.findQuestionLevel();
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "Something wrong while fetching the information : " + exception.getMessage());
		}
		return allQuestionLevel;
	}
}

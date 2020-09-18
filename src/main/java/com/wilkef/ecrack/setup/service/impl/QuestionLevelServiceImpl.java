/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.QuestionLevelDao;
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;
import com.wilkef.ecrack.setup.service.QuestionLevelService;

/**
 * This class provides implementation for QuestionLevelService interface to get the Question Level details.
 * 
 * @author Satya
 *Sep 18, 2020
 */

@Service
public class QuestionLevelServiceImpl implements QuestionLevelService{

public static final Logger LOG = Logger.getLogger(QuestionLevelServiceImpl.class.getName());
	
	@Autowired
	private QuestionLevelDao questionLevelDao;
	
	@Override
	public List<QuestionLevelDataDTO> findQuestionLevel() {
		List<QuestionLevelDataDTO> questionLevelList = null;
		try {
			questionLevelList = questionLevelDao.findQuestionLevel();
		} catch(Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the Question Level Record : " + exception.getMessage());
		}
		return questionLevelList;
	}
}

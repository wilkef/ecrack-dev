package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

/**
 * The Interface QuestionLevelDao.
 *
 * @author Satya
 * Sep 16, 2020
 */

public interface QuestionLevelDao {
	
	/**
	 * Find question level.
	 *
	 * @return the list
	 */
	public List<QuestionLevelDataDTO> findQuestionLevel();
}

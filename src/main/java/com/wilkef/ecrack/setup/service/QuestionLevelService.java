/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

/**
 * The Interface QuestionLevelService.
 *
 * @author Satya Sep 18, 2020
 */
public interface QuestionLevelService {

	/**
	 * Find question level.
	 *
	 * @return the list
	 */
	public List<QuestionLevelDataDTO> findQuestionLevel();
}

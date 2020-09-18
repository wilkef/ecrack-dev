/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

/**
 * @author Satya
 *Sep 18, 2020
 */
public interface QuestionLevelService {
	public List<QuestionLevelDataDTO> findQuestionLevel();
}

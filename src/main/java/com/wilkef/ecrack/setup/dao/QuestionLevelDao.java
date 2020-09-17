package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

/**
 * @author Satya
 *Sep 16, 2020
 */

public interface QuestionLevelDao {
	public List<QuestionLevelDataDTO> findQuestionLevel();
}

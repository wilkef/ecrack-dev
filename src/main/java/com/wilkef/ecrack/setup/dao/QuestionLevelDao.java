package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

public interface QuestionLevelDao {
	public List<QuestionLevelDataDTO> findQuestionLevel();
}

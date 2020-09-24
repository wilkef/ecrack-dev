package com.wilkef.ecrack.setup.service;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.QuizTestDTO;


/**
 * The Interface ExamService.
 */
public interface ExamService {

	/**
	 * Gets the scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the scheduled test
	 */
	List<QuizTestDTO> getScheduledTest(@Valid Integer gradeId);




}

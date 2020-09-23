package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;

public interface ExamDao {

	List<QuizTestDTO> getScheduledTest(Integer gradeId);

	List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer noOfQuestion,
			Integer questionLevel);

	List<QuizQuestionDTO> getQuestions(Integer lessonId, Integer noOfQuestion, Integer questionLevel);

	List<TestResultDTO> getStudentResultSummary(Integer testId);


	Integer saveStudentResult(String result);

}

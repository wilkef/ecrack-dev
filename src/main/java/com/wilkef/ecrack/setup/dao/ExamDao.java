package com.wilkef.ecrack.setup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.ApperedTestListDTO;
import com.wilkef.ecrack.setup.dto.McqTestItemDto;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.dto.TestSummaryDTO;

/**
 * The Interface ExamDao.
 */
public interface ExamDao {

	List<ApperedTestListDTO> getApperedTestList(Integer userId);
	
	
	/**
	 * Gets the scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the scheduled test
	 */
	List<QuizTestDTO> getScheduledTest(Integer gradeId);

	/**
	 * Gets the quiz questions.
	 *
	 * @param lessonId      the lesson id
	 * @param noOfQuestion  the no of question
	 * @param questionLevel the question level
	 * @return the quiz questions
	 */
//	List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer noOfQuestion, Integer questionLevel);

	List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer questionLevel);

	/**
	 * Gets the questions.
	 *
	 * @param lessonId      the lesson id
	 * @param questionLevel the question level
	 * @return the questions
	 */
	List<QuizQuestionDTO> getQuestions(Integer lessonId, Integer questionLevel);

	List<QuizQuestionDTO> getQuestionsForPracticeTest(Integer unitId, Integer questionLevel);

	/**
	 * Gets the student result summary.
	 *
	 * @param testId the test id
	 * @return the student result summary
	 */
	List<TestResultDTO> getStudentResultSummary(Integer testId);

	/**
	 * Save student result.
	 *
	 * @param result the result
	 * @return the integer
	 */
	Integer saveStudentResult(String result);

	String saveQuizTest(Integer userId, Integer lessonId, Integer difficultyLevel, ArrayList<McqTestItemDto> questions);

	TestSummaryDTO getTestResultSummary(String uniqueId);
}

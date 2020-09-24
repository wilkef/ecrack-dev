package com.wilkef.ecrack.setup.dao;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;

/**
 * The Interface ExamDao.
 */
public interface ExamDao {

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
	 * @param lessonId the lesson id
	 * @param noOfQuestion the no of question
	 * @param questionLevel the question level
	 * @return the quiz questions
	 */
	List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer noOfQuestion,
			Integer questionLevel);

	/**
	 * Gets the questions.
	 *
	 * @param lessonId the lesson id
	 * @param noOfQuestion the no of question
	 * @param questionLevel the question level
	 * @return the questions
	 */
	List<QuizQuestionDTO> getQuestions(Integer lessonId, Integer noOfQuestion, Integer questionLevel);

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

}

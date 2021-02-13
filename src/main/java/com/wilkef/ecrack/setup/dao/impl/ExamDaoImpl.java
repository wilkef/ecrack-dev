/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related 
 *
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuestionOptionsDTO;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

/**
 * The Class ExamDaoImpl.
 */
@Repository
@Transactional
public class ExamDaoImpl implements ExamDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ExamDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Gets the scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the scheduled test
	 */
	@Override
	public List<QuizTestDTO> getScheduledTest(Integer gradeId) {

		List<QuizTestDTO> questionTestDTOList = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.GET_SCHLD_TEST)
					.returningResultSet("ResultSet", BeanPropertyRowMapper.newInstance(QuizTestDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(gradeId);
			questionTestDTOList = (List<QuizTestDTO>) execute.get("ResultSet");
			if (!questionTestDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return questionTestDTOList;

	}
	
	/**
	 * Gets the quiz questions.
	 *
	 * @param lessonId      the lesson id
	 * @param noOfQuestion  the no of question
	 * @param questionLevel the question level
	 * @return the quiz questions
	 */

	@Override
	public List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer questionLevel) {
		List<QuizQuestionDTO> quizTestDTOList = new ArrayList<>();
		try {
			Gson gson = new Gson();
			Integer limit = (int) appJdbcTemplate.queryForObject("SELECT CASE WHEN NoOfQuestion > 0 THEN NoOfQuestion ELSE 10 END "
					+ "AS NoOfQuestion FROM `Lesson` WHERE LessonId=?", new Object[] {lessonId}, Integer.class);
			
			String query = "SELECT McqId, Question, QuestionDesc, QuestionImg, Solution, DifficultyLevel, QuestionOptionsJson, Answer "
					+ "FROM Mcq WHERE LessonId=? AND DifficultyLevel=? ORDER BY RAND() LIMIT ?";
			
			appJdbcTemplate.query(query, new Object[] { lessonId, questionLevel, limit }, (result, rowNum) -> {
				QuizQuestionDTO item = new QuizQuestionDTO();
				item.setMcqId(result.getString("McqId"));
				item.setQuestion(result.getString("Question"));
				item.setQuestionDesc(result.getString("QuestionDesc"));
				item.setQuestionImg(result.getString("QuestionImg"));
				item.setSolution(result.getString("Solution"));
				item.setDifficultyCode(result.getString("DifficultyLevel"));
				item.setOptionList(gson.fromJson(result.getString("QuestionOptionsJson"), QuestionOptionsDTO[].class));
				item.setAnswer(result.getString("Answer"));
				quizTestDTOList.add(item);
				return quizTestDTOList;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			throw new CustomException("Error while fetaching quiz questions:" + e.getMessage());
		}
		return quizTestDTOList;
	}


//	/**
//	 * Gets the quiz questions.
//	 *
//	 * @param lessonId      the lesson id
//	 * @param noOfQuestion  the no of question
//	 * @param questionLevel the question level
//	 * @return the quiz questions
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<QuizQuestionDTO> getQuizQuestions(Integer lessonId, Integer noOfQuestion, Integer questionLevel) {
//		List<QuizQuestionDTO> quizTestDTOList = new ArrayList<>();
//		try {
//			SqlParameterSource parameters = new MapSqlParameterSource()
//					.addValue("p_lessonId", lessonId)
//					.addValue("p_qLevel", questionLevel)
//					.addValue("p_noOfQuestions", noOfQuestion);
//			
//			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
//					.withProcedureName(WilkefConstants.GET_QUIZ_QSTN)
//					.returningResultSet("ResultSet", BeanPropertyRowMapper.newInstance(QuizQuestionDTO.class));
//
//			Map<String, Object> execute = simpleJdbcCall.execute(parameters);
//			quizTestDTOList = (List<QuizQuestionDTO>) execute.get("ResultSet");
//			if (!quizTestDTOList.isEmpty()) {
//				LOG.fine("Data Retrieved Successfully");
//			}
//		} catch (Exception e) {
//			LOG.log(Level.SEVERE, e.getMessage());
//		}
//		return quizTestDTOList;
//	}
	
	/**
	 * Gets the questions.
	 *
	 * @param lessonId      the lesson id
	 * @param noOfQuestion  the no of question
	 * @param questionLevel the question level
	 * @return the questions
	 */
	@Override
	public List<QuizQuestionDTO> getQuestions(Integer lessonId, Integer questionLevel) {
		List<QuizQuestionDTO> quizTestDTOList = new ArrayList<>();
		try {
			Gson gson = new Gson();
			Integer limit = 25;

			String query = "SELECT McqId, Question, QuestionDesc, QuestionImg, QuestionOptionsJson "
					+ " FROM Mcq WHERE LessonId=? AND DifficultyLevel=? ORDER BY RAND() LIMIT ?";
			appJdbcTemplate.query(query, new Object[] { lessonId, questionLevel, limit }, (result, rowNum) -> {
				QuizQuestionDTO item = new QuizQuestionDTO();
				item.setMcqId(result.getString("McqId"));
				item.setQuestion(result.getString("Question"));
				item.setQuestionDesc(result.getString("QuestionDesc"));
				item.setQuestionImg(result.getString("QuestionImg"));				
				item.setOptionList(gson.fromJson(result.getString("QuestionOptionsJson"), QuestionOptionsDTO[].class));
				quizTestDTOList.add(item);
				return quizTestDTOList;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return quizTestDTOList;
	}

//	/**
//	 * Gets the questions.
//	 *
//	 * @param lessonId      the lesson id
//	 * @param noOfQuestion  the no of question
//	 * @param questionLevel the question level
//	 * @return the questions
//	 */
//	@Override
//	public List<QuizQuestionDTO> getQuestions(Integer lessonId, Integer noOfQuestion, Integer questionLevel) {
//		List<QuizQuestionDTO> quizTestDTOList = new ArrayList<>();
//		try {
//			SqlParameterSource in = new MapSqlParameterSource().addValue("p_lessonId", lessonId)
//					.addValue("p_qLevel", questionLevel).addValue("p_noOfQuestion", noOfQuestion);
//			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
//					.withProcedureName(WilkefConstants.GET_QUESTION)
//					.returningResultSet("ResultSet", BeanPropertyRowMapper.newInstance(QuizQuestionDTO.class));
//
//			Map<String, Object> execute = simpleJdbcCall.execute(in);
//			quizTestDTOList = (List<QuizQuestionDTO>) execute.get("ResultSet");
//			if (!quizTestDTOList.isEmpty()) {
//				LOG.fine("Data Retrieved Successfully");
//			}
//		} catch (Exception e) {
//			LOG.log(Level.SEVERE, e.getMessage());
//		}
//		return quizTestDTOList;
//	}

	/**
	 * Gets the student result summary.
	 *
	 * @param testId the test id
	 * @return the student result summary
	 */
	@Override
	public List<TestResultDTO> getStudentResultSummary(@Valid Integer testId) {
		List<TestResultDTO> testResultDTOList = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.STUDENT_RESULT_SUMRY)
					.returningResultSet("ResultSet", BeanPropertyRowMapper.newInstance(TestResultDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(testId);
			testResultDTOList = (List<TestResultDTO>) execute.get("ResultSet");
			if (!testResultDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return testResultDTOList;
	}

	/**
	 * Save student result.
	 *
	 * @param result the result
	 * @return the integer
	 */
	@Override
	public Integer saveStudentResult(String result) {
		List<TestResultDTO> testResultDTOList = new ArrayList<>();
		Integer returnVal = 0;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.SAVE_STUDENT_RESULT);

			Map<String, Object> execute = simpleJdbcCall.execute(result);
			returnVal = (Integer) execute.get("#update-count-1");
			if (!testResultDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return returnVal;
	}

}

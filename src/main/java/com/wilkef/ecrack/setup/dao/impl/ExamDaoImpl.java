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
import java.util.UUID;
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
import com.wilkef.ecrack.setup.dto.ApperedTestListDTO;
import com.wilkef.ecrack.setup.dto.McqTestItemDto;
import com.wilkef.ecrack.setup.dto.QuestionOptionsDTO;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.dto.TestSummaryDTO;
import com.wilkef.ecrack.setup.dto.TestSummaryQuestionDTO;
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
	
	@Override
	public TestSummaryDTO getTestResultSummary(String uniqueId) {
		TestSummaryDTO testSummary = new TestSummaryDTO();
		try {
			String sql = "SELECT a.ActivityId, l.LessonName, a.UserId, a.UniqueId, a.LessonId, a.DifficultyLevel, a.TotalQuestion,"
					+ " a.RightQuestion, a.WrongQuestion, a.TimeExhausted  FROM `ActivityTest` a "
					+ "LEFT JOIN Lesson l ON(a.LessonId = l.LessonId) WHERE a.UniqueId=?";
			appJdbcTemplate.queryForObject(sql, new Object[] { uniqueId }, (rs, rowNum) -> {
				testSummary.setActivityId(rs.getInt("ActivityId"));
				testSummary.setUserId(rs.getInt("UserId"));
				testSummary.setUniqueId(rs.getString("UniqueId"));
				testSummary.setLessonId(rs.getInt("LessonId"));
				testSummary.setLessonName(rs.getString("LessonName"));
				testSummary.setTotalQuestion(rs.getInt("TotalQuestion"));
				testSummary.setCorrectAnswers(rs.getInt("RightQuestion"));
				testSummary.setWrongAnswers(rs.getInt("WrongQuestion"));
				testSummary.setTimeTaken(rs.getInt("TimeExhausted"));
				testSummary.setDifficultyLevel(rs.getInt("DifficultyLevel"));
				return testSummary;
			});

			Gson gson = new Gson();
			List<TestSummaryQuestionDTO> mcqList = new ArrayList<TestSummaryQuestionDTO>();
			String query = "SELECT q.McqId, q.Question, q.QuestionDesc, q.QuestionImg, q.Solution, q.QuestionOptionsJson, q.Answer, "
					+ "q.IsMultiChoice, l.AnswerStatusId, l.SelectedOptions "
					+ "FROM ActivityTestLine l JOIN Mcq q ON(l.QuestionId=q.McqId) WHERE l.ActivityId=? ORDER BY l.ActivityLineId DESC";
			
			appJdbcTemplate.query(query, new Object[] { testSummary.getActivityId() }, (result, rowNum) -> {
				TestSummaryQuestionDTO item = new TestSummaryQuestionDTO();
				item.setMcqId(result.getLong("McqId"));
				item.setQuestion(result.getString("Question"));
				item.setQuestionDesc(result.getString("QuestionDesc"));
				item.setQuestionImg(result.getString("QuestionImg"));
				item.setSolution(result.getString("Solution"));
				item.setOptionList(gson.fromJson(result.getString("QuestionOptionsJson"), QuestionOptionsDTO[].class));
				item.setIsMultiChoice(result.getInt("IsMultiChoice") == 1 ? true : false);
				item.setAnswerStatus(result.getInt("AnswerStatusId"));
				item.setAnswer(result.getString("Answer"));
				item.setSelectedOptions(result.getString("SelectedOptions"));
				mcqList.add(item);
				return mcqList;
			});
			testSummary.setQuestions(mcqList);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching exam summary:" + e.getMessage());
			throw new CustomException("Error while fetching exam summary:" + e.getMessage());
		}
		return testSummary;
	}

	@Override
	public String saveQuizTest(Integer userId, Integer lessonId, Integer difficultyLevel,
			ArrayList<McqTestItemDto> mcqList) {
		String uniqueId = UUID.randomUUID().toString();
		try {
			// Save to `ActivityTest` table
			String sql = "INSERT INTO `ActivityTest` (`UserId`, `UniqueId`, `LessonId`, `DifficultyLevel`, `CreationDate`) VALUES (?,?,?,?, NOW())";
			appJdbcTemplate.update(sql, userId, uniqueId, lessonId, difficultyLevel);
			Integer activityId = (int) appJdbcTemplate.queryForObject(
					"SELECT ActivityId FROM ActivityTest ORDER BY ActivityId DESC LIMIT 1", new Object[] {},
					Integer.class);

			// Save to `ActivityTestLine` table
			for (McqTestItemDto mcq : mcqList) {
				String query = "INSERT INTO `ActivityTestLine` (`ActivityId`, `QuestionId`, `AnswerStatusId`, `TimeTaken`, "
						+ "`IsAttempted`, `SelectedOptions`) VALUES (?, ?, ?, ?, ?, ?)";
				Integer answerStatusId = getAnswerStatus(mcq.getMcqId(), mcq.getSelectedAnswers());
				appJdbcTemplate.update(query, activityId, mcq.getMcqId(), answerStatusId, mcq.getTimeTaken(),
						mcq.getIsAttempted(), mcq.getSelectedAnswers());
			}
			
			String updateSql = "UPDATE ActivityTest t SET \r\n" + 
					"TotalQuestion=(SELECT COUNT(*) FROM ActivityTestLine WHERE ActivityId=t.ActivityId),\r\n" + 
					"AttendedQuestion=(SELECT COUNT(*) FROM ActivityTestLine WHERE ActivityId=t.ActivityId AND AnswerStatusId IN(1, 2)),\r\n" + 
					"SkippedQuestion=(SELECT COUNT(*) FROM ActivityTestLine WHERE ActivityId=t.ActivityId AND AnswerStatusId = 3),\r\n" + 
					"RightQuestion=(SELECT COUNT(*) FROM ActivityTestLine WHERE ActivityId=t.ActivityId AND AnswerStatusId = 1),\r\n" + 
					"WrongQuestion=(SELECT COUNT(*) FROM ActivityTestLine WHERE ActivityId=t.ActivityId AND AnswerStatusId IN(2, 3)),\r\n" + 
					"TimeExhausted=(SELECT SUM(TimeTaken) FROM ActivityTestLine WHERE ActivityId=t.ActivityId),\r\n" + 
					"ExamEndTime=NOW()\r\n" + 
					"WHERE ActivityId = ?";
			appJdbcTemplate.update(updateSql, activityId);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Some error occured while saving the video:" + e.getMessage());
			throw new CustomException("Error while saving quiz questions:" + e.getMessage());
		}
		return uniqueId;
	}

	private Integer getAnswerStatus(Integer mcqId, String selectedAnswer) {
		// If not attempted
		if (selectedAnswer.isEmpty()) {
			return 3;
		}
		String answer = (String) appJdbcTemplate.queryForObject("SELECT Answer FROM `Mcq` WHERE McqId = ?",
				new Object[] { mcqId }, String.class);
		// Attempted with correct answer
		if (answer.equals(selectedAnswer)) {
			return 1;
		}
		// Wrong Answer
		return 2;
	}
	
	
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
			
			String query = "SELECT McqId, Question, QuestionDesc, QuestionImg, Solution, DifficultyLevel, QuestionOptionsJson, Answer, IsMultiChoice "
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
				item.setIsMultiChoice(result.getInt("IsMultiChoice") == 1 ? true : false);
				quizTestDTOList.add(item);
				return quizTestDTOList;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			throw new CustomException("Error while fetaching quiz questions:" + e.getMessage());
		}
		return quizTestDTOList;
	}

	@Override
	public List<ApperedTestListDTO> getApperedTestList(Integer userId) {
		List<ApperedTestListDTO> testList = new ArrayList<>();
		try {

			String query = "SELECT a.ActivityId, a.LessonId, a.UserId, a.UniqueId, a.CreationDate, a.TotalQuestion, s.SubjectName FROM ActivityTest a \r\n"
					+ "INNER JOIN Lesson l ON(a.LessonId = l.LessonId) INNER JOIN Unit u ON(l.UnitId= u.UnitId) INNER JOIN Subject s ON(u.SubjectId= s.SubjectId)\r\n"
					+ "WHERE UserId=? ORDER BY ActivityId DESC LIMIT 10";

			appJdbcTemplate.query(query, new Object[] { userId, }, (result, rowNum) -> {
				ApperedTestListDTO item = new ApperedTestListDTO();
				item.setUniqueId(result.getString("UniqueId"));
				item.setSubjectName(result.getString("SubjectName"));
				item.setTotalQuestion(result.getInt("TotalQuestion"));
				item.setCreationDate(result.getString("CreationDate"));
				testList.add(item);
				return testList;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			throw new CustomException("Error while fetaching appered test:" + e.getMessage());
		}
		return testList;
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

			String query = "SELECT McqId, Question, QuestionDesc, QuestionImg, QuestionOptionsJson, IsMultiChoice "
					+ " FROM Mcq WHERE LessonId=? AND DifficultyLevel=? ORDER BY RAND() LIMIT ?";
			appJdbcTemplate.query(query, new Object[] { lessonId, questionLevel, limit }, (result, rowNum) -> {
				QuizQuestionDTO item = new QuizQuestionDTO();
				item.setMcqId(result.getString("McqId"));
				item.setQuestion(result.getString("Question"));
				item.setQuestionDesc(result.getString("QuestionDesc"));
				item.setQuestionImg(result.getString("QuestionImg"));				
				item.setOptionList(gson.fromJson(result.getString("QuestionOptionsJson"), QuestionOptionsDTO[].class));
				item.setIsMultiChoice(result.getInt("IsMultiChoice") == 1 ? true : false);
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

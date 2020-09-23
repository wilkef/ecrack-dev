package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
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

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
@Repository
@Transactional
public class ExamDaoImpl implements ExamDao{

	
	public static final Logger LOG = Logger.getLogger(ValidationDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	
	@Override
	public List<QuizTestDTO> getScheduledTest( Integer gradeId) {


		List<QuizTestDTO> questionTestDTOList=new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.GET_SCHLD_TEST)
					.returningResultSet("ResultSet",
							BeanPropertyRowMapper.newInstance(QuizTestDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(gradeId);
			questionTestDTOList= (List<QuizTestDTO>) execute.get("ResultSet");
			if(!questionTestDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return questionTestDTOList;	
	
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<QuizQuestionDTO> getQuizQuestions( Integer lessonId,  Integer noOfQuestion, Integer questionLevel) {
		List<QuizQuestionDTO> quizTestDTOList=new ArrayList<>();
		try {
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_lessonId", lessonId).addValue("p_qLevel", questionLevel).addValue("p_noOfQuestions", noOfQuestion);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.GET_QUIZ_QSTN)
					.returningResultSet("ResultSet",
							BeanPropertyRowMapper.newInstance(QuizQuestionDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(in);
			quizTestDTOList= (List<QuizQuestionDTO>) execute.get("ResultSet");
			if(!quizTestDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return quizTestDTOList;	
	}


	@Override
	public List<QuizQuestionDTO> getQuestions( Integer lessonId,  Integer noOfQuestion,Integer questionLevel) {
		List<QuizQuestionDTO> quizTestDTOList=new ArrayList<>();
		try {
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_lessonId", lessonId).addValue("p_qLevel", questionLevel).addValue("p_noOfQuestion", noOfQuestion);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.GET_QUESTION)
					.returningResultSet("ResultSet",
							BeanPropertyRowMapper.newInstance(QuizQuestionDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(in);
			quizTestDTOList= (List<QuizQuestionDTO>) execute.get("ResultSet");
			if(!quizTestDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return quizTestDTOList;	
	}


	@Override
	public List<TestResultDTO> getStudentResultSummary(@Valid Integer testId) {
		List<TestResultDTO> testResultDTOList=new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.STUDENT_RESULT_SUMRY)
					.returningResultSet("ResultSet",
							BeanPropertyRowMapper.newInstance(TestResultDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(testId);
			testResultDTOList= (List<TestResultDTO>) execute.get("ResultSet");
			if(!testResultDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return testResultDTOList;	
	}


	@Override
	public Integer saveStudentResult(String result) {
		List<TestResultDTO> testResultDTOList=new ArrayList<>();
		Integer returnVal=0;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.SAVE_STUDENT_RESULT);
					

			Map<String, Object> execute = simpleJdbcCall.execute(result);
			returnVal= (Integer) execute.get("#update-count-1");
			if(!testResultDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return returnVal;	
	}

	
	
	
	

}

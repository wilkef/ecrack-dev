/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */

package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * The Class ExamController.
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ExamController.class.getName());
	
	/** The exam dao. */
	@Autowired 
	private ExamDao examDao;
	
	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	/**
	 * Scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the response entity
	 */
	@GetMapping(value = "/scheduledTest/{gradeId}")
	public ResponseEntity<Object> scheduledTest(@Valid @PathVariable Integer gradeId ){
		LOG.info("START-Inside scheduledTest");
		LOG.log(Level.INFO, () -> " scheduledTest Inputs gradeId: " + gradeId); 
		ResponseEntity<Object> response=null;
		List<QuizTestDTO> questionTestDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			questionTestDTOList = examDao.getScheduledTest(gradeId);
			if(!questionTestDTOList.isEmpty()) {
				response = new ResponseEntity<>(questionTestDTOList,HttpStatus.OK);
			}
			else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside scheduledTest");
		return  response;
	}


	/**
	 * Gets the quiz questions.
	 *
	 * @param lessonId the lesson id
	 * @param noOfQuestion the no of question
	 * @param questionLevel the question level
	 * @return the quiz questions
	 */
	@GetMapping(value = "quizQuestions/{lessonId}/{noOfQuestion}/{questionLevel}")
	public ResponseEntity<Object> getQuizQuestions(@Valid @PathVariable Integer lessonId ,@Valid @PathVariable Integer noOfQuestion ,@Valid @PathVariable Integer questionLevel ){
		LOG.info("START-Inside getQuizQuestions");
		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs noOfQuestion: " + lessonId); 
		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs noOfQuestion: " + noOfQuestion); 
		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs questionLevel: " + questionLevel); 
		ResponseEntity<Object> response=null;
		List<QuizQuestionDTO> questionTestDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			questionTestDTOList = examDao.getQuizQuestions(lessonId,noOfQuestion,questionLevel);
			if(!questionTestDTOList.isEmpty()) {
				response = new ResponseEntity<>(questionTestDTOList,HttpStatus.OK);
			}
			else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getQuizQuestions");
		return  response;
	}


	/**
	 * Gets the questions.
	 *
	 * @param lessonId the lesson id
	 * @param noOfQuestion the no of question
	 * @param questionLevel the question level
	 * @return the questions
	 */
	@GetMapping(value = "questions/{lessonId}/{noOfQuestion}/{questionLevel}")
	public ResponseEntity<Object> getQuestions(@Valid @PathVariable Integer lessonId ,@Valid @PathVariable Integer noOfQuestion,@Valid @PathVariable Integer questionLevel  ){
		LOG.info("START-Inside getQuestions");
		LOG.log(Level.INFO, () -> " getQuestions Inputs noOfQuestion: " + lessonId); 
		LOG.log(Level.INFO, () -> " getQuestions Inputs noOfQuestion: " + noOfQuestion); 
		LOG.log(Level.INFO, () -> " getQuestions Inputs questionLevel: " + questionLevel); 
		ResponseEntity<Object> response=null;
		List<QuizQuestionDTO> questionTestDTOList=new ArrayList<>();
		try {
			questionTestDTOList = examDao.getQuestions(lessonId,noOfQuestion,questionLevel);
			if(!questionTestDTOList.isEmpty()) {
				response = new ResponseEntity<>(questionTestDTOList,HttpStatus.OK);
			}
			else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getQuestions");
		return  response;
	}


	/**
	 * Gets the student result summary.
	 *
	 * @param testId the test id
	 * @return the student result summary
	 */
	@GetMapping(value = "studentResultSummary/{testId}")
	public ResponseEntity<Object> getStudentResultSummary(@Valid @PathVariable Integer testId){
		LOG.info("START-Inside getStudentResultSummary");
		LOG.log(Level.INFO, () -> " getStudentResultSummary Inputs testId: " + testId); 
		ResponseEntity<Object> response=null;
		List<TestResultDTO> testResultDTOList=new ArrayList<>();
		try {
			testResultDTOList = examDao.getStudentResultSummary(testId);
			if(!testResultDTOList.isEmpty()) {
				response = new ResponseEntity<>(testResultDTOList,HttpStatus.OK);
			}
			else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return  response;
	}



	/**
	 * Save student result.
	 *
	 * @param result the result
	 * @return the response entity
	 */
	@PostMapping(value = "saveStudentResult")
	public ResponseEntity<Object> saveStudentResult(@Valid @RequestBody String result){
		LOG.info("START-Inside getStudentResultSummary");
		LOG.log(Level.INFO, () -> " saveStudentResult Inputs result: " + result); 
		ResponseEntity<Object> response=null;
		try {
			Integer count = examDao.saveStudentResult(result);
			if(count>0) {
				response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
				        .body(serviceOutput.responseOutput("isSuccess", true));			}
			else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return  response;
	}
}

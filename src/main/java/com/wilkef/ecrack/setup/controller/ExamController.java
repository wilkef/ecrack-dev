package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;
@RestController
@RequestMapping("/api.ecrack/api/exam")
public class ExamController {
	public static final Logger LOG = Logger.getLogger(ExamController.class.getName());


	
	@Autowired 
	private ExamDao examDao;
	
	


	@Autowired
	private ServiceOutputTransformer serviceOutput;


	@GetMapping(value = "/scheduledTest/{gradeId}")
	public ResponseEntity<Object> scheduledTest(@Valid @PathVariable Integer gradeId ){
		LOG.info("START-Inside scheduledTest");
		ResponseEntity<Object> response=null;
		List<QuizTestDTO> questionTestDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			questionTestDTOList = examDao.getScheduledTest(gradeId);
			if(!questionTestDTOList.isEmpty()) {
				//response = new ResponseEntity<>(serviceOutput.responseOutput("dataOutput", questionTestDTOList),HttpStatus.OK);
			}
			else {
				throw new CustomException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside scheduledTest");
		return  response;
	}
	
	
	@GetMapping(value = "quizQuestions/{lessonId}/{noOfQuestion}/{questionLevel}")
	public ResponseEntity<Object> getQuizQuestions(@Valid @PathVariable Integer lessonId ,@Valid @PathVariable Integer noOfQuestion ,@Valid @PathVariable Integer questionLevel ){
		LOG.info("START-Inside getQuizQuestions");
		ResponseEntity<Object> response=null;
		List<QuizQuestionDTO> questionTestDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			questionTestDTOList = examDao.getQuizQuestions(lessonId,noOfQuestion,questionLevel);
			if(!questionTestDTOList.isEmpty()) {
				//response = new ResponseEntity<>(serviceOutput.responseOutput("dataOutput", questionTestDTOList),HttpStatus.OK);
			}
			else {
				throw new CustomException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getQuizQuestions");
		return  response;
	}
	
	
	@GetMapping(value = "questions/{lessonId}/{noOfQuestion}/{questionLevel}")
	public ResponseEntity<Object> getQuestions(@Valid @PathVariable Integer lessonId ,@Valid @PathVariable Integer noOfQuestion,@Valid @PathVariable Integer questionLevel  ){
		LOG.info("START-Inside getQuestions");
		ResponseEntity<Object> response=null;
		List<QuizQuestionDTO> questionTestDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			questionTestDTOList = examDao.getQuestions(lessonId,noOfQuestion,questionLevel);
			if(!questionTestDTOList.isEmpty()) {
				//response = new ResponseEntity<>(serviceOutput.responseOutput("dataOutput", questionTestDTOList),HttpStatus.OK);
			}
			else {
				throw new CustomException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getQuestions");
		return  response;
	}
	
	
	@GetMapping(value = "studentResultSummary/{testId}")
	public ResponseEntity<Object> getStudentResultSummary(@Valid @PathVariable Integer testId){
		LOG.info("START-Inside getStudentResultSummary");
		ResponseEntity<Object> response=null;
		List<TestResultDTO> testResultDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			testResultDTOList = examDao.getStudentResultSummary(testId);
			if(!testResultDTOList.isEmpty()) {
				//response = new ResponseEntity<>(serviceOutput.responseOutput("dataOutput", testResultDTOList),HttpStatus.OK);
			}
			else {
				throw new CustomException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return  response;
	}
	
	
	
	@PostMapping(value = "saveStudentResult")
	public ResponseEntity<Object> saveStudentResult(@Valid @RequestBody String result){
		LOG.info("START-Inside getStudentResultSummary");
		ResponseEntity<Object> response=null;
		List<TestResultDTO> testResultDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			Integer count = examDao.saveStudentResult(result);
			if(count>0) {
			response = new ResponseEntity<>("Success",HttpStatus.OK);
			}
			else {
				throw new CustomException("No Record Found");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return  response;
	}
	
	
	

}

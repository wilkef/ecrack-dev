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

import javax.servlet.http.HttpServletRequest;
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
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ApperedTestListDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.McqTestItemDto;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.dto.TestSummaryDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.ExamService;
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

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ExamService examService;

	/**
	 * Gets the quiz questions.
	 *
	 * @param lessonId      the lesson id
	 * @param questionLevel the question level
	 * @return the quiz questions
	 */
	@GetMapping(value = "quizQuestions/{lessonId}/{questionLevel}")
	public ResponseEntity<Object> getQuizQuestions(@Valid @PathVariable Integer lessonId,
			@Valid @PathVariable Integer questionLevel) {
		LOG.info("START Controller quizQuestions");
		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs noOfQuestion: " + lessonId);
		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs questionLevel: " + questionLevel);
		ResponseEntity<Object> response = null;
		List<QuizQuestionDTO> questionTestDTOList = new ArrayList<>();
		try {
			questionTestDTOList = examDao.getQuizQuestions(lessonId, questionLevel);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, questionTestDTOList));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END Controller getQuizQuestions");
		return response;
	}

	/**
	 * Gets the questions.
	 *
	 * @param lessonId      the lesson id
	 * @param questionLevel the question level
	 * @return the questions
	 */
	@GetMapping(value = "questions/{lessonId}/{questionLevel}")
	public ResponseEntity<Object> getQuestions(@Valid @PathVariable Integer lessonId,
			@Valid @PathVariable Integer questionLevel) {
		LOG.info("START-Inside getQuestions");
		LOG.log(Level.INFO, () -> " getQuestions Inputs noOfQuestion: " + lessonId);
		LOG.log(Level.INFO, () -> " getQuestions Inputs questionLevel: " + questionLevel);
		ResponseEntity<Object> response = null;
		List<QuizQuestionDTO> questionTestDTOList = new ArrayList<>();
		try {
			questionTestDTOList = examDao.getQuestions(lessonId, questionLevel);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, questionTestDTOList));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside getQuestions");
		return response;
	}

	/*
	 * Get questions for Practice test based on Unit Id and level.
	 * 
	 * 
	 * 
	 */
	@GetMapping(value = "questionsForPracticeTest/{unitId}/{questionLevel}")
	public ResponseEntity<Object> getQuestionsForPraticeTest(@Valid @PathVariable Integer unitId,
			@Valid @PathVariable Integer questionLevel) {
		LOG.info("START-Inside getQuestions");
		LOG.log(Level.INFO, () -> " getQuestions Inputs noOfQuestion: " + unitId);
		LOG.log(Level.INFO, () -> " getQuestions Inputs questionLevel: " + questionLevel);
		ResponseEntity<Object> response = null;
		List<QuizQuestionDTO> questionTestDTOList = new ArrayList<>();
		try {
			questionTestDTOList = examDao.getQuestionsForPracticeTest(unitId, questionLevel);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, questionTestDTOList));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside getQuestions for Practice Test");
		return response;
	}

	/**
	 * Scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the response entity
	 */
	@GetMapping(value = "/getPracticeTests}")
	public ResponseEntity<Object> getPracticeTests() {
		LOG.log(Level.INFO, () -> "START Controller getPracticeTests");
		ResponseEntity<Object> response = null;
		List<QuizTestDTO> questionTestDTOList = new ArrayList<>();
		try {
			questionTestDTOList = examDao.getScheduledTest(111);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, questionTestDTOList));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.log(Level.INFO, () -> "END Controller getPracticeTests");
		return response;
	}

	/**
	 * Scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the response entity
	 */
	@GetMapping(value = "/scheduledTest/{gradeId}")
	public ResponseEntity<Object> scheduledTest(@Valid @PathVariable Integer gradeId) {
		LOG.info("START-Inside scheduledTest");
		LOG.log(Level.INFO, () -> " scheduledTest Inputs gradeId: " + gradeId);
		ResponseEntity<Object> response = null;
		List<QuizTestDTO> questionTestDTOList = new ArrayList<>();
		try {
			LOG.log(Level.INFO, () -> "Before geting  information ");
			questionTestDTOList = examDao.getScheduledTest(gradeId);
			response = new ResponseEntity<>(questionTestDTOList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside scheduledTest");
		return response;
	}

	@PostMapping(value = "/saveQuizTest/{lessonId}/{difficultyLevel}")
	public ResponseEntity<Object> saveQuizTest(@PathVariable Integer lessonId, @PathVariable Integer difficultyLevel,
			@Valid @RequestBody ArrayList<McqTestItemDto> questions) {
		LOG.info("START-Inside saveQuizTest");
		LOG.log(Level.INFO, () -> " saveQuizTest Inputs: " + lessonId);
		LOG.log(Level.INFO, () -> " saveQuizTest Inputs: " + difficultyLevel);
		LOG.log(Level.INFO, () -> " saveQuizTest Inputs: " + questions);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(request.getHeader(WilkefConstants.AUTH_HEADER));

		ResponseEntity<Object> response = null;
		try {
			String uniqueId = examDao.saveQuizTest(loggedinUserInfo.getUserId(), lessonId, difficultyLevel, questions);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, uniqueId));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside saveQuizTest");
		return response;
	}

	@GetMapping(value = "testSummary/{uniqueId}")
	public ResponseEntity<Object> testSummary(@PathVariable String uniqueId) {
		LOG.info("START-Inside testSummary");
		ResponseEntity<Object> response = null;
		try {
			TestSummaryDTO testSummary = examDao.getTestResultSummary(uniqueId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, testSummary));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside testSummary");
		return response;
	}

	@GetMapping(value = "/getApperedTestList")
	public ResponseEntity<Object> getApperedTestList() {
		LOG.info("START-Inside getApperedTestList");
		ResponseEntity<Object> response = null;
		List<ApperedTestListDTO> testList = new ArrayList<>();
		try {
			LoggedinUserInfo loggedinUserInfo = validationDao
					.getLoggedinUserInfo(request.getHeader(WilkefConstants.AUTH_HEADER));
			testList = examDao.getApperedTestList(loggedinUserInfo.getUserId());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, testList));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.info("END-Inside getApperedTestList");
		return response;
	}

//	/**
//	 * Gets the quiz questions.
//	 *
//	 * @param lessonId      the lesson id
//	 * @param noOfQuestion  the no of question
//	 * @param questionLevel the question level
//	 * @return the quiz questions
//	 */
//	@GetMapping(value = "quizQuestions/{lessonId}/{noOfQuestion}/{questionLevel}")
//	public ResponseEntity<Object> getQuizQuestions(@Valid @PathVariable Integer lessonId,
//			@Valid @PathVariable Integer noOfQuestion, @Valid @PathVariable Integer questionLevel) {
//		LOG.info("START-Inside getQuizQuestions");
//		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs noOfQuestion: " + lessonId);
//		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs noOfQuestion: " + noOfQuestion);
//		LOG.log(Level.INFO, () -> " getQuizQuestions Inputs questionLevel: " + questionLevel);
//		ResponseEntity<Object> response = null;
//		List<QuizQuestionDTO> questionTestDTOList = new ArrayList<>();
//		try {
//			LOG.log(Level.INFO, () -> "Before geting  information ");
//			questionTestDTOList = examDao.getQuizQuestions(lessonId, noOfQuestion, questionLevel);
//			response = new ResponseEntity<>(questionTestDTOList, HttpStatus.OK);
//		} catch (Exception e) {
//			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
//			return new CustomExceptionHandler().handleAllExceptions(e);
//		}
//		LOG.info("END-Inside getQuizQuestions");
//		return response;
//	}

	/**
	 * Gets the student result summary.
	 *
	 * @param testId the test id
	 * @return the student result summary
	 */
	@GetMapping(value = "studentResultSummary/{testId}")
	public ResponseEntity<Object> getStudentResultSummary(@Valid @PathVariable Integer testId) {
		LOG.info("START-Inside getStudentResultSummary");
		LOG.log(Level.INFO, () -> " getStudentResultSummary Inputs testId: " + testId);
		ResponseEntity<Object> response = null;
		List<TestResultDTO> testResultDTOList = new ArrayList<>();
		try {
			testResultDTOList = examDao.getStudentResultSummary(testId);
			response = new ResponseEntity<>(testResultDTOList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return response;
	}

	/**
	 * Save student result.
	 *
	 * @param result the result
	 * @return the response entity
	 */
	@PostMapping(value = "saveStudentResult")
	public ResponseEntity<Object> saveStudentResult(@Valid @RequestBody String result) {
		LOG.info("START-Inside getStudentResultSummary");
		LOG.log(Level.INFO, () -> " saveStudentResult Inputs result: " + result);
		ResponseEntity<Object> response = null;
		try {
			Integer count = examDao.saveStudentResult(result);
			if (count > 0) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getStudentResultSummary");
		return response;
	}

	@PostMapping(value = "schedueldTest/fetchQuestions/{testHeaderId}")
	public ResponseEntity<Object> getQuestions(@Valid @PathVariable Integer testHeaderId) {
		LOG.info("fetching data for scheduled test.");
		ResponseEntity<Object> response = null;
		List<QuizQuestionDTO> questionsForScheduledTest = new ArrayList<>();
		try {
			questionsForScheduledTest = examService.getScheduledTestQuestions(testHeaderId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, questionsForScheduledTest));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		return response;
	}
}

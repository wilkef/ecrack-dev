/**
 * 
 * @author Satya This class is created to contain all the information
 */
package com.wilkef.ecrack.setup.EcrackSetup;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wilkef.ecrack.setup.controller.AnswerStatusController;
import com.wilkef.ecrack.setup.controller.ExamController;
import com.wilkef.ecrack.setup.controller.TestTypeListController;
import com.wilkef.ecrack.setup.controller.ValidationController;
import com.wilkef.ecrack.setup.dao.AnswerStatusDao;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dao.TestTypeListDao;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.dto.QuizQuestionDTO;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.dto.TestResultDTO;
import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.ErrorResponse;


/**
 * The Class EcrackSetupApplicationTests.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EcrackSetupApplicationTests {

	@Autowired
	private ValidationController validationController;

	@MockBean
	private ValidationDao validationDao;

	@Test
	public void testValidEmail() {
		String input="{\"EmailId\":\"rajni88@gmail.com\"}";
		List<ValidationDTO> validList=new ArrayList<>();
		ValidationDTO obj=new ValidationDTO();
		obj.setP_isValidEmailId(1);
		validList.add(obj);
		Mockito.when(validationDao.validateEmail(input)).thenReturn(validList);
		assertEquals(0, ((ErrorResponse) validationController.validateEmailId(input).getBody()));
	}

	/** The answer status controller. */
	@Autowired
	private AnswerStatusController answerStatusController;

	/** The answer status dao. */
	@MockBean
	private AnswerStatusDao answerStatusDao;

	/**
	 * Test answer test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAnswerTest() {

		List<AnswerStatusDataDTO> list =new ArrayList<>();
		AnswerStatusDataDTO obj=new AnswerStatusDataDTO();
		obj.setAnswerStatusId(1);
		obj.setStatus("PASS");
		list.add(obj);
		Mockito.when(answerStatusDao.findAllAnswerStatus()).thenReturn(list);
		assertEquals(1, ((List<AnswerStatusDataDTO>)answerStatusController.findAllTestTypeList().getBody()).size());
	}

	/**
	 * This Test Method to Identify TestType TestCase Method
	 */

	/** The TestType status controller. */
	@Autowired
	private TestTypeListController testTypeListController;

	/** The TestType status dao. */
	@MockBean
	private TestTypeListDao testTypeDao;

	/**
	 * Test TestType test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testTypeTest() {

		List<TestTypeListDataDTO> testTypeList =new ArrayList<>();

		TestTypeListDataDTO testType =new TestTypeListDataDTO();
		testType.setIsActive(1);
		testType.setNoOfQuestion(20);
		testType.setTestTime("12");
		testType.setTestType("Unit Test");
		testType.setTestTypeId(1);

		testTypeList.add(testType);

		Mockito.when(testTypeDao.findAllTestTypeList()).thenReturn(testTypeList);
		assertEquals(1, ((List<TestTypeListDataDTO>)testTypeListController.findAllTestTypeList().getBody()).size());
	}

	/**
	 * This Test Method to Identify ScheduledTest TestCase Method
	 */

	/** The ScheduledTest status controller. */
	@Autowired
	private ExamController examController;

	/** The ScheduledTest status dao. */
	@MockBean
	private ExamDao examDao;

	/**
	 * Test ScheduledTest test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void scheduledTest() {
		List<QuizTestDTO> quizTestList=new ArrayList<QuizTestDTO>();

		QuizTestDTO quizTest = new QuizTestDTO();

		quizTest.setDifficultyCode("");
		quizTest.setDifficultyLevel("");
		quizTest.setEndDateTime("");
		quizTest.setIsActive("1");
		quizTest.setIsNegativeMarking("");
		quizTest.setIsScheduled("");
		quizTest.setNegativeMark("");
		quizTest.setScheduledDateTime("");
		quizTest.setTestId(1);
		quizTest.setTestName("");
		quizTest.setTotalMark(100);
		quizTest.setTotalQuestion(50);

		quizTestList.add(quizTest);
		int gradeId=1;

		Mockito.when(examDao.getScheduledTest(gradeId)).thenReturn(quizTestList);
		assertEquals(1, ((List<QuizTestDTO>)examController.scheduledTest(gradeId).getBody()).size());
	}


	/**
	 * This Test Method to Identify quizQuestions TestCase Method
	 */

	/**
	 * Test quizQuestions test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void quizQuestionsTest() {
		List<QuizQuestionDTO> quizQuestionList = new ArrayList<>();
		QuizQuestionDTO quizQuestion = new QuizQuestionDTO();
		quizQuestion.setDifficultyCode("Easy");
		quizQuestion.setLessonId("1");
		quizQuestion.setLessonName("");
		quizQuestion.setMcqId("1");
		quizQuestion.setOptionList("satya");
		quizQuestion.setQuestion("what is Exception");
		quizQuestion.setQuestionDesc("i want answer");
		quizQuestion.setQuestionImg("satya");
		quizQuestion.setSolution("ok");

		quizQuestionList.add(quizQuestion);
		Integer lessonId =1;
		Integer noOfQuestion =10;
		Integer questionLevel =2;
		Mockito.when(examDao.getQuizQuestions(lessonId, noOfQuestion, questionLevel)).thenReturn(quizQuestionList);
		assertEquals(1, ((List<QuizQuestionDTO>)examController.getQuizQuestions(lessonId, noOfQuestion, questionLevel).getBody()).size());
	}

	/**
	 * This Test Method to Identify getQuestions TestCase Method
	 */

	/**
	 * Test getQuestions test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getQuestionsTest() {
		List<QuizQuestionDTO> getQuestionList = new ArrayList<>();
		QuizQuestionDTO getQuestion = new QuizQuestionDTO();
		getQuestion.setDifficultyCode("Easy");
		getQuestion.setLessonId("1");
		getQuestion.setLessonName("Real Numbers  (15 Periods)");
		getQuestion.setMcqId("1");
		getQuestion.setOptionList("1");
		getQuestion.setQuestion("what is Exception");
		getQuestion.setQuestionDesc("Details about question");
		getQuestion.setQuestionImg("No");
		getQuestion.setSolution("ok");

		getQuestionList.add(getQuestion);
		Integer lessonId =1;
		Integer noOfQuestion =10;
		Integer questionLevel =2;

		Mockito.when(examDao.getQuestions(lessonId, noOfQuestion, questionLevel)).thenReturn(getQuestionList);
		assertEquals(1, ((List<QuizQuestionDTO>)examController.getQuestions(lessonId, noOfQuestion, questionLevel).getBody()).size());
	}


	/**
	 * This Test Method to Identify StudentResultSummary TestCase Method
	 */

	/**
	 * Test StudentResultSummary test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getStudentResultSummaryTest() {

		List<TestResultDTO> testResultList = new ArrayList<>();

		TestResultDTO testResult = new TestResultDTO();

		testResult.setAnswerStatusId("");
		testResult.setAttendedQuestion("80");
		testResult.setMarkSecured("1000");
		testResult.setQuestionId("");
		testResult.setRightQuestion("70");
		testResult.setSkippedQuestion("10");
		testResult.setTimeTaken("");
		testResult.setTotalMark("100");
		testResult.setTotalQuestion("500");
		testResult.setV_activityId("");
		testResult.setV_userid("");
		testResult.setWrongQuestion("10");

		testResultList.add(testResult);
		Integer testId =1;

		Mockito.when(examDao.getStudentResultSummary(testId)).thenReturn(testResultList);
		assertEquals(1, ((List<TestResultDTO>)examController.getStudentResultSummary(testId).getBody()).size());
	}


}

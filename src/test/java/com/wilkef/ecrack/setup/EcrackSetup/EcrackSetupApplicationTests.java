/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *      
 *
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
import com.wilkef.ecrack.setup.controller.ValidationController;
import com.wilkef.ecrack.setup.dao.AnswerStatusDao;
import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.ErrorResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class EcrackSetupApplicationTests.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EcrackSetupApplicationTests {
	
	/** The answer status controller. */
	@Autowired
	private AnswerStatusController answerStatusController;
	
	/** The answer status dao. */
	@MockBean
	private AnswerStatusDao answerStatusDao;
	
	
	@Autowired
	private ValidationController validationController;
	
	
	@MockBean
	private ValidationDao validationDao;
	/**
	 * Test answer test.
	 */
	@SuppressWarnings("unchecked")
	/*
	 * //@Test public void testAnswerTest() {
	 * 
	 * List<AnswerStatusDataDTO> list =new ArrayList<>(); AnswerStatusDataDTO
	 * obj=new AnswerStatusDataDTO(); obj.setAnswerStatusId(1);
	 * obj.setStatus("PASS"); list.add(obj);
	 * Mockito.when(answerStatusDao.findAllAnswerStatus()).thenReturn(list);
	 * assertEquals(1,
	 * ((List<AnswerStatusDataDTO>)answerStatusController.findAllTestTypeList().
	 * getBody()).size());
	 * 
	 * 
	 * 
	 * }
	 */
	
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
	

}

/**
 * 
 */
package com.wilkef.ecrack.setup.EcrackSetup;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.wilkef.ecrack.setup.dao.impl.AnswerStatusDaoImpl;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.service.impl.AnswerStatusServiceImpl;

/**
 * @author Satya
 * Sep 23, 2020
 */

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AnswerStatusDaoTest {	
	@Mock
	AnswerStatusDaoImpl answerStatusDao;

	@InjectMocks
	AnswerStatusServiceImpl  answerStatusService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAnswerStatus() {
		List<AnswerStatusDataDTO> listOfAnswer = new ArrayList<>();
		
		AnswerStatusDataDTO answerStatus1 = new AnswerStatusDataDTO();
		answerStatus1.setAnswerStatusId(1);
		answerStatus1.setStatus("PASS");
		
		AnswerStatusDataDTO answerStatus = new AnswerStatusDataDTO();
		answerStatus.setAnswerStatusId(2);
		answerStatus.setStatus("FAIL");

		listOfAnswer.add(answerStatus);
		listOfAnswer.add(answerStatus1);
		
		when(answerStatusDao.findAllAnswerStatus()).thenReturn(listOfAnswer);
		List<AnswerStatusDataDTO> findAllAnswerStatus = answerStatusService.findAllAnswerStatus();
		assertNotNull(findAllAnswerStatus);
	}
}

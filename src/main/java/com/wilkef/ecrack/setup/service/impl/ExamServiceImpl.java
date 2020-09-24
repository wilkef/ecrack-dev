package com.wilkef.ecrack.setup.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.service.ExamService;


/**
 * The Class ExamServiceImpl.
 */
@Service
public class ExamServiceImpl implements ExamService{

	
	/** The exam dao. */
	@Autowired 
	private ExamDao examDao;
	
	/**
	 * Gets the scheduled test.
	 *
	 * @param gradeId the grade id
	 * @return the scheduled test
	 */
	@Override
	public List<QuizTestDTO> getScheduledTest(@Valid Integer gradeId) {
		return examDao.getScheduledTest(gradeId);
		
	}

	
}

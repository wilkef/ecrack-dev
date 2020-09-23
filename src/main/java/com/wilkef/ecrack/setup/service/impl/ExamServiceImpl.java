package com.wilkef.ecrack.setup.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.ExamDao;
import com.wilkef.ecrack.setup.dto.QuizTestDTO;
import com.wilkef.ecrack.setup.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService{

	
	@Autowired 
	private ExamDao examDao;
	@Override
	public List<QuizTestDTO> getScheduledTest(@Valid Integer gradeId) {
		return examDao.getScheduledTest(gradeId);
		
	}

	
}

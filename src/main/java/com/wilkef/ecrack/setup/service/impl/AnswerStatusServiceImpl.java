/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.AnswerStatusDao;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.service.AnswerStatusService;

/**
 * This Class is Used to Execute Answer Status Service Class Implementation
 * 
 * @author Satya
 *Sep 20, 2020
 */

@Service
public class AnswerStatusServiceImpl implements AnswerStatusService{

	@SuppressWarnings("unused")
	private AnswerStatusDao answerStatus;
	
	public void setAnswerStatusDao(AnswerStatusDao answerStatus) {
		this.answerStatus = answerStatus;
	}
	
	public static final Logger LOG = Logger.getLogger(AnswerStatusServiceImpl.class.getName());
	
	@Autowired
	private AnswerStatusDao answerStatusDao;

	@Override
	public List<AnswerStatusDataDTO> findAllAnswerStatus() {
		List<AnswerStatusDataDTO> findAllAnswerStatus = null;
		try {
			findAllAnswerStatus = answerStatusDao.findAllAnswerStatus();
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With Answer Status : " + exception.getMessage());
		}
		return findAllAnswerStatus;
	}
}

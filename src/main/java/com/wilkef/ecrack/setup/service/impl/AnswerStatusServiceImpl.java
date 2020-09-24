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
 * This Class is Used to Execute Answer Status Service Class Implementation.
 *
 * @author Satya
 * Sep 20, 2020
 */

@Service
public class AnswerStatusServiceImpl implements AnswerStatusService{

	/** The answer status. */
	@SuppressWarnings("unused")
	private AnswerStatusDao answerStatus;
	
	/**
	 * Sets the answer status dao.
	 *
	 * @param answerStatus the new answer status dao
	 */
	public void setAnswerStatusDao(AnswerStatusDao answerStatus) {
		this.answerStatus = answerStatus;
	}
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(AnswerStatusServiceImpl.class.getName());
	
	/** The answer status dao. */
	@Autowired
	private AnswerStatusDao answerStatusDao;

	/**
	 * Find all answer status.
	 *
	 * @return the list
	 */
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

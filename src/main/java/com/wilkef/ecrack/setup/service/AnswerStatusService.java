/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;


/**
 * The Interface AnswerStatusService.
 *
 * @author Satya
 * Sep 20, 2020
 */
public interface AnswerStatusService {
	
	/**
	 * Find all answer status.
	 *
	 * @return the list
	 */
	public List<AnswerStatusDataDTO> findAllAnswerStatus();
}

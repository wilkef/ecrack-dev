/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;

/**
 * @author Satya
 *Sep 20, 2020
 */
public interface AnswerStatusService {
	public List<AnswerStatusDataDTO> findAllAnswerStatus();
}

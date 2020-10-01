/**
 * This Class is Used to Execute AnswerStatus Execution
 * 
 * @author Satya
 * Sep 21, 2020
 */

package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.AnswerStatusService;


/**
 * The Class AnswerStatusController.
 */
@RestController
@RequestMapping("/exam")
public class AnswerStatusController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(AnswerStatusController.class.getName());

	/** The answer status service. */
	@Autowired
	private AnswerStatusService answerStatusService;

	/**
	 * Find all test type list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/answerStatus")
	public ResponseEntity<Object> findAllTestTypeList(){
		LOG.info("START-Inside findAllTestTypeList ");
		LOG.log(Level.INFO, () -> "No updateProfile Inputs: "); 
		ResponseEntity<Object> response=null;
		List<AnswerStatusDataDTO> findAllAnswerStatus = null;
		try {
			findAllAnswerStatus = answerStatusService.findAllAnswerStatus();
			if (findAllAnswerStatus!=null) {
				response = new ResponseEntity<>(findAllAnswerStatus,HttpStatus.OK);
			}else {
				LOG.log(Level.INFO, () -> ErrorConstants.ANSWER_STATUS_FAILED );
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);		
		}
		LOG.info("END-Inside findAllTestTypeList ");
		return response;
	}
}

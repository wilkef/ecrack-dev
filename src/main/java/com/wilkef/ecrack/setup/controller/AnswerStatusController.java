/**
 * 
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

import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.exception.RecordNotFoundException;
import com.wilkef.ecrack.setup.service.AnswerStatusService;

/**
 * This Class is Used to Execute AnswerStatus Execution
 * 
 * @author Satya
 *Sep 21, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/exam")
public class AnswerStatusController {
	private static final Logger LOG = Logger.getLogger(AnswerStatusController.class.getName());

	@Autowired
	private AnswerStatusService answerStatusService;

	@GetMapping("/answerStatus")
	public ResponseEntity<Object> findAllTestTypeList(){
		LOG.info("Inside answerStatus Controller ");
		ResponseEntity<Object> response=null;
		List<AnswerStatusDataDTO> findAllAnswerStatus = null;
		try {
			LOG.log(Level.INFO, () -> "Before Fetching answerStatus : " );
			findAllAnswerStatus = answerStatusService.findAllAnswerStatus();
			if (findAllAnswerStatus!=null) {
				response = new ResponseEntity<>(findAllAnswerStatus,HttpStatus.OK);
			}else {
				LOG.log(Level.INFO, () -> "answerStatus is Not There in DB " );
				throw new RecordNotFoundException("No Record Found");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while Fetching answerStatus Record : " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);		
		}
		return response;
	}
}

/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.AskYourDoubtDao;
import com.wilkef.ecrack.setup.dto.AskYourDoubt;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * @author Satya
 * Nov 5, 2020
 */

@RestController
@RequestMapping("/user")
public class AskYourDoubtController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(AskYourDoubtController.class.getName());

	/** The service. */
	@Autowired
	public AskYourDoubtDao dao; 

	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@PostMapping(value = "/AskYourDoubt")
	public ResponseEntity<Object> saveAskYourDoubt(@RequestBody AskYourDoubt askYourDoubt){
		ResponseEntity<Object> response=null;
		try {
			LOG.log(Level.INFO, () -> "Inside AskYourDoubt Controller" );
			Integer saveDoubt = dao.saveDoubt(askYourDoubt);
			if (saveDoubt!=null) {
				response= ResponseEntity.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			}else {
				response= ResponseEntity.status(HttpStatus.OK)	
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
}

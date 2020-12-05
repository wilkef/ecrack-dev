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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.InquiryDao;
import com.wilkef.ecrack.setup.dto.InquiryDataDto;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/**
 * @author Satya
 *Dec 2, 2020
 */

@Controller
@RequestMapping("/user")
public class InquiryController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(InquiryController.class.getName());

	/** The service. */
	@Autowired
	public InquiryDao inquiryDao;

	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@PostMapping(value = "/Inquiry")
	public ResponseEntity<Object> saveInquiry(@RequestBody InquiryDataDto inquiry) {
		ResponseEntity<Object> response = null;
		try {
			LOG.log(Level.INFO, () -> "Inside inquiry Controller");
			Integer saveInquiry = inquiryDao.saveInquiry(inquiry);
			if (saveInquiry != null) {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, true));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.responseOutput(ErrorConstants.IS_SUCCESS, false));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
}

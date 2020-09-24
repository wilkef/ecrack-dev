/**
 * This Class is Identify to execute PracticeTestInfo Controller
 * 
 * @author Satya
 *Sep 21, 2020
 */

package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.PracticeTestInfoService;


/**
 * The Class PracticeTestInfoController.
 */
@RestController
@RequestMapping("/exam")
public class PracticeTestInfoController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(PracticeTestInfoController.class.getName());

	/** The practice test service. */
	@Autowired
	private PracticeTestInfoService practiceTestService;

	/**
	 * Gets the practice test info.
	 *
	 * @param praticeTest the pratice test
	 * @return the practice test info
	 */
	@PostMapping(value = "/practiceTestInfo")
	public ResponseEntity<Object> getPracticeTestInfo(@RequestBody String praticeTest){
		LOG.info("START-Inside getPracticeTestInfo ");
		LOG.log(Level.INFO, () -> " getPracticeTestInfo Inputs unitId praticeTest: "+praticeTest); 
		JSONObject obj = new JSONObject(praticeTest);
		ResponseEntity<Object> response=null;
		List<PracticeTestInfoDTO> practiceTestInfoDto = null;
		try {
			 practiceTestInfoDto = practiceTestService.findPracticeTestInfo(obj);
			if (practiceTestInfoDto != null) {
				response=new ResponseEntity<>(practiceTestInfoDto,HttpStatus.OK);
			}
			else {
				LOG.log(Level.INFO, () -> "PracticeTestInfo Record is Not Available in DB " );
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside getPracticeTestInfo ");
		return response;
	}
}

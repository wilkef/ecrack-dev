/**
 * 
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

import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.exception.RecordNotFoundException;
import com.wilkef.ecrack.setup.service.PracticeTestInfoService;

/**
 * This Class is Identify to execute PracticeTestInfo Controller
 * 
 * @author Satya
 *Sep 21, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/exam")
public class PracticeTestInfoController {

	private static final Logger LOG = Logger.getLogger(PracticeTestInfoController.class.getName());

	@Autowired
	private PracticeTestInfoService practiceTestService;

	@PostMapping(value = "/practiceTestInfo")
	public ResponseEntity<Object> getPracticeTestInfo(@RequestBody String praticeTest){
		JSONObject obj = new JSONObject(praticeTest);
		LOG.info("Inside PracticeTestInfo Controller ");
		ResponseEntity<Object> response=null;
		List<PracticeTestInfoDTO> practiceTestInfoDto = null;
		try {
			LOG.log(Level.INFO, () -> "Before Registration : " );
			 practiceTestInfoDto = practiceTestService.findPracticeTestInfo(obj);
			if (practiceTestInfoDto != null) {
				response=new ResponseEntity<>(practiceTestInfoDto,HttpStatus.OK);
			}
			else {
				LOG.log(Level.INFO, () -> "PracticeTestInfo Record is Not Available in DB " );
				throw new RecordNotFoundException("No Record Found ");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching PracticeTestInfo Process : " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}
}

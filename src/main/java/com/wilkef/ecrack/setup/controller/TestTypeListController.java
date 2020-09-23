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

import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.exception.RecordNotFoundException;
import com.wilkef.ecrack.setup.service.TestTypeListService;

/**
 * This Class is Used to Execute TestType Execution
 * 
 * @author Satya
 *Sep 20, 2020
 */

@RestController
@RequestMapping("/api.ecrack/api/exam/")
public class TestTypeListController {

	private static final Logger LOG = Logger.getLogger(TestTypeListController.class.getName());

	@Autowired
	private TestTypeListService typeListService;

	@GetMapping("/testTypeList")
	public ResponseEntity<Object> findAllTestTypeList(){
		LOG.info("Inside TestTypeList Controller ");
		ResponseEntity<Object> response=null;
		List<TestTypeListDataDTO> findAllTestTypeList = null;
		try {
			LOG.log(Level.INFO, () -> "Before Fetching TestTypeList : " );
			findAllTestTypeList = typeListService.findAllTestTypeList();
			if (findAllTestTypeList!=null) {
				response = new ResponseEntity<>(findAllTestTypeList,HttpStatus.OK);
			}else {
				LOG.log(Level.INFO, () -> "TestType is Not There " );
				throw new RecordNotFoundException("No Record Found");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while Fetching TestType Record : " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);		
		}
		return response;
	}
}

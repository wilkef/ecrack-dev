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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.service.LessionListService;

/**
 *  This Class is Identify to execute Lession Controller Operation
 * 
 * @author Satya
 *Sep 18, 2020
 */

@RestController
@RequestMapping("subject")
public class LessionListController {
	
	public static final Logger LOG = Logger.getLogger(LessionListController.class.getName());

	@Autowired
	private LessionListService lessionService;

	@GetMapping(value = "/lessionList/{UnitId}")
	public ResponseEntity<?> findByGradeId(@PathVariable("UnitId") Integer unitId) {

		ResponseEntity<?> response = null;
		List<LessionListDataDTO> lessionList = null;

		LOG.info("Inside find the Subject based on UnitId");
		try {
			LOG.log(Level.INFO, () -> "Before geting Subject information based on gradeId : " + unitId);
			lessionList = lessionService.findByUnitId(unitId);
			if (!lessionList.isEmpty()) {
				response = new ResponseEntity<>(lessionList, HttpStatus.OK);
				return response;
			} else {
				response = new ResponseEntity<>("Record Not Found ", HttpStatus.OK);
				return response;
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching the information based on gradeId : " + e.getMessage());
		}
		return response;
	}

}

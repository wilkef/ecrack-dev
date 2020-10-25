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

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.CityListDao;
import com.wilkef.ecrack.setup.dto.CityListDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;

/**
 * @author Satya
 *Oct 25, 2020
 */

@RestController
@RequestMapping("/user")
public class CityListController {
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(CityListController.class.getName());

	/** The unit list service. */
	@Autowired
	private CityListDao cityListService;
	
	@GetMapping(value = "/cityList")	
	public ResponseEntity<Object> findByCityList() {
		LOG.info("START-Inside findByClassId");
		LOG.log(Level.INFO, () -> " findByClassId Inputs subjectId: "); 
		ResponseEntity<Object> response = null;
		List<CityListDataDTO> cityListData = null;

		LOG.info("Inside find the UnitList based on subjectId");
		try {
			LOG.log(Level.INFO, () -> "Before geting UnitList information based on subjectId : " );
			cityListData = cityListService.getCityList();
			response = new ResponseEntity<>(cityListData, HttpStatus.OK);
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside findByClassId");
		return response;
	}
}

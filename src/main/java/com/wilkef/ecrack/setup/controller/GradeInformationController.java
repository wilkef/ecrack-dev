/**
 * This class takes input grade code & board information to provide grade details & grade name
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

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.GradeInformationDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.GradeInformationService;

/**
 * @author Chinmaya.dehury
 *
 *         29-Sep-2020
 *
 */
@RestController
@RequestMapping("/grade")
public class GradeInformationController {
	public static final Logger LOG = Logger.getLogger(GradeInformationController.class.getName());

	@Autowired
	GradeInformationService gradeInfoService;

	ResponseEntity<Object> response = null;
	List<GradeInformationDTO> gradeInfoList = null;

	@GetMapping(value = "/gradeInfo/{boardId}")
	public ResponseEntity<Object> findByGradeId(@PathVariable("boardId") Integer boardId) {

		LOG.log(Level.INFO, () -> "updateProfile Inputs unitId: " + boardId);

		try {
			gradeInfoList = gradeInfoService.getGradeInformation(boardId);
			if (!gradeInfoList.isEmpty()) {
				response = new ResponseEntity<>(gradeInfoList, HttpStatus.OK);
			} else {
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		return response;
	}

}

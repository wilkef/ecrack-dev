package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.InstructorDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.SettingsDao;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
public class SettingsController {

	private static final Logger LOG = Logger.getLogger(SettingsController.class.getName());

	@Autowired
	private SettingsDao settingsService;

	@Autowired
	private ServiceOutputTransformer outputService;

	@GetMapping(value = "/getInstructors")
	public ResponseEntity<Object> getInstructors() {
		LOG.log(Level.INFO, () -> "Start getInstructors Controller");
		ResponseEntity<Object> response = null;
		try {
			List<InstructorDTO> instructorList = settingsService.getInstructors();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(outputService.apiResponse(Boolean.TRUE, instructorList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(outputService.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getInstructors Controller");
		return response;
	}

}

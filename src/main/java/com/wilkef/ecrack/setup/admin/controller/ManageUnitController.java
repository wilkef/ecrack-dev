package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.admin.dao.ManageUnitDao;
import com.wilkef.ecrack.setup.admin.dto.ManageUnitDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class ManageUnitController {
	private static final Logger LOG = Logger.getLogger(ManageBoardController.class.getName());

	@Autowired
	private ManageUnitDao unitService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@GetMapping(value = "getUnitList/{subjectId}")
	public ResponseEntity<Object> getUnitList(@PathVariable("subjectId") Integer subjectId) {
		LOG.log(Level.INFO, () -> "Start getUnitList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> unitList = unitService.getUnitList(subjectId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, unitList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getUnitList Controller");
		return response;
	}

	@PostMapping(value = "/saveUnit")
	public ResponseEntity<Object> saveUnit(@RequestBody ManageUnitDTO data) {
		LOG.log(Level.INFO, () -> "Start saveUnit");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));

		ResponseEntity<Object> response = null;
		try {
			unitService.saveUnit(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End saveUnit");
		return response;
	}

	@GetMapping(value = "/getUnitDetails/{unitId}")
	public ResponseEntity<Object> getUnitDetails(@PathVariable Integer unitId) {
		LOG.log(Level.INFO, () -> "Start getUnitDetails");
		ResponseEntity<Object> response = null;
		try {
			ManageUnitDTO item = unitService.getUnitDetails(unitId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, item));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getUnitDetails");
		return response;
	}

}

package com.wilkef.ecrack.setup.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.SessionDao;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/session")
public class SessionController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(SessionController.class.getName());
	
	@Autowired
	private  SessionDao sessionDao;
	
	/** The service output. */
	@Autowired
	private ServiceOutputTransformer serviceOutput;
	
	
	@PostMapping("/sessionLogin")
	public ResponseEntity<Object> sessionLogin(@RequestBody String input) {
	LOG.info("START-Inside sessionLogin");
	ResponseEntity<Object> response=null;
	long count=sessionDao.sessionLogin(input);
	if(count>0) {
		response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(serviceOutput.responseOutput("sessionId", count));
	}
	else {
		throw new CustomException(ErrorConstants.SESSION_NOT_CREATED);
	}
	LOG.info("END-Inside sessionLogin");
		return response;
	}

	
	@PostMapping("/sessionLogout/{sessionId}/{userId}")
	public ResponseEntity<Object> sessionLogout(@PathVariable long sessionId,@PathVariable long userId) {
	LOG.info("START-Inside sessionLogout");
	ResponseEntity<Object> response=null;
	String status=sessionDao.sessionLogout(sessionId,userId);
	if(status.equals("INACTIVE")) {
		response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(serviceOutput.responseOutput("isSuccess", true));
	}
	else {
		throw new CustomException(ErrorConstants.SESSION_INACTIVE_FAIL);
	}
	LOG.info("END-Inside sessionLogout");
		return response;
	}
}

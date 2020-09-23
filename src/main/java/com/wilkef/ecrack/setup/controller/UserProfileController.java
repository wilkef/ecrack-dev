package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dto.CommonResponseDTO;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/api.ecrack/api/user")
public class UserProfileController {


	public static final Logger LOG = Logger.getLogger(UserProfileController.class.getName());
	
	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private  UserProfileDao userProfileDao;
	

	@PutMapping(value = "/updateProfile/{userId}")
	public ResponseEntity<Object> updateProfile(@RequestBody String input,@Valid @PathVariable int userId){
		LOG.info("START-Inside validateEmailId");
		ResponseEntity<Object> response=null;
		CommonResponseDTO responseDTO=new CommonResponseDTO();
		List<UserProfileDTO> userProfileDTOList=new ArrayList<>();
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			userProfileDTOList = userProfileDao.updateProfile(input,userId);
			if(userProfileDTOList.get(0).getUpdateCount().equals(1)) {
				//response = new ResponseEntity<Object>(serviceOutput.responseOutput("isSuccess", true),HttpStatus.OK);
				//responseDTO=serviceOutput.responseOutput("{\"isSuccess\":true}","success",HttpStatus.OK,null);
				response= ResponseEntity.ok(responseDTO);
			}
			else {
				throw new CustomException("User Does Not Exist");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateEmailId");
		return  response;
	}
	
	
	@GetMapping(value = "/viewProfile/{userId}")
	public ResponseEntity<Object> viewProfile(@Valid @PathVariable int userId){
		LOG.info("START-Inside validateEmailId");
		CommonResponseDTO responseDTO=new CommonResponseDTO();
		ResponseEntity<Object> response=null;
		List<UserProfileDTO> userProfileDTOList=new ArrayList<>();
		
		try {
			LOG.log(Level.INFO,() -> "Before geting  information ");
			userProfileDTOList = userProfileDao.viewProfile(userId);
			if(!userProfileDTOList.get(0).getDataOutput().isEmpty()) {
				responseDTO=serviceOutput.responseOutput(userProfileDTOList.get(0).getDataOutput(),"success",HttpStatus.OK,null);
				response= ResponseEntity.ok(responseDTO);
			}
			else {
				throw new CustomException("User Does Not Exist");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the information  " + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside validateEmailId");
		return  response;
	}
	
}

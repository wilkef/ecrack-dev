/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to Authentication
 *
 */

package com.wilkef.ecrack.setup.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.AuthDataDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class AuthenticationController.
 */
@RestController
public class AuthenticationController {
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(AuthenticationController.class.getName());
	
	/** The validation dao. */
	@Autowired
	private ValidationDao validationDao;
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param pwd the pwd
	 * @return the auth data DTO
	 */
	@PostMapping("/getAuthToken")
	public ResponseEntity<Object> getAuthToken(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		LOG.info("START-Inside getAuthToken");
		
	AuthDataDTO user = new AuthDataDTO();
	ResponseEntity<Object> response=null;
	if(isValidUser(username,pwd)) {
		String token = getJWTToken(username);
		user.setUser(username);
		user.setToken(token);
		response =  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(user);
	}
	else {
		throw new CustomException(ErrorConstants.USER_NOT_EXISTS);
		
	}
	LOG.info("END-Inside getAuthToken");
		return response;
	}

	
	private boolean isValidUser(String user,String password) { 
		boolean isValid=Boolean.FALSE;
		JSONObject object=new JSONObject();
		List<ValidationDTO> validDto=new ArrayList<>();
		object.put("user", user); 
		object.put("password", password);
		validDto=validationDao.validateLogin(object.toString());
		if(validDto.size()>0 ) {
			isValid=true;
		}
		return isValid;
	}
	

	/**
	 * Gets the JWT token.
	 *
	 * @param username the username
	 * @return the JWT token
	 */
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 43200000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		return "Bearer " + token;
	}
}

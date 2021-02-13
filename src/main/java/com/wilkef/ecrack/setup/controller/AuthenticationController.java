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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dto.AuthDataDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
import com.wilkef.ecrack.setup.service.UserService;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class AuthenticationController.
 */
@RestController
@RequestMapping("/user")
public class AuthenticationController {
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(AuthenticationController.class.getName());

	@Autowired
	private UserService userService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;
	
	@Autowired
	private HttpServletRequest request;

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param pwd      the pwd
	 * @return the auth data DTO
	 */
	@PostMapping("/getAuthToken")
	public ResponseEntity<Object> getAuthToken(@RequestParam("user") String username,
			@RequestParam("password") String pwd) {
		LOG.info("START-Inside getAuthToken");
		ResponseEntity<Object> response = null;
		try {
			if (userService.isValidUser(username, pwd)) {
				String token = getJWTToken(username);
				AuthDataDTO userInfo = userService.getAuthData(token);
				userInfo.setToken(token);
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.TRUE, userInfo));
			} else {
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.INVALID_LOGIN_CREDENTIALS));
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.INVALID_LOGIN_CREDENTIALS));
		}

		LOG.info("END-Inside getAuthToken");
		return response;
	}

	@PostMapping("/getMobAuthToken")
	public ResponseEntity<Object> getMobAuthToken(@RequestParam("user") String username,
			@RequestParam("password") String pwd) {
		LOG.info("START-Inside getMobAuthToken");
		ResponseEntity<Object> response = null;
		if (userService.isValidUser(username, pwd)) {
			String token = getJWTMobToken(username);
			AuthDataDTO userInfo = userService.getAuthData(token);
			userInfo.setToken(token);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, userInfo));
		} else {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.INVALID_LOGIN_CREDENTIALS));
		}
		LOG.info("END-Inside getMobAuthToken");
		return response;
	}

	@GetMapping(value = "/getSessionData")
	public ResponseEntity<Object> getSessionData() {
		LOG.info("START-Inside getSessionData");
		AuthDataDTO userInfo = new AuthDataDTO();
		ResponseEntity<Object> response = null;
		try {
			String jwtToken = request.getHeader(WilkefConstants.AUTH_HEADER);
			if (!jwtToken.isEmpty()) {
				userInfo = userService.getAuthData(jwtToken);
				response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(serviceOutput.apiResponse(Boolean.TRUE, userInfo));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.INVALID_LOGIN_CREDENTIALS));
		}
		LOG.info("END-Inside getSessionData");
		return response;
	}
	
	/**
	 * Gets the JWT token.
	 *
	 * @param username the username
	 * @return the JWT token
	 */
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 43200000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	private String getJWTMobToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

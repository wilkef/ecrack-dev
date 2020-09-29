/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to Authentication
 *
 */

package com.wilkef.ecrack.setup.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.AuthDataDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class AuthenticationController.
 */
@RestController
public class AuthenticationController {

	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param pwd the pwd
	 * @return the auth data DTO
	 */
	@PostMapping("/getAuthToken")
	public AuthDataDTO login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		AuthDataDTO user = new AuthDataDTO();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
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
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

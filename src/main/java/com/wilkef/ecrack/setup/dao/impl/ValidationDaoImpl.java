/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to validation of personal Information
 *
 */

package com.wilkef.ecrack.setup.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.AuthDataDTO;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * The Class ValidationDaoImpl.
 */
@Repository
@Transactional
public class ValidationDaoImpl implements ValidationDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(ValidationDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Autowired
	private Environment env;

	/**
	 * Validate email.
	 *
	 * @param email the email
	 * @return the list
	 */
	@Override
	public List<ValidationDTO> validateEmail(String email) {

		List<ValidationDTO> validList = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VALIDATE_EMAIL)
					.returningResultSet("ValidEmailResultSet", BeanPropertyRowMapper.newInstance(ValidationDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(email);
			validList = (List<ValidationDTO>) execute.get("ValidEmailResultSet");
			if (!validList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return validList;
	}

	/**
	 * Validate mobile no.
	 *
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	@Override
	public List<ValidationDTO> validateMobileNo(String mobileNo) {
		List<ValidationDTO> validList = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VALIDATE_MOBILE)
					.returningResultSet("ValidMobileResultSet", BeanPropertyRowMapper.newInstance(ValidationDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(mobileNo);
			validList = (List<ValidationDTO>) execute.get("ValidMobileResultSet");

		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return validList;
	}

	/**
	 * Save otp.
	 *
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	@Override
	public List<ValidationDTO> saveOtp(String mobileNo) {
		Random num = new Random();
		List<ValidationDTO> validList = new ArrayList<>();
		String samplOtp = String.valueOf(num.nextInt((999999 - 100000) + 1) + 100000);
		try {
			StringBuffer stringBuffer = sendOtpToNum(mobileNo, samplOtp);
			// save data to Db
			JSONObject obj = new JSONObject(stringBuffer.toString());
			if (!obj.isEmpty() && obj.has("status") && obj.opt("status").toString().equals("success")) {
				SqlParameterSource in = new MapSqlParameterSource().addValue("p_mobileNo", mobileNo).addValue("p_otp",
						samplOtp);
				SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
						.withProcedureName(WilkefConstants.SAVE_OTP).returningResultSet("ValidotpResultSet",
								BeanPropertyRowMapper.newInstance(ValidationDTO.class));
				Map<String, Object> execute = simpleJdbcCall.execute(in);
				validList = (List<ValidationDTO>) execute.get("ValidotpResultSet");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return validList;
	}

	/**
	 * Verify otp.
	 *
	 * @param otp      the otp
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String verifyOtp(String otp, String mobileNo) {
		String msgTOUse = "";
		List<ValidationDTO> validList = new ArrayList<>();
		try {
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_mobileNo", mobileNo).addValue("p_otp", otp);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VERIFY_OTP)
					.returningResultSet("VerifyResultSet", BeanPropertyRowMapper.newInstance(ValidationDTO.class));
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			msgTOUse = execute.get("p_msg").toString();

		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return msgTOUse;
	}

	private StringBuffer sendOtpToNum(String mobileNo, String samplOtp) {
		final StringBuffer stringBuffer = new StringBuffer();

		try {
			String msg = URLEncoder.encode(WilkefConstants.OTP_MSG_1 + samplOtp + WilkefConstants.OTP_MSG_2, "UTF-8");
			String apiKey = "apikey=" + env.getProperty("app.otp.api.key");
			String message = "&message=" + msg;
			String sender = "&sender=" + env.getProperty("app.otp.api.sender");
			String numbers = "&numbers=" + mobileNo;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(env.getProperty("app.otp.api.url")).openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", "20");
			conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
		} catch (Exception e) {
			throw new CustomException(ErrorConstants.OTP_ERROR);
		}
		return stringBuffer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ValidationDTO> validateCredentials(@Valid String input) {
		List<ValidationDTO> validList = new ArrayList<>();
		try {
			JSONObject obj = new JSONObject(input);
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_userName", obj.get("user"))
					.addValue("p_password", obj.get("password"));
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VALIDATE_LOGIN)
					.returningResultSet("ResultSet", BeanPropertyRowMapper.newInstance(ValidationDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(in);
			validList = (List<ValidationDTO>) execute.get("ResultSet");

		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return validList;
	}
	
	
	@Override
	public Boolean validateUserLogin(String username, String password) {
		Boolean isValid = Boolean.FALSE;
		try {
			String sql = WilkefConstants.CHECK_LOGIN;
			Integer userId = appJdbcTemplate.queryForObject(sql, new Object[] { username, password }, Integer.class);
			isValid = userId > 0 ? Boolean.TRUE : Boolean.FALSE;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return isValid;
	}

	@Override
	public boolean setLoginStatus(int status, String input) {
		boolean isValid = Boolean.FALSE;
		JSONObject obj = new JSONObject(input);
		String updateQuery = WilkefConstants.SET_ACTIVE_STATUS;
		int update = appJdbcTemplate.update(updateQuery, status, obj.get("user"), obj.get("password"));
		if (update == 1) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}

	@Override
	public AuthDataDTO getAuthData(String user, String token) {
		List<AuthDataDTO> authdataList = new ArrayList<>();
		RowMapper<AuthDataDTO> rowMapper = (ResultSet result, int rowNum) -> {
			AuthDataDTO authData = new AuthDataDTO();
			authData.setMobileNumber(result.getString("MobileNumber"));
			authData.setEmailId(result.getString("EmailId"));
			authData.setFirstName(result.getString("FirstName"));
			authData.setMiddleName(result.getString("MiddleName"));
			authData.setLastName(result.getString("LastName"));			
			authData.setName(result.getString("Name"));
			authData.setUserType(result.getInt("UserTypeId") == 2 ? "Admin" : "Student");	
			authData.setGradeId(result.getInt("GradeId"));
			authData.setGradeName(result.getString("GradeName"));					
			return authData;
		};
		try {
			authdataList = appJdbcTemplate.query(WilkefConstants.TOKEN_RETURN, rowMapper, user);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for auth list");
		}
		authdataList.get(0).setToken(token);
		return authdataList.get(0);
	}

	@Override
	public LoggedinUserInfo getLoggedinUserInfo(String token) {
		LoggedinUserInfo loggedinUserInfo = new LoggedinUserInfo();
		try {
			token = token.replace(WilkefConstants.AUTH_HEADER_PREFIX, "");
			Jws<Claims> result = Jwts.parser().setSigningKey(WilkefConstants.JWT_SECRET.getBytes())
					.parseClaimsJws(token);
			String mobileNumber = result.getBody().getSubject().toString();

			String sql = WilkefConstants.LOGGEDIN_USER_INFO;
			return appJdbcTemplate.queryForObject(sql, new Object[] { mobileNumber }, (rs, rowNum) -> {
				loggedinUserInfo.setUserId(rs.getInt("userid"));
				loggedinUserInfo.setMobileNumber(rs.getString("MobileNumber"));
				loggedinUserInfo.setFirstName(rs.getString("FirstName"));
				loggedinUserInfo.setMiddleName(rs.getString("MiddleName"));
				loggedinUserInfo.setLastName(rs.getString("LastName"));
				loggedinUserInfo.setName(rs.getString("FirstName") + " " + rs.getString("MiddleName") + " " + rs.getString("LastName"));
				loggedinUserInfo.setGradeId(rs.getInt("GradeId"));
				return loggedinUserInfo;
			});

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching record for Loggedin User");
		}
		return loggedinUserInfo;
	}

	@Override
	public boolean validateCurrentPassword(String currentPassword, Integer userId) {
		boolean validCurrentPassword = Boolean.FALSE;
		LOG.log(Level.INFO, "Start validateCurrentPassword");
		try {
			String sql = WilkefConstants.GET_PASSWORD;
			String password = appJdbcTemplate.queryForObject(sql, new Object[] { userId }, String.class);
			if (password.equals(currentPassword)) {
				validCurrentPassword = Boolean.TRUE;
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		LOG.log(Level.INFO, "End validateCurrentPassword");
		return validCurrentPassword;
	}
}

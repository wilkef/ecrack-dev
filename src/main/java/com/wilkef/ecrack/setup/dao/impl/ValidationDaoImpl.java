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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;


/**
 * The Class ValidationDaoImpl.
 */
@Repository
@Transactional
public class ValidationDaoImpl implements ValidationDao{

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

		List<ValidationDTO> validList=new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VALIDATE_EMAIL)
					.returningResultSet("ValidEmailResultSet",
							BeanPropertyRowMapper.newInstance(ValidationDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(email);
			validList= (List<ValidationDTO>) execute.get("ValidEmailResultSet");
			if(!validList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
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
		List<ValidationDTO> validList=new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VALIDATE_MOBILE)
					.returningResultSet("ValidMobileResultSet",
							BeanPropertyRowMapper.newInstance(ValidationDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute(mobileNo);
			validList= (List<ValidationDTO>) execute.get("ValidMobileResultSet");

		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
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
		Random num=new Random();
		List<ValidationDTO> validList=new ArrayList<>();
		String samplOtp=String.valueOf(num.nextInt((999999 - 100000) + 1) + 100000);
		try {
			StringBuffer stringBuffer=sendOtpToNum(mobileNo,samplOtp);
           //save data to Db
			JSONObject obj=new JSONObject(stringBuffer.toString());
			if (!obj.isEmpty() && obj.has("status") && obj.opt("status").toString().equals("success")){
				SqlParameterSource in = new MapSqlParameterSource().addValue("p_mobileNo", mobileNo).addValue("p_otp", samplOtp);
				SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
						.withProcedureName(WilkefConstants.SAVE_OTP)
						.returningResultSet("ValidotpResultSet",
								BeanPropertyRowMapper.newInstance(ValidationDTO.class));
				Map<String, Object> execute = simpleJdbcCall.execute(in);
				validList= (List<ValidationDTO>) execute.get("ValidotpResultSet");
			}
		}
		catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return validList;
	}

	/**
	 * Verify otp.
	 *
	 * @param otp the otp
	 * @param mobileNo the mobile no
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ValidationDTO> verifyOtp(String otp, String mobileNo) {
		List<ValidationDTO> validList=new ArrayList<>();
		try {
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_mobileNo", mobileNo).addValue("p_otp", otp);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VERIFY_OTP)
					.returningResultSet("VerifyResultSet",
							BeanPropertyRowMapper.newInstance(ValidationDTO.class));
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			validList= (List<ValidationDTO>) execute.get("VerifyResultSet");

		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return validList;	
	}
	
	private StringBuffer sendOtpToNum(String mobileNo, String samplOtp) {
		final StringBuffer stringBuffer = new StringBuffer();
		
		try {
			String msg=URLEncoder.encode(WilkefConstants.OTP_MSG_1+samplOtp+WilkefConstants.OTP_MSG_2,"UTF-8"); 
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
		}
		catch(Exception e){
			throw new CustomException(ErrorConstants.OTP_ERROR);
		}
		return stringBuffer;
	}
}

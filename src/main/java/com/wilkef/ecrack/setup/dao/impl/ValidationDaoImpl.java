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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.ValidationDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;

// TODO: Auto-generated Javadoc
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
			//ValidationDTO vldt=new ValidationDTO();
			//vldt.setP_isValidMobile((Integer)execute.get("p_isValidMobile"));
			//validList.add(vldt);
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

		List<ValidationDTO> validList=new ArrayList<>();
		Random num=new Random();
		String samplOtp=String.valueOf(num.nextInt((999999 - 100000) + 1) + 100000);
		try {
			String msg=URLEncoder.encode("Your verification code is "+samplOtp+".Happy Learning !! Wilkef","UTF-8"); 
			String number=mobileNo;
			String apiKey = "apikey=" + "npbfUqDdwaY-GIODIBC1Hpu2wJphYOSCRfeMK1Fe09";
			String message = "&message=" + msg;
			String sender = "&sender=" + "PCHOAS";
			String numbers = "&numbers=" + number;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", "20");
			conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
           //save data to Db

			JSONObject obj=new JSONObject(stringBuffer.toString());
			if (!obj.isEmpty() && obj.has("status") && obj.opt("status").toString().equals("success")){
				SqlParameterSource in = new MapSqlParameterSource().addValue("p_mobileNo", number).addValue("p_otp", samplOtp);
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
}

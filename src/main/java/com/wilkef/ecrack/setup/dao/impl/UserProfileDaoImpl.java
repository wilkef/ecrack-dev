/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to User Profile
 *
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dto.ChangePasswordDataDTO;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;

/**
 * The Class UserProfileDaoImpl.
 */
@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(UserProfileDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Update profile.
	 *
	 * @param input  the input
	 * @param userId the user id
	 * @return the list
	 */
	@Override
	public List<UserProfileDTO> updateProfile(@Valid String input, String userId) {
		List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
		UserProfileDTO dto = new UserProfileDTO();
		try {
			JSONObject object = new JSONObject(input);
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_profile_data", input).addValue("p_mob_num",
					userId);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.UPDATE_PROFILE);
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			dto.setUpdateCount((Integer) execute.get("#update-count-1"));
			userProfileDTOList.add(dto);
			if (!userProfileDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return userProfileDTOList;
	}

	/**
	 * View profile.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfileDTO> viewProfile(String userId) {
		List<Map<String, Object>> list = new ArrayList<>();
		UserProfileDTO dto = new UserProfileDTO();
		List<UserProfileDTO> userProfileDTOList = new ArrayList<>();

		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VIEW_PROFILE);

			Map<String, Object> execute = simpleJdbcCall.execute(userId);
			list = (List<Map<String, Object>>) execute.get("#result-set-1");
			dto.setDataOutput(list.get(0).get("json_out").toString());
			userProfileDTOList.add(dto);

			if (!userProfileDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return userProfileDTOList;
	}

	@Override
	public Integer changePassword(ChangePasswordDataDTO changePasswordData, String userName) {
		String currentPassword = changePasswordData.getCurrentPassword();
		String newPassword = changePasswordData.getNewPassword();
		String confirmPassword = changePasswordData.getConfirmPassword();
		Integer status = null;
		try {
			LOG.fine("ChangePassword DB Operation Started ");
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.RESETPASSWORD);

			Map<String, Object> execute = simpleJdbcCall.execute(userName, currentPassword, newPassword);
			status = (Integer) execute.get("v_IsSuccess");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while ChangePassword ");
		}
		return status;
	}

}

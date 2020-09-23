package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

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
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {
	
	public static final Logger LOG = Logger.getLogger(UserProfileDaoImpl.class.getName());
	
	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<UserProfileDTO> updateProfile(@Valid String input, @Valid int userId) {
		List<UserProfileDTO> userProfileDTOList=new ArrayList<>();
		UserProfileDTO dto=new UserProfileDTO();
		try {
			
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_profile_data", input).addValue("p_user_id", userId);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.UPDATE_PROFILE);
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			dto.setUpdateCount((Integer) execute.get("#update-count-1"));
			userProfileDTOList.add(dto);
			if(!userProfileDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return userProfileDTOList;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfileDTO> viewProfile(int userId) {
		List<Map<String,Object>> list=new ArrayList<>();
		UserProfileDTO dto=new UserProfileDTO();
		List<UserProfileDTO> userProfileDTOList=new ArrayList<UserProfileDTO>();
		
		try {
			
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.VIEW_PROFILE);
					

			Map<String, Object> execute = simpleJdbcCall.execute(userId);
			list= (List<Map<String,Object>>) execute.get("#result-set-1");
			dto.setDataOutput(list.get(0).get("json_out").toString());
			userProfileDTOList.add(dto);
			
			if(!userProfileDTOList.isEmpty()) {
				LOG.fine("Data Retrieved Successfully");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return userProfileDTOList;	
	}

}
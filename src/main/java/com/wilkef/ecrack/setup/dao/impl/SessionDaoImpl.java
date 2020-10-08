package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.SessionDao;
import com.wilkef.ecrack.setup.dto.SessionDTO;

@Repository
public class SessionDaoImpl implements SessionDao{
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(SessionDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public long sessionLogin(String input) {
		long count=0;
		List<SessionDTO> dtolist=new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.SESSION_LOGIN).returningResultSet("Result",
			                 BeanPropertyRowMapper.newInstance(SessionDTO.class));;
			Map<String, Object> execute = simpleJdbcCall.execute(input);
			dtolist= (List<SessionDTO>) execute.get("Result");
			if(!dtolist.isEmpty() && dtolist.get(0).getLastInserId()>0) {
				LOG.info("Data Inserted");
				count=dtolist.get(0).getLastInserId();
			}
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return count;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public String sessionLogout(long sessionId, long userId) {
		String status=null;
		List<SessionDTO> dtolist=new ArrayList<>();
		try {
			SqlParameterSource in = new MapSqlParameterSource().addValue("p_db_session_id", sessionId).addValue("p_user_id", userId);
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.SESSION_LOGOUT).returningResultSet("Result",
			                 BeanPropertyRowMapper.newInstance(SessionDTO.class));;
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			dtolist= (List<SessionDTO>) execute.get("Result");
			if(!dtolist.isEmpty() && null!=dtolist.get(0).getSessionStatus()) {
				status=dtolist.get(0).getSessionStatus();
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,e.getMessage());
		}
		return status;	
	}

}

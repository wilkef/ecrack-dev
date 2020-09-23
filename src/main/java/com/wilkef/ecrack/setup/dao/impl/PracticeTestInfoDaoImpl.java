/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.List;
import java.util.Map;
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

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.PracticeTestInfoDao;
import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;

/**
 * @author Satya
 *Sep 21, 2020
 */

@Repository
public class PracticeTestInfoDaoImpl implements PracticeTestInfoDao{

	public static final Logger LOG = Logger.getLogger(PracticeTestInfoDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<PracticeTestInfoDTO> findPracticeTestInfo(JSONObject obj) {
		LOG.fine("Store User Details ");
		List<PracticeTestInfoDTO> practiceTestInfoStatus = null;
		try {	
			SqlParameterSource in = new MapSqlParameterSource().
					addValue("p_userId", obj.get("userId")).
					addValue("p_lessonId", obj.get("lessonId")).
					addValue("p_testName", obj.get("testName")).
					addValue("p_testLevel", obj.get("testLevelId"));
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.PRACTICE_TEST_INFO)
					.returningResultSet("PracticeTestInfoResultSet",
							BeanPropertyRowMapper.newInstance(PracticeTestInfoDTO.class));
			
			
			Map<String, Object> execute = simpleJdbcCall.execute(in);
			practiceTestInfoStatus= (List<PracticeTestInfoDTO>) execute.get("PracticeTestInfoResultSet");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while Inserting User Record ");
		}
		return practiceTestInfoStatus;
	}

}

/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.AnswerStatusDao;
import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;

/**
 * This Class is Used to execute DB operation of AnswerStatus
 * 
 * @author Satya
 *Sep 20, 2020
 */

@Repository
public class AnswerStatusDaoImpl implements AnswerStatusDao{

	public static final Logger LOG = Logger.getLogger(AnswerStatusDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnswerStatusDataDTO> findAllAnswerStatus() {
		List<AnswerStatusDataDTO> answerStatusList = new ArrayList<>();
		LOG.fine("get AnswerStatus details ");
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
			           .withProcedureName(WilkefConstants.ANSWER_STATUS_LIST)
			           .returningResultSet("AnswerStatus",
			                 BeanPropertyRowMapper.newInstance(AnswerStatusDataDTO.class));

			    Map<String, Object> execute = simpleJdbcCall.execute();
			    answerStatusList=(List<AnswerStatusDataDTO>) execute.get("AnswerStatus");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for AnswerStatus ");
		}
		return answerStatusList;
	}
}

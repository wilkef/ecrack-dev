/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

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
import com.wilkef.ecrack.setup.dao.LessionListDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;

/**
 *  This Class is Used to execute Lession DB Operation
 * 
 * @author Satya
 * Sep 18, 2020
 */
@Repository
public class LessionListDaoImpl implements LessionListDao{

	public static final Logger LOG = Logger.getLogger(LessionListDaoImpl.class.getName());
	
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LessionListDataDTO> findByUnitId(Integer unitId) {
		LOG.fine("get Subject Details ");
		List<LessionListDataDTO> lessionList=null;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
			           .withProcedureName(WilkefConstants.GET_LESSIONLISTBYUNITID)
			           .returningResultSet("LessionResultSet",
			                 BeanPropertyRowMapper.newInstance(LessionListDataDTO.class));

			    Map<String, Object> execute = simpleJdbcCall.execute(unitId);
			    lessionList=(List<LessionListDataDTO>) execute.get("LessionResultSet");
			    
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for subject list");
		}
		return lessionList;	
	}

}

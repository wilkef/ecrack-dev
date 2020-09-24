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
import com.wilkef.ecrack.setup.dao.UnitListDao;
import com.wilkef.ecrack.setup.dto.UnitListDataDTO;


/**
 *  This Class is Used to execute UnitList DB Operation.
 *
 * @author Satya
 * Sep 18, 2020
 */

@Repository
public class UnitListDaoImpl implements UnitListDao{

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(UnitListDaoImpl.class.getName());
	
	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	/**
	 * Find by subject id.
	 *
	 * @param subjectId the subject id
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId) {
		LOG.fine("get UnitList Details ");
		List<UnitListDataDTO> subjectListData = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
			           .withProcedureName(WilkefConstants.GET_UNITLISTBYSUBJECTID)
			           .returningResultSet("SubjectResultSet",
			                 BeanPropertyRowMapper.newInstance(UnitListDataDTO.class));

			    Map<String, Object> execute = simpleJdbcCall.execute(subjectId);
			    subjectListData=(List<UnitListDataDTO>) execute.get("SubjectResultSet");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for unitLi list");
		}
		return subjectListData;	
	}
}

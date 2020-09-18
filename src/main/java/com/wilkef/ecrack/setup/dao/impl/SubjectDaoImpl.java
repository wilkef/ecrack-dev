package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.SubjectDao;
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;

/**
 * This Class is Used to execute Subject DB Operation
 * 
 * 
 * @author Satya
 * Sep 16, 2020
 */

@Repository
@Transactional
public class SubjectDaoImpl implements SubjectDao{

	public static final Logger LOG = Logger.getLogger(SubjectDaoImpl.class.getName());
	List<SubjectDataDTO> subjectDataList = new ArrayList<>();
	
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectDataDTO> findByGradeId(Integer gradeId) {
		LOG.fine("get Subject Details ");
		List<SubjectDataDTO> subjectList=null;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
			           .withProcedureName(WilkefConstants.GET_SUBJECTBYGRADEID)
			           .returningResultSet("SubjectResultSet",
			                 BeanPropertyRowMapper.newInstance(com.wilkef.ecrack.setup.dto.SubjectDataDTO.class));

			    Map<String, Object> execute = simpleJdbcCall.execute(gradeId);
			    subjectDataList=(List<SubjectDataDTO>) execute.get("SubjectResultSet");
			    subjectList=subjectDataList.stream().filter(Objects::nonNull).collect(Collectors.toList());
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for subject list");
		}
		return subjectList;	
	}
}

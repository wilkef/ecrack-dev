package com.wilkef.ecrack.setup.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.dao.SubjectDao;
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;

@Repository
@Transactional
public class SubjectDaoImpl implements SubjectDao{

	public static final Logger LOG = Logger.getLogger(SubjectDaoImpl.class.getName());
	List<SubjectDataDTO> subjectDataList = new ArrayList<>();
	
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@Override
	public List<SubjectDataDTO> findByGradeId(Integer gradeId) {
		LOG.fine("get Subject Details ");
		RowMapper<SubjectDataDTO> rowMapper = (ResultSet result, int rowNum) ->{
			SubjectDataDTO subjectData = new SubjectDataDTO();
			subjectData.setSubjectId(result.getInt(1));
			subjectData.setSubjectName(result.getString(2));
			subjectData.setSubjectCode(result.getString(3));
			subjectData.setNoOfPeriod(result.getInt(4));
			subjectData.setMaxMark(result.getInt(5));
			subjectData.setGradeName(result.getString(6));
			return subjectData;
		};
		try {
			subjectDataList = appJdbcTemplate.query("SELECT * FROM Subject where GradeId='"+gradeId+"'", rowMapper);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for subject list");
		}
		return subjectDataList;	
	}
}

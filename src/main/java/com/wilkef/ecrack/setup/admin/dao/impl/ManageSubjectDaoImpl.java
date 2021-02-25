package com.wilkef.ecrack.setup.admin.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.admin.dao.ManageSubjectDao;
import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageUnitDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageSubjectDaoImpl implements ManageSubjectDao {

	public static final Logger LOG = Logger.getLogger(ManageSubjectDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getSubjectList(Integer gradeId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getSubjectList DAO");
		try {
			String query = "SELECT s.SubjectId, s.SubjectName, s.SubjectCode, s.IsActive, g.GradeName FROM Subject s "
					+ "JOIN Grade g ON(s.GradeId=g.GradeId) WHERE s.GradeId=? ORDER BY s.SubjectId ASC";
			appJdbcTemplate.query(query, new Object[] { gradeId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("subjectId", result.getInt("SubjectId"));
				item.put("subjectName", result.getString("SubjectName"));
				item.put("subjectCode", result.getString("SubjectCode"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("gradeName", result.getString("GradeName"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Subject list:" + e.getMessage());
			throw new CustomException("Error while fetching Subject list:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getSubjectList DAO");
		return list;
	}

	@Override
	public Boolean saveSubject(ManageSubjectDTO data, String username) {
		try {
			if (data.getSubjectId() != null && data.getSubjectId() > 0) {
				String query = "UPDATE `Subject` SET `SubjectName`=? WHERE SubjectId=?";
				appJdbcTemplate.update(query, data.getSubjectName(), data.getSubjectId());
			} else {
				String query = "INSERT INTO `Subject` (`SubjectName`) VALUES (?)";
				appJdbcTemplate.update(query, data.getSubjectName());
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Subject:" + e.getMessage());
			throw new CustomException("Error while creating a new Subject:" + e.getMessage());
		}
		return true;
	}

	@Override
	public ManageSubjectDTO getSubjectDetails(Integer subjectId) {
		ManageSubjectDTO item = new ManageSubjectDTO();
		LOG.log(Level.INFO, () -> "Start getSubjectDetails");
		try {
			String query = "SELECT SubjectId, SubjectName FROM Subject WHERE SubjectId=?";
			appJdbcTemplate.query(query, new Object[] { subjectId }, (rs, rowNum) -> {
				item.setSubjectId(rs.getInt("McqId"));
				return item;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Subject Details:" + e.getMessage());
			throw new CustomException("Error while fetching Subject Details:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getSubjectDetails");
		return item;
	}

}

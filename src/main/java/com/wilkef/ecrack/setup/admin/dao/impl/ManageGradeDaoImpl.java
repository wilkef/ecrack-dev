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

import com.wilkef.ecrack.setup.admin.dao.ManageGradeDao;
import com.wilkef.ecrack.setup.admin.dto.ManageGradeDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageGradeDaoImpl implements ManageGradeDao {

	public static final Logger LOG = Logger.getLogger(ManageGradeDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getGradeList(Integer boardId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getGradeList DAO");
		try {
			String query = "SELECT g.GradeId, g.GradeName, g.IsActive, b.BoardShortName FROM Grade g JOIN Board b "
					+ "ON(b.BoardId=g.BoardId) WHERE g.BoardId=? ORDER BY g.GradeId ASC";
			appJdbcTemplate.query(query, new Object[] { boardId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("gradeId", result.getInt("GradeId"));
				item.put("gradeName", result.getString("GradeName"));
				item.put("boardName", result.getString("BoardShortName"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Grade list:" + e.getMessage());
			throw new CustomException("Error while fetching Grade list:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getGradeList DAO");
		return list;
	}
	
	@Override
	public Boolean saveGrade(ManageGradeDTO data, String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ManageGradeDTO getGradeDetails(Integer gradeId) {
		// TODO Auto-generated method stub
		return null;
	}

}

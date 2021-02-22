package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.dao.SettingsDao;
import com.wilkef.ecrack.setup.dto.InstructorDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class SettingsDaoImpl implements SettingsDao {

	public static final Logger LOG = Logger.getLogger(SettingsDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<InstructorDTO> getInstructors() {
		List<InstructorDTO> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start geInstructorList DAO");
		try {
			String query = "SELECT InstructorId,Name,Designation,Image  FROM Instructor WHERE IsActive = 1 ORDER BY Name ASC";
			appJdbcTemplate.query(query, new Object[] {}, (rs, row) -> {
				InstructorDTO item = new InstructorDTO();
				item.setInstructorId(rs.getInt("InstructorId"));
				item.setName(rs.getString("Name"));
				item.setDesignation(rs.getString("Designation"));
				item.setImage(rs.getString("Image"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Instructor List:" + e.getMessage());
			throw new CustomException("Error while fetching Instructor List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End geInstructorList DAO");
		return list;
	}

}

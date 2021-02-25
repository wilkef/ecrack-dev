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

import com.google.gson.Gson;
import com.wilkef.ecrack.setup.admin.dao.AdminDao;
import com.wilkef.ecrack.setup.admin.dto.ManageInstructorDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	public static final Logger LOG = Logger.getLogger(AdminDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Boolean toggleStatus(String table, Integer id, Integer status) {
		LOG.log(Level.INFO, "DATA:" + id + table + status);
		Boolean res = Boolean.TRUE;
		status = status >= 1 ? 1 : 0;
		try {
			String query = "";
			switch (table) {
			case "mcq":
				query = "UPDATE `Mcq` SET `IsActive` = ? WHERE `McqId` = ?";
				break;
			case "board":
				query = "UPDATE `Board` SET `IsActive` = ? WHERE `BoardId` = ?";
				break;
			case "grade":
				query = "UPDATE `Grade` SET `IsActive` = ? WHERE `GradeId` = ?";
				break;
			case "subject":
				query = "UPDATE `Subject` SET `IsActive` = ? WHERE `SubjectId` = ?";
				break;
			case "unit":
				query = "UPDATE `Unit` SET `IsActive` = ? WHERE `UnitId` = ?";
				break;
			case "lesson":
				query = "UPDATE `Lesson` SET `IsActive` = ? WHERE `LessonId` = ?";
				break;
			case "city":
				query = "UPDATE `City` SET `IsActive` = ? WHERE `CityId` = ?";
				break;
			case "user":
				query = "UPDATE `User` SET `IsActive` = ? WHERE `userid` = ?";
				break;
			case "exam":
				query = "UPDATE `TestHeader` SET `IsActive` = ? WHERE `TestId` = ?";
				break;
			}
			if (query.length() > 0) {
				appJdbcTemplate.update(query, status, id);
			} else {
				res = Boolean.FALSE;
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while updating the status:" + table + status + e.getMessage());
			throw new CustomException("Error while updating the status:" + table + status + e.getMessage());
		}
		return res;
	}

	@Override
	public List<ManageInstructorDTO> getInstructorList() {
		List<ManageInstructorDTO> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start geInstructorList DAO");
		try {
			String query = "SELECT InstructorId,Name,Designation,Image  FROM Instructor ORDER BY Name ASC";
			appJdbcTemplate.query(query, new Object[] { }, (rs, row) -> {
				ManageInstructorDTO item = new ManageInstructorDTO();
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
	
	@Override
	public Boolean addInstructor(ManageInstructorDTO data, String username) {
		LOG.log(Level.INFO, () -> "Start addInstructor DAO");
		try {
			if (data.getInstructorId() != null && data.getInstructorId() > 0) {
				String query = "UPDATE Instructor SET `Name`=?, `Designation`=?, `Image`=? WHERE InstructorId=?";
				appJdbcTemplate.update(query, data.getName(), data.getDesignation(), data.getImage(),
						data.getInstructorId());
			} else {
				String query = "INSERT INTO `Instructor` (`Name`, `Designation`, `Image`, `CreatedBy`, `CreationDate`)"
						+ " VALUES (?, ?, ?, ?, NOW())";
				appJdbcTemplate.update(query, data.getName(), data.getDesignation(), data.getImage(), username);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Instructor:" + e.getMessage());
			throw new CustomException("Error while creating a new Instructor:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End addInstructor DAO");
		return true;
	}

	@Override
	public Boolean deleteInstructor(Integer instructorId) {
		LOG.log(Level.INFO, () -> "Start deleteInstructor DAO");
		try {
			String query = "DELETE FROM Instructor WHERE InstructorId=?";
			appJdbcTemplate.update(query, instructorId);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Instructor:" + e.getMessage());
			throw new CustomException("Error while creating a new Instructor:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End deleteInstructor DAO");
		return true;
	}

}

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

import com.wilkef.ecrack.setup.admin.dao.AdminDao;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getStudentList() {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getStudentList DAO");
		try {
			String query = "SELECT userid, MobileNumber, UserTypeId, EmailId, CONCAT(FirstName , ' ' , MiddleName , ' ' , Lastname) as Name, "
					+ "Gender, DateOfBirth, ProfileImagePath, PrimaryAddress, CityId, IsMobileConfirm, IsEmailConfirm, IsActive, "
					+ "CreationDate  FROM `User` ORDER BY userid DESC";
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("userId", result.getLong("userid"));
				item.put("mobileNumber", result.getString("MobileNumber"));
				item.put("userTypeId", result.getInt("UserTypeId"));
				item.put("userTypeId", result.getString("UserTypeId"));
				item.put("emailId", result.getString("EmailId"));
				item.put("name", result.getString("Name"));
				item.put("gender", result.getString("Gender"));
				item.put("dateOfBirth", result.getString("DateOfBirth"));
				item.put("profileImagePath", result.getString("ProfileImagePath"));
				item.put("primaryAddress", result.getString("PrimaryAddress"));
				item.put("cityId", result.getString("CityId"));
				item.put("isMobileConfirm", result.getInt("IsMobileConfirm") > 0 ? true : false);
				item.put("isEmailConfirm", result.getInt("IsEmailConfirm") > 0 ? true : false);
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("creationDate", result.getString("CreationDate"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Subject list:" + e.getMessage());
			throw new CustomException("Error while fetching Student List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getStudentList DAO");
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getBoardList() {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getBoardList DAO");
		try {
			String query = "SELECT BoardId, BoardName, BoardShortName, IsActive FROM Board ORDER BY BoardName ASC";
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("boardId", result.getInt("BoardId"));
				item.put("boardName", result.getString("BoardName"));
				item.put("boardShortName", result.getString("BoardShortName"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Board list:" + e.getMessage());
			throw new CustomException("Error while fetching Board list:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getBoardList DAO");
		return list;
	}

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getUnitList(Integer subjectId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getUnitList DAO");
		try {
			String query = "SELECT u.UnitId, u.UnitName, u.MaxMark, u.NoOfPeriod, u.IsActive, s.SubjectName FROM Unit u "
					+ "JOIN Subject s ON(s.SubjectId=u.SubjectId) WHERE u.SubjectId=? ORDER BY u.UnitSerial ASC";
			appJdbcTemplate.query(query, new Object[] { subjectId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("unitId", result.getInt("UnitId"));
				item.put("unitName", result.getString("UnitName"));
				item.put("maxMark", result.getInt("MaxMark"));
				item.put("noOfPeriod", result.getInt("NoOfPeriod"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("subjectName", result.getString("SubjectName"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Unit List:" + e.getMessage());
			throw new CustomException("Error while fetching Unit List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getUnitList DAO");
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getLessonList(Integer unitId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getLessonList DAO");
		try {
			String query = "SELECT l.LessonId, l.LessonName, l.VideoUrl, l.LessonMark, l.NoOfPeriod, l.NoOfQuestion, l.IsActive, u.UnitName "
					+ "FROM Lesson l JOIN Unit u ON(l.UnitId=u.UnitId) WHERE l.UnitId=? ORDER BY l.LessonSerial ASC";
			appJdbcTemplate.query(query, new Object[] { unitId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("lessonId", result.getInt("LessonId"));
				item.put("lessonName", result.getString("LessonName"));
				item.put("videoUrl", result.getString("VideoUrl"));
				item.put("lessonMark", result.getInt("LessonMark"));
				item.put("noOfPeriod", result.getInt("NoOfPeriod"));
				item.put("noOfQuestion", result.getInt("NoOfQuestion"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("unitName", result.getString("UnitName"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Lesson List:" + e.getMessage());
			throw new CustomException("Error while fetching Lesson List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getLessonList DAO");
		return list;
	}

}

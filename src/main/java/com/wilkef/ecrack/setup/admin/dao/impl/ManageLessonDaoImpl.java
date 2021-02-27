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
import com.wilkef.ecrack.setup.admin.dao.ManageLessonDao;
import com.wilkef.ecrack.setup.admin.dto.ManageLessonDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageMcqDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageMcqOptionsDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageLessonDaoImpl implements ManageLessonDao {

	public static final Logger LOG = Logger.getLogger(ManageLessonDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

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

	@Override
	public Boolean saveLesson(ManageLessonDTO data, String username) {
		try {
			if (data.getLessonId() != null && data.getLessonId() > 0) {
				String query = "UPDATE `Lesson` SET `LessonName`=? WHERE LessonId=?";
				appJdbcTemplate.update(query, data.getLessonName(), data.getLessonId());
			} else {
				String query = "INSERT INTO `Lesson` (`LessonName`) VALUES (?)";
				appJdbcTemplate.update(query, data.getLessonName());
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Lesson:" + e.getMessage());
			throw new CustomException("Error while creating a new Lesson:" + e.getMessage());
		}
		return true;
	}
	
	@Override
	public ManageLessonDTO getLessonDetails(Integer lessonId) {
		ManageLessonDTO item = new ManageLessonDTO();
		LOG.log(Level.INFO, () -> "Start getLessonDetails");
		try {
			String query = "SELECT LessonId, LessonName FROM Lesson WHERE LessonId=?";
			appJdbcTemplate.query(query, new Object[] { lessonId }, (rs, rowNum) -> {
				item.setLessonId(rs.getInt("LessonId"));
				return item;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Lesson Details:" + e.getMessage());
			throw new CustomException("Error while fetching Lesson Details:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getLessonDetails");
		return item;
	}
	
}

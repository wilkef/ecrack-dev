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
import com.wilkef.ecrack.setup.admin.dao.ManageExamDao;
import com.wilkef.ecrack.setup.admin.dto.TestInfoDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageExamDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageMcqDTO;
import com.wilkef.ecrack.setup.admin.dto.McqFilterDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageMcqOptionsDTO;
import com.wilkef.ecrack.setup.admin.dto.TestLineDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageExamDaoImpl implements ManageExamDao {

	public static final Logger LOG = Logger.getLogger(ManageExamDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
	@Override
	public TestInfoDTO getExamInfo(Integer examId) {
		TestInfoDTO testInfo = new TestInfoDTO();
		LOG.log(Level.INFO, () -> "Start getExamInfo DAO:" + examId);
		try {
			String query = "SELECT t.TestId, t.GradeId, t.TestName, t.TestTypeId, t.DifficultyLevel, t.StartDateTime, t.EndDateTime, t.IsActive, g.BoardId FROM TestHeader t JOIN Grade g ON(t.GradeId=g.GradeId) WHERE TestId = ?";
			appJdbcTemplate.query(query, new Object[] { examId }, (result, rowNum) -> {
				testInfo.setTestId(result.getInt("TestId"));
				testInfo.setBoardId(result.getInt("BoardId"));
				testInfo.setGradeId(result.getInt("GradeId"));
				testInfo.setTestName(result.getString("TestName"));
				testInfo.setTestTypeId(result.getInt("TestTypeId"));
				testInfo.setDifficultyLevel(result.getInt("DifficultyLevel"));
				testInfo.setStartDateTime(result.getString("StartDateTime"));
				testInfo.setEndDateTime(result.getString("EndDateTime"));
				return testInfo;
			});

			// Fetch TestLines
			List<TestLineDTO> testLines = new ArrayList<>();
			String query2 = "SELECT t.TestlineId, t.SubjectId, t.NoOfQuestion, t.QuestionSet FROM `TestLine` t WHERE t.TestHeaderId = ?";
			appJdbcTemplate.query(query2, new Object[] { examId }, (result, rowNum) -> {
				TestLineDTO testLineDTO = new TestLineDTO();
				testLineDTO.setTestLineId(result.getLong("TestlineId"));
				testLineDTO.setNoOfQuestion(result.getInt("NoOfQuestion"));
				testLineDTO.setSubjectId(result.getInt("SubjectId"));
				testLines.add(testLineDTO);
				return testLines;
			});
			testInfo.setSubjects(testLines);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching getExamInfo:" + e.getMessage());
			throw new CustomException("Error while fetching getExamInfo:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getExamInfo DAO");
		return testInfo;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getExamDetails(Integer examId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getExamDetails DAO");
		try {
			String query = "SELECT t.TestlineId, t.NoOfQuestion, t.QuestionSet, s.SubjectId, s.SubjectName, s.SubjectCode FROM `TestLine` t "
					+ "JOIN Subject s ON(t.SubjectId=s.SubjectId) WHERE t.TestHeaderId = ?";
			appJdbcTemplate.query(query, new Object[] { examId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("testlineId", result.getLong("TestlineId"));
				item.put("noOfQuestion", result.getInt("NoOfQuestion"));
				item.put("questionSet", this.getMcqQuestions(result.getString("QuestionSet")));
				item.put("subjectId", result.getString("SubjectId"));
				item.put("subjectName", result.getString("SubjectName"));
				item.put("subjectCode", result.getString("SubjectCode"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching getExamDetails:" + e.getMessage());
			throw new CustomException("Error while fetching getExamDetails:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getExamDetails DAO");
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<HashMap> getMcqQuestions(String ids) {
		List<HashMap> list = new ArrayList<>();
		try {
			if (!ids.isEmpty()) {
				String query = "SELECT McqId, Question FROM `Mcq` WHERE McqId IN(" + ids + ")";
				appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
					HashMap item = new HashMap<>();
					item.put("mcqId", result.getLong("McqId"));
					item.put("question", result.getString("Question"));
					list.add(item);
					return list;
				});
			}
		} catch (Exception e) {

		}
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getExamSubjectsDetails(Integer testHeaderId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getExamSubjectsDetails DAO");
		try {
			String query = "SELECT t.TestlineId, t.NoOfQuestion, t.QuestionSet, s.SubjectId, s.SubjectName, s.SubjectCode FROM `TestLine` t "
					+ "JOIN Subject s ON(t.SubjectId=s.SubjectId) WHERE t.TestHeaderId = ?";
			appJdbcTemplate.query(query, new Object[] { testHeaderId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("testLineId", result.getLong("TestlineId"));
				item.put("noOfQuestion", result.getInt("NoOfQuestion"));
				item.put("questionSet", result.getString("QuestionSet"));
				item.put("subjectId", result.getString("SubjectId"));
				item.put("subjectName", result.getString("SubjectName"));
				item.put("subjectCode", result.getString("SubjectCode"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching getExamSubjectsDetails:" + e.getMessage());
			throw new CustomException("Error while fetching getExamSubjectsDetails:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getExamSubjectsDetails DAO");
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getMCQData(McqFilterDTO data) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getMCQData DAO");
		try {
			String cond = "";
			if (data.getLessonId() != null && data.getLessonId() > 0) {
				cond = "l.LessonId=" + data.getLessonId();
			} else if (data.getUnitId() != null && data.getUnitId() > 0) {
				cond = "u.UnitId=" + data.getUnitId();
			} else if (data.getSubjectId() != null && data.getSubjectId() > 0) {
				cond = "s.SubjectId=" + data.getSubjectId();
			}
			String query = "SELECT m.McqId, m.Question FROM Mcq m JOIN Lesson l ON(m.LessonId=l.LessonId) JOIN Unit u ON(l.UnitId=u.UnitId) "
					+ "JOIN Subject s ON(u.SubjectId=s.SubjectId) WHERE " + cond + " ORDER BY McqId DESC LIMIT 0, 100";
			LOG.log(Level.INFO, () -> "Query:" + query);
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("mcqId", result.getLong("McqId"));
				item.put("question", result.getString("Question"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching MCQ Data:" + e.getMessage());
			throw new CustomException("Error while fetching MCQ Data:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getMCQData DAO");
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getMCQList(McqFilterDTO data) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getMCQList DAO");
		try {
			LOG.log(Level.INFO, () -> "Filters Data:" + data);
			Integer limit = data.getLimit();
			Integer page = data.getPage();
			Integer offset = page * limit;			
			String query = "SELECT McqId, Question, IsActive, CreatedBy, CreationDate FROM Mcq WHERE 1 ORDER BY McqId DESC LIMIT " + offset + ", " + limit;
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("mcqId", result.getLong("McqId"));
				item.put("question", result.getString("Question"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("createdBy", result.getString("CreatedBy"));
				item.put("creationDate", result.getString("CreationDate"));
				// item.put("questionOptionsJson", new Gson().fromJson(result.getString("QuestionOptionsJson"), McqOptionsDTO[].class));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching MCQ list:" + e.getMessage());
			LOG.log(Level.INFO, "Error while fetching MCQ list:" + e.getMessage());
			throw new CustomException("Error while fetching MCQ List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getMCQList DAO");
		return list;
	}
	
	@Override
	public Integer getMcqCount() {
		Integer count = 0;
		try {
			String query = "SELECT COUNT(*) AS count FROM Mcq WHERE 1";
			count = (int) appJdbcTemplate.queryForObject(query, new Object[] {}, Integer.class);
			appJdbcTemplate.update(query);
		} catch (Exception e) {
			// Code
		}
		return count;
	}

	@Override
	public Boolean saveMCQ(ManageMcqDTO data, String username) {
		try {
			String questionOptionsJson = new Gson().toJson(data.getQuestionOptionsJson());
			if (data.getMcqId() != null && data.getMcqId() > 0) {
				String query = "UPDATE `Mcq` SET `Question`=?, `QuestionDesc`=?, `QuestionOptionsJson`=?, `Answer`=?, `DifficultyLevel`=?, "
						+ "`Solution`=?,  `LastUpdatedBy`=?, `LastUpdateDate`= NOW() WHERE McqId=?";
				appJdbcTemplate.update(query, data.getQuestion(), data.getQuestionDesc(), questionOptionsJson,
						data.getAnswer(), data.getDifficultyLevel(), data.getSolution(), username, data.getMcqId());
			} else {
				String query = "INSERT INTO `Mcq` (`LessonId`, `Question`, `QuestionDesc`, `QuestionOptionsJson`, `Answer`, `DifficultyLevel`, "
						+ "`Solution`,  `CreatedBy`, `LastUpdatedBy`, `IsActive`, `CreationDate`, `LastUpdateDate`)\r\n"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1, NOW(), NOW())";
				appJdbcTemplate.update(query, data.getLessonId(), data.getQuestion(), data.getQuestionDesc(),
						questionOptionsJson, data.getAnswer(), data.getDifficultyLevel(), data.getSolution(), username,
						username);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new MCQ:" + e.getMessage());
			throw new CustomException("Error while creating a new MCQ:" + e.getMessage());
		}
		return true;
	}

	@Override
	public Boolean updateTestLineQuestionSet(TestLineDTO data, String username) {
		try {
			String query = "UPDATE `TestLine` SET `QuestionSet`=?, `NoOfQuestion`=?, `LastUpdatedBy`=?, `LastUpdateDate`= NOW() WHERE TestLineId=?";
			appJdbcTemplate.update(query, data.getQuestionSet(), data.getNoOfQuestion(), username,
					data.getTestLineId());
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error updateTestLineQuestionSet:" + e.getMessage());
			throw new CustomException("Error updateTestLineQuestionSet:" + e.getMessage());
		}
		return true;
	}

	@Override
	public Integer saveExam(TestInfoDTO data, String username) {
		Integer examId = 0;
		try {
			if (data.getTestId() != null && data.getTestId() > 0) {
				// Update Exam
				examId = data.getTestId();
				String query = "UPDATE `TestHeader` SET `GradeId`=?, `TestName`=?, `TestTypeId`=?, `DifficultyLevel`=?, "
						+ "`StartDateTime`=?, `EndDateTime`=?, `LastUpdatedBy`=?, `LastUpdateDate`= NOW() WHERE TestId = ?";
				appJdbcTemplate.update(query, data.getGradeId(), data.getTestName(), data.getTestTypeId(),
						data.getDifficultyLevel(), data.getStartDateTime(), data.getEndDateTime(), username, examId);

				// Set Exam Subjects
				for (TestLineDTO testLine : data.getSubjects()) {
					if (testLine.getTestLineId() != null && testLine.getTestLineId() > 0) {
						String sql = "UPDATE  `TestLine` SET  `NoOfQuestion`=?, `LastUpdatedBy`=?, `LastUpdateDate` = NOW() WHERE TestLineId = ?";
						appJdbcTemplate.update(sql, testLine.getNoOfQuestion(), username, testLine.getTestLineId());
					} else if (testLine.getIsSelected()) {
						String sql = "INSERT INTO `TestLine` (`TestHeaderId`, `SubjectId`, `NoOfQuestion`, `CreatedBy`, `CreationDate`, `LastUpdatedBy`, `LastUpdateDate`)\r\n"
								+ "VALUES (?, ?, ?, ?, NOW(), ?, NOW())";
						appJdbcTemplate.update(sql, examId, testLine.getSubjectId(), testLine.getNoOfQuestion(),
								username, username);
					}
				}
			} else {
				// Create New Exam
				String query = "INSERT INTO `TestHeader` (`GradeId`, `TestName`, `TestTypeId`, `DifficultyLevel`, `StartDateTime`, "
						+ "`EndDateTime`, `CreatedBy`, `CreationDate`, `LastUpdatedBy`, `LastUpdateDate`) VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())";
				appJdbcTemplate.update(query, data.getGradeId(), data.getTestName(), data.getTestTypeId(),
						data.getDifficultyLevel(), data.getStartDateTime(), data.getEndDateTime(), username, username);

				// Get Last Insert Id
				examId = (int) appJdbcTemplate.queryForObject(
						"SELECT TestId FROM TestHeader ORDER BY TestId DESC LIMIT 1", new Object[] {}, Integer.class);
				LOG.log(Level.INFO, "examId:" + examId);

				// Set Exam Subjects
				for (TestLineDTO testLine : data.getSubjects()) {
					if (testLine.getIsSelected()) {
						String sql = "INSERT INTO `TestLine` (`TestHeaderId`, `SubjectId`, `NoOfQuestion`, `CreatedBy`, `CreationDate`, `LastUpdatedBy`, `LastUpdateDate`)\r\n"
								+ "VALUES (?, ?, ?, ?, NOW(), ?, NOW())";
						appJdbcTemplate.update(sql, examId, testLine.getSubjectId(), testLine.getNoOfQuestion(),
								username, username);
					}
				}
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Exam:" + e.getMessage());
			throw new CustomException("Error while creating a new Exam:" + e.getMessage());
		}
		return examId;
	}

	@Override
	public List<ManageExamDTO> getExamList() {
		List<ManageExamDTO> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getExamList DAO");
		try {
			String query = "SELECT TestId, GradeId, TestName, IsActive, DifficultyLevel, StartDateTime, CreatedBy, CreationDate, LastUpdatedBy, LastUpdateDate FROM `TestHeader` ORDER BY TestId DESC";
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				ManageExamDTO exam = new ManageExamDTO();
				exam.setTestId(result.getInt("TestId"));
				exam.setTestName(result.getString("TestName"));
				exam.setStartDateTime(result.getString("StartDateTime"));
				exam.setIsActive(result.getInt("IsActive") > 0 ? true : false);
				exam.setCreatedBy(result.getString("CreatedBy"));
				list.add(exam);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Exam list:" + e.getMessage());
			throw new CustomException("Error while fetching Exam List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getExamList DAO");
		return list;
	}

	@Override
	public ManageMcqDTO getMCQDetails(Integer mcqId) {
		ManageMcqDTO mcq = new ManageMcqDTO();
		LOG.log(Level.INFO, () -> "Start getMCQDetails DAO");
		try {
			String query = "SELECT McqId, LessonId, Question, QuestionDesc, QuestionOptionsJson, IsActive, Answer, Solution, DifficultyLevel, CreatedBy, LastUpdatedBy, CreationDate, LastUpdateDate "
					+ "FROM Mcq WHERE McqId=?";
			appJdbcTemplate.query(query, new Object[] { mcqId }, (result, rowNum) -> {
				mcq.setMcqId(result.getLong("McqId"));
				mcq.setLessonId(result.getLong("LessonId"));
				mcq.setQuestion(result.getString("Question"));
				mcq.setQuestionDesc(result.getString("QuestionDesc"));
				mcq.setQuestionOptionsJson(
						new Gson().fromJson(result.getString("QuestionOptionsJson"), ManageMcqOptionsDTO[].class));
				mcq.setSolution(result.getString("Solution"));
				mcq.setAnswer(result.getString("Answer"));
				mcq.setDifficultyLevel(result.getInt("DifficultyLevel"));
				return mcq;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching MCQ Details:" + e.getMessage());
			throw new CustomException("Error while fetching MCQ Details:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getMCQDetails DAO");
		return mcq;
	}

}

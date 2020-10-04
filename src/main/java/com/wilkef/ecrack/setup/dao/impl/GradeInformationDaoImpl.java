/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.GradeInformationDao;
import com.wilkef.ecrack.setup.dto.GradeInformationDTO;

/**
 * @author Chinmaya.dehury
 *
 *         29-Sep-2020
 *
 */

@Repository
public class GradeInformationDaoImpl implements GradeInformationDao {

	public static final Logger LOG = Logger.getLogger(GradeInformationDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	List<GradeInformationDTO> gradeInfoList = null;

	@Override
	public List<GradeInformationDTO> fetchGradeInformationByBoard(int boardId) {

		LOG.log(Level.INFO, () -> "Board ID as parameter : : " + boardId);
		try {
			gradeInfoList = jdbcTemplate.query(WilkefConstants.GRADE_INFO_BY_BOARDID, new Object[] { boardId },
					(rs, rowNum) -> {
						GradeInformationDTO gradeInfoDto = new GradeInformationDTO();
						gradeInfoDto.setBoardId(boardId);
						gradeInfoDto.setGradeCode(rs.getInt(1));
						gradeInfoDto.setGradeId(rs.getInt(2));
						gradeInfoDto.setGradeName(rs.getString(3));
						return gradeInfoDto;
					});
		} catch (Exception exception) {
			LOG.log(Level.SEVERE,
					() -> "Exception occured while fetching data from database : : " + exception.getMessage());
		}
		LOG.log(Level.INFO, () -> "Grade info list : : " + gradeInfoList);
		return gradeInfoList;
	}

}

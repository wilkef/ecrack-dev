/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dao.AskYourDoubtDao;
import com.wilkef.ecrack.setup.dto.AskYourDoubt;

/**
 * @author Satya Nov 5, 2020
 */

@Repository
public class AskYourDoubtDaoImpl implements AskYourDoubtDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(AskYourDoubtDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Integer saveDoubt(AskYourDoubt askDoubt) {
		String sql = "insert into Doubt values(?,?,?,?,?,?,?)";
		return appJdbcTemplate.update(sql, askDoubt.getDoubtId(), askDoubt.getStudentId(), askDoubt.getSubjectId(),
				askDoubt.getLessonId(), askDoubt.getStatus(), askDoubt.getDoubt(), askDoubt.getDoubtPath());
	}
}

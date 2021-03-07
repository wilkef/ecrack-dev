/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dao.InquiryDao;
import com.wilkef.ecrack.setup.dto.InquiryDataDto;

/**
 * @author Satya Dec 2, 2020
 */

@Repository
public class InquiryDaoImpl implements InquiryDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(InquiryDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Integer saveInquiry(InquiryDataDto inquiry) {
		try {
			String sql = "INSERT INTO `Inquiry` (`Name`, `PhoneNumber`, `Email`, `Subject`, `Message`, `CreatedAt`)\r\n"
					+ "VALUES (?, ?, ?, ?, ?, NOW())";
			return appJdbcTemplate.update(sql, inquiry.getName(), inquiry.getPhone(), inquiry.getEmail(),
					inquiry.getSubject(), inquiry.getMessage());
		} catch (Exception e) {
			LOG.log(Level.INFO, () -> "Error in DAO" + e.getMessage());
			return 0;
		}
	}
}

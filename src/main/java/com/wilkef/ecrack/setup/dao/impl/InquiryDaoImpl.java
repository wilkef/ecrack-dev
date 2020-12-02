/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dao.InquiryDao;
import com.wilkef.ecrack.setup.dto.InquiryDataDto;

/**
 * @author Satya
 *Dec 2, 2020
 */

@Repository
public class InquiryDaoImpl implements InquiryDao{
	
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(InquiryDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public Integer saveInquiry(InquiryDataDto inquiry) {
		String sql = "insert into Inquiry values(?,?,?,?,?)";
		return appJdbcTemplate.update(sql, inquiry.getInquiryId(), inquiry.getName(), inquiry.getPhoneNumber(),
				inquiry.getEmail(), inquiry.getMessage());
	}
}

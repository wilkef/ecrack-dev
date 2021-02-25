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

import com.wilkef.ecrack.setup.admin.dao.ManageStudentDao;
import com.wilkef.ecrack.setup.admin.dto.ManageStudentDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageStudentDaoImpl implements ManageStudentDao {

	public static final Logger LOG = Logger.getLogger(ManageStudentDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

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

	@Override
	public Boolean saveStudent(ManageStudentDTO data, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageStudentDTO getStudentDetails(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}

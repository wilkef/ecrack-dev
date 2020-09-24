/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.TestTypeListDao;
import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;
import com.wilkef.ecrack.setup.service.TestTypeListService;


/**
 * The Class TestTypeListServiceImpl.
 *
 * @author Satya
 * Sep 20, 2020
 */

@Service
public class TestTypeListServiceImpl implements TestTypeListService{

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(TestTypeListServiceImpl.class.getName());
	
	/** The test type dao. */
	@Autowired
	private TestTypeListDao testTypeDao;
	
	/**
	 * Find all test type list.
	 *
	 * @return the list
	 */
	@Override
	public List<TestTypeListDataDTO> findAllTestTypeList() {
		List<TestTypeListDataDTO> findAllTestTypeList =null;
		try {
			findAllTestTypeList = testTypeDao.findAllTestTypeList();
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With TestTypeList : " + exception.getMessage());
		}
		return findAllTestTypeList;
	}

}

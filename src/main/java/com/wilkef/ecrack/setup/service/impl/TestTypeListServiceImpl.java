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
 * @author Satya
 *Sep 20, 2020
 */

@Service
public class TestTypeListServiceImpl implements TestTypeListService{

	public static final Logger LOG = Logger.getLogger(TestTypeListServiceImpl.class.getName());
	
	@Autowired
	private TestTypeListDao testTypeDao;
	
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

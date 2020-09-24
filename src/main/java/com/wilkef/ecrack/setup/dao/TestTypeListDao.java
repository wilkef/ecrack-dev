/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;

/**
 * The Interface TestTypeListDao.
 *
 * @author Satya
 * Sep 20, 2020
 */
public interface TestTypeListDao {
	
	/**
	 * Find all test type list.
	 *
	 * @return the list
	 */
	public List<TestTypeListDataDTO> findAllTestTypeList();
}

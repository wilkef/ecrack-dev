/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;

/**
 * @author Satya
 * Sep 20, 2020
 */
public interface TestTypeListDao {
	public List<TestTypeListDataDTO> findAllTestTypeList();
}

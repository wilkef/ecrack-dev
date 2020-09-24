/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;


/**
 * The Interface TestTypeListService.
 *
 * @author Satya
 * Sep 20, 2020
 */
public interface TestTypeListService {
	
	/**
	 * Find all test type list.
	 *
	 * @return the list
	 */
	public List<TestTypeListDataDTO> findAllTestTypeList();
}

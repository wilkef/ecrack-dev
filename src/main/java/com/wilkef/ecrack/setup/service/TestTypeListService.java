/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;

/**
 * @author Satya
 *Sep 20, 2020
 */
public interface TestTypeListService {
	public List<TestTypeListDataDTO> findAllTestTypeList();
}

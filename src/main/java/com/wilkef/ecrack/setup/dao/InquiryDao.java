/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.InquiryDataDto;

/**
 * @author Satya
 *Dec 2, 2020
 */
public interface InquiryDao {
	public Integer saveInquiry(InquiryDataDto inquiry);
}

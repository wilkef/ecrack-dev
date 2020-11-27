/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

/**
 * The Interface ForgotPasswordDao.
 *
 * @author Pradeepta Khatoi Nov 24, 2020
 */
public interface ForgotPasswordDao {

	public String setVerificationCode(String mobileNo);

	public boolean removeVerificationCode(String mobileNo);
}

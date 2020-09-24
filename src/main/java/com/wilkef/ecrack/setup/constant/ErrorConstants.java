/**
 * 
 */
package com.wilkef.ecrack.setup.constant;

/**
 * @author chinmaya.dehury All kinds of Wilkef related error constants must
 *         present here as constants to use. Specific error codes have specific
 *         error entries in the database.
 *
 */
public class ErrorConstants {
	private ErrorConstants() {}

	public static final String USER_NOT_EXISTS = "User Does Not Exist";
	public static final String USER_ALREADY_EXISTS = "User Already Exists";
	public static final String SMTHNG_WNT_WRONG="something wrong while fetching the information  ";
	public static final String NO_RECORD_FOUND="No Record Found";
	public static final String INVALID_CUSTOMER="Invalid UserName ";
	public static final String UNABLE_TO_STORE= "Unable to Store Record";
	
	public static final String ANSWER_STATUS_FAILED="answerStatus is Not There in DB ";
	
	public static final String PASSWORD_MISMATCH="NewPasswor And ConformPassword Both Are not Same ";
	
	public static final String PROMPT_VALID_PASSWORD="Please Enter NewPassword and ConformPassword Both are Same";
}

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
	private ErrorConstants() {
	}

	public static final String USER_NOT_EXISTS = "User Does Not Exist";
	public static final String USER_ALREADY_EXISTS = "User Already Exists";
	public static final String SMTHNG_WNT_WRONG = "something wrong while fetching the information  ";
	public static final String NO_RECORD_FOUND = "No Record Found";
	public static final String INVALID_USER = "Invalid UserName ";
	public static final String INVALID_USER_PWD = "Invalid UserName and Password";
	public static final String UNABLE_TO_STORE = "Unable to Store Record";

	public static final String ANSWER_STATUS_FAILED = "answerStatus is Not There in DB ";

	public static final String PASSWORD_MISMATCH = "NewPasswor And ConformPassword Does not Same ";

	public static final String PROMPT_VALID_PASSWORD = "Please Enter NewPassword and ConformPassword Both are Same";

	public static final String OTP_ERROR = "something wrong while sending OTP";

	public static final String BOARD_STATUS = "Board is Not There in DB ";

	public static final String SESSION_NOT_CREATED = "Session not created";

	public static final String SESSION_INACTIVE_FAIL = "Session Logout not Successful";

	public static final String PURPOSE_NOT_VALID = "Purpose code is not valid";

	public static final String SEND_OTP_REG = "RGSTRN";

	public static final String SEND_OTP_FRGT = "FRGTPWD";

	public static final String IS_SUCCESS = "isSuccess";

}

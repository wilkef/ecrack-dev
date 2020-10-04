/**
 * 
 */
package com.wilkef.ecrack.setup.constant;

/**
 * @author Satya
 *Oct 3, 2020
 */
public class UnAutherziedApiConstant {
	
	/**
	 * 
	 */
	private UnAutherziedApiConstant() {
	}
	
	public static final String GET_REGISTER = "/user/register";
	
	public static final String GET_BOARD = "/user/boardList";
	
	public static final String GET_VALIDMAILID = "/user/validateEmailId";
	
	public static final String GET_VALIDATELOGIN = "/user/validateLogin";
	
	public static final String GET_VERIFYOTP = "/user/VerifyOTP/{otp}/{mobileNo}";
	
	public static final String GET_VALIDMOBILENO = "/user/validateMobileNumber/{mobileNo}";
	
	public static final String GET_SENDOTP = "/user/SendOTP/{mobileNo}";

	public static final String GET_FORGOTPWD = "/user/forgotPassword";
	
	public static final String GET_GRADE_INFO = "/grade/gradeInfo/{boardId}";
}

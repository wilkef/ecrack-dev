/**
 * 
 */
package com.wilkef.ecrack.setup.constant;

/**
 * @author Satya Oct 3, 2020
 */
public class UnAutherziedApiConstant {

	/**
	 * 
	 */
	private UnAutherziedApiConstant() {
	}

	public static final String GET_REGISTER = "/user/register";

	public static final String GET_BOARD = "/user/boardList";

	public static final String GET_VALID_EMAIL_ID = "/user/validateEmailId";

	public static final String GET_VALIDATE_LOGIN = "/user/validateLogin";

	public static final String GET_VERIFY_OTP = "/user/VerifyOTP/{otp}/{mobileNo}";

	public static final String GET_VALIDMOBILE_NO = "/user/validateMobileNumber/{mobileNo}";

	public static final String GET_SEND_OTP = "/user/SendOTP/{mobileNo}";

	public static final String GET_FORGOT_PWD = "/user/forgotPassword";

	public static final String GET_GRADE_INFO = "/grade/gradeInfo/{boardId}";
}

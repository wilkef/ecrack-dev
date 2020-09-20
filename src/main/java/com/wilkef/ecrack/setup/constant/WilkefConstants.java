/*
 * 
 */
package com.wilkef.ecrack.setup.constant;


/**
 * *.
 *
 * @author chinmaya.dehury This class is created to contain all the information
 *         related to static queries that will be used.
 */

public final class WilkefConstants {

	/**
	 * Instantiates a new wilkef constants.
	 */
	private WilkefConstants() {
	}

	/** The Constant GET_UNIT_DETAIL. */
	public static final String GET_UNIT_DETAIL = "Select UnitId ,UnitName ,SubjectId from Unit";
	
	/** The Constant GET_QUESTIONLEVEL_DETAIL. */
	public static final String GET_QUESTIONLEVEL_DETAIL = "SELECT DifficultyId,DifficultyCode from QuestionLevel";
	
	/** The Constant GET_SUBJECTBYGRADEID. */
	public static final String GET_SUBJECTBYGRADEID = "spGetAllSubjectByClassId";
	
	public static final String GET_UNITLISTBYSUBJECTID = "spGetAllUnitBySubjectId";
	
	public static final String GET_LESSIONLISTBYUNITID = "spGetAllLessonByUnitId";

	public static final String RESETPASSWORD = "spResetPassword";
	
	public static final String FORGOTPASSWORD = "spForgotPassword";
	
	public static final String REGISTRATION = "spSignupUser";
	
	/** The Constant VALIDATE_EMAIL. */
	public static final String VALIDATE_EMAIL="spValidateEmailId";
	
	/** The Constant VALIDATE_MOBILE. */
	public static final String VALIDATE_MOBILE="spValidateMobileNumber";
	
	/** The Constant SAVE_OTP. */
	public static final String SAVE_OTP="spSaveOTP";
	
	/** The Constant VERIFY_OTP. */
	public static final String VERIFY_OTP="spVerifyOTP";


}

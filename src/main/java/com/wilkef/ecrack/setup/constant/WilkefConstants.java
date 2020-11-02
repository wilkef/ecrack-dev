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
	
	public static final String GET_CITY_LIST = "Select CityId,CityName from City";

	/** The Constant GET_QUESTIONLEVEL_DETAIL. */
	public static final String GET_QUESTIONLEVEL_DETAIL = "SELECT DifficultyId,DifficultyCode from QuestionLevel";

	/** #####Added By Satya **/

	/** The Constant GET_SUBJECTBYGRADEID. */
	public static final String GET_SUBJECTBYGRADEID = "spGetAllSubjectByClassId";

	public static final String GET_UNITLISTBYSUBJECTID = "spGetAllUnitBySubjectId";

	public static final String GET_LESSIONLISTBYUNITID = "spGetAllLessonByUnitId";

	/** ######Added By Rajni */

	public static final String RESETPASSWORD = "spResetPassword";

	public static final String FORGOTPASSWORD = "spForgotPassword";

	public static final String REGISTRATION = "spSignupUser";

	public static final String TEST_TYPE_LIST = "spGetTestTypeList";

	public static final String ANSWER_STATUS_LIST = "spGetAnswerStatusList";

	public static final String PRACTICE_TEST_INFO = "spGetPracticeTestInfo";

	public static final String BOARD_INFO = "spGetBoard";

	/** The Constant VALIDATE_EMAIL. */
	public static final String VALIDATE_EMAIL = "spValidateEmailId";

	/** The Constant VALIDATE_MOBILE. */
	public static final String VALIDATE_MOBILE = "spValidateMobileNumber";

	/** The Constant SAVE_OTP. */
	public static final String SAVE_OTP = "spSaveOTP";

	/** The Constant VERIFY_OTP. */
	public static final String VERIFY_OTP = "spVerifyOTP";

	public static final String GET_SCHLD_TEST = "spGetScheduledTest";

	public static final String GET_QUIZ_QSTN = "spGetQuizQuestions";

	public static final String GET_QUESTION = "spGetQuestions";

	public static final String STUDENT_RESULT_SUMRY = "spGetStudentResultSummary";

	public static final String UPDATE_PROFILE = "spUpdateProfile";

	public static final String VIEW_PROFILE = "spViewProfile";

	public static final String SAVE_STUDENT_RESULT = "spSaveStudentTestResult";

	public static final String VALIDATE_LOGIN = "spValidateLogin";

	public static final String OTP_MSG_1 = "Your verification code is ";
	
	public static final String OTP_MSG_2 = ".Happy Learning !! Wilkef";
	
	public static final String GRADE_INFO_BY_BOARDID = "select GradeCode, GradeId, GradeName from Grade where BoardId = ?";
		
	public static final String SESSION_LOGIN = "spSessionLogin";
	
	public static final String SESSION_LOGOUT = "spSessionLogout";
	
	public static final String SET_ACTIVE_STATUS="update Login set IsActive = ? where UserName = ? and Password =? ";
	
	public static final String TOKEN_RETURN = "SELECT u.MobileNumber, u.EmailId, u.FirstName, u.LastName, e.GradeId, g.GradeName FROM User u INNER JOIN StudentEnv e ON(u.userid = e.UserId) INNER JOIN Grade g ON(g.GradeId = e.GradeId) WHERE u.MobileNumber=?";
	
	public static final String VIDEO_SUGGESTION = "SELECT l.LessonId,l.LessonName,l.VideoUrl,l.LessonThumbnail,l.LessonThumbnail_Mob FROM WatchedVideo w INNER JOIN Lesson l ON(w.LessonId=l.LessonId) GROUP BY w.LessonId";
}

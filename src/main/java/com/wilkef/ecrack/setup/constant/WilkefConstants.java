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

	/** Constants related to authentication */
	public static final String AUTH_HEADER = "Authorization";
	public static final String AUTH_HEADER_PREFIX = "Bearer ";
	public static final String JWT_SECRET = "mySecretKey";

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
	
	public static final String CHECK_LOGIN = "SELECT l.UserId FROM Login l WHERE l.UserName=? AND l.Password=?";

	public static final String SET_ACTIVE_STATUS = "update Login set IsActive = ? where UserName = ? and Password =? ";

	public static final String TOKEN_RETURN = "SELECT u.UserTypeId, u.MobileNumber, u.EmailId, u.FirstName, u.MiddleName, u.LastName, "
			+ "CONCAT(FirstName, ' ', MiddleName, ' ', LastName) as Name, e.GradeId, g.GradeName "
			+ "FROM User u LEFT JOIN StudentEnv e ON(u.userid = e.UserId) LEFT JOIN Grade g ON(g.GradeId = e.GradeId) WHERE u.MobileNumber=?";

	public static final String LOGGEDIN_USER_INFO = "SELECT u.userid, u.MobileNumber, u.EmailId, u.FirstName, u.MiddleName, u.LastName, "
			+ "CONCAT(FirstName, ' ', MiddleName, ' ', LastName) as Name, e.GradeId  "
			+ "FROM User u INNER JOIN StudentEnv e ON(u.userid = e.UserId) WHERE u.MobileNumber=?";

	public static final String VIDEO_SUGGESTION = "SELECT l.LessonId,l.LessonName,l.VideoUrl,l.LessonThumbnail,l.LessonThumbnail_Mob, l.videoId "
			+ "FROM WatchedVideo w INNER JOIN Lesson l ON(w.LessonId=l.LessonId) GROUP BY w.LessonId";

	public static final String LESSON_DETAILS = "SELECT s.SubjectName,s.SubjectId,u.UnitId, u.UnitName, l.LessonName, l.VideoUrl, l.LessonThumbnail, f.FavoriteVideoId "
			+ "FROM Lesson l INNER JOIN Unit u ON(l.UnitId=u.UnitId) INNER JOIN Subject s ON(s.SubjectId=u.SubjectId) "
			+ "LEFT JOIN FavoriteVideo f ON(f.LessonId=l.LessonId) WHERE l.LessonId=?";

	public static final String GET_PASSWORD = "SELECT l.Password FROM Login l WHERE l.UserId=?";

	public static final String MOST_WATCHED_VIDEOS = "SELECT w.WatchedVideoId, w.UserId, w.LessonId, w.StartDateTime, w.EndDateTime, "
			+ "l.LessonId, l.LessonName, l.LessonThumbnail FROM WatchedVideo w INNER JOIN Lesson l ON(w.LessonId = l.LessonId) "
			+ "WHERE w.UserId=? GROUP BY w.WatchedVideoId ORDER BY TimeWatched DESC LIMIT 6";

	public static final String SUGGESTED_VIDEOS = "SELECT VideoId, LessonId, LessonName, LessonThumbnail, UnitId, VideoUrl FROM Lesson \r\n"
			+ "WHERE IsActive=1 AND lessonThumbnail IS NOT NULL AND VideoId NOT IN(SELECT cast(WatchedVideoId As CHAR) "
			+ "FROM WatchedVideo WHERE UserId=?) LIMIT 6";

	public static final String CHECK_MOB_AVAILABILITY = "SELECT count(*) FROM Login WHERE UserName = ?";
	
	public static final String SET_VERIFICATION_CDOE = "UPDATE Login SET VerificationCode = ? WHERE UserName = ?";
	
	public static final String RESET_PASSWORD = "UPDATE Login SET Password=?, VerificationCode=? WHERE UserName=? AND VerificationCode=?";
	
	public static final String CHECK_WATCHED_VIDEO = "SELECT COUNT(*) FROM WatchedVideo WHERE LessonId = ? AND UserId = ?";
	
	public static final String SAVE_WATCHED_VIDEO = "INSERT INTO WatchedVideo (UserId, LessonId, StartDateTime, EndDateTime, WatchCount, TimeWatched) "
			+ "VALUES (?, ?, NOW(), NOW(), 1, ?)";	
	
	public static final String UPDATE_WATCHED_VIDEO = "UPDATE WatchedVideo SET TimeWatched=?, EndDateTime=NOW(),  WatchCount = WatchCount + 1 "
			+ "WHERE UserId=? AND LessonId=?";
	
	public static final String CHECK_FAVORITE_VIDEO = "SELECT COUNT(*) FROM FavoriteVideo WHERE LessonId = ? AND UserId = ?";
	public static final String ADD_FAVORITE_VIDEO = "INSERT INTO FavoriteVideo (LessonId, UserId) VALUES (?, ?)";	
	public static final String REMOVE_FAVORITE_VIDEO = "DELETE FROM FavoriteVideo WHERE LessonId=? AND UserId=?";
	public static final String FAVORITE_VIDEO_LIST = "SELECT f.FavoriteVideoId, f.UserId, l.LessonId, l.LessonName, l.LessonThumbnail, l.VideoUrl "
			+ "FROM FavoriteVideo f INNER JOIN Lesson l ON(f.LessonId = l.LessonId) WHERE f.UserId=? ORDER BY f.FavoriteVideoId DESC";

}





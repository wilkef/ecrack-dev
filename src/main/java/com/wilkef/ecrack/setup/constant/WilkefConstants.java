package com.wilkef.ecrack.setup.constant;

/***
 * 
 * @author chinmaya.dehury This class is created to contain all the information
 *         related to static queries that will be used.
 *
 */

public final class WilkefConstants {

	private WilkefConstants() {
		// restrict instantiation
	}

	public static final String GET_UNIT_DETAIL = "Select UnitId ,UnitName ,SubjectId from Unit";
	
	public static final String GET_QUESTIONLEVEL_DETAIL = "SELECT DifficultyId,DifficultyCode from QuestionLevel";
	
	public static final String GET_SUBJECTBYGRADEID = "spGetAllSubjectByClassId";

}

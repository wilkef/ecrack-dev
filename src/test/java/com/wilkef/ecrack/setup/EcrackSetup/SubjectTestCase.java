/**
 * 
 * @author Satya
 * Sep 25, 2020
 */

package com.wilkef.ecrack.setup.EcrackSetup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wilkef.ecrack.setup.controller.LessionListController;
import com.wilkef.ecrack.setup.controller.SubjectController;
import com.wilkef.ecrack.setup.controller.UnitListController;
import com.wilkef.ecrack.setup.dao.LessionListDao;
import com.wilkef.ecrack.setup.dao.SubjectDao;
import com.wilkef.ecrack.setup.dao.UnitListDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;
import com.wilkef.ecrack.setup.dto.UnitListDataDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectTestCase {

	/** The Lession status controller. */
	@Autowired
	private LessionListController lessionListController;
	
	/** The Lession status dao. */
	@MockBean
	private LessionListDao lessionDao;
	
	/**
	 * Test Lession test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void lessionTest() {
		
		List<LessionListDataDTO> listOfLession = new ArrayList<>();
		
		LessionListDataDTO lessionList =new LessionListDataDTO();
		
		lessionList.setLessonId(1);
		lessionList.setLessonMark(20);
		lessionList.setLessonName("Real Number");
		lessionList.setLessonSerial(1);
		lessionList.setNoOfPeriod(20);
		lessionList.setNoOfQuestion(10);
		lessionList.setUnitName("Number System");
		lessionList.setVideoId("viemo-0");
		lessionList.setVideoUrl("viemo-001");
		
		listOfLession.add(lessionList);
		
		Integer unitId = 1;
		Mockito.when(lessionDao.findByUnitId(unitId)).thenReturn(listOfLession);
		assertEquals(1, ((List<LessionListDataDTO>)lessionListController.findByGradeId(unitId).getBody()).size());
	}
	
	/**
	 * This Test Method to Identify Subject TestCase Method
	 */
	
	/** The Subject status controller. */
	@Autowired
	private SubjectController subjectController;
	
	/** The Subject status dao. */
	@MockBean
	private SubjectDao subjectDao;
	
	/**
	 * Test Subject test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void subjectTest() {
		
		List<SubjectDataDTO> subjectList =new ArrayList<SubjectDataDTO>();
		
		SubjectDataDTO subject =new SubjectDataDTO();
		
		subject.setGradeName("CBSE-9");
		subject.setMaxMark(100);
		subject.setNoOfPeriod(20);
		subject.setSubjectCode("MATH");
		subject.setSubjectId(1);
		subject.setSubjectName("Mathmatics");
		subjectList.add(subject);
		
		int gradeId=1;
		Mockito.when(subjectDao.findByGradeId(gradeId)).thenReturn(subjectList);
		assertEquals(1, ((List<SubjectDataDTO>)subjectController.findByGradeId(gradeId).getBody()).size());
	}
	
	/**
	 * This Test Method to Identify Subject TestCase Method
	 */
	
	/** The UnitList status controller. */
	@Autowired
	private UnitListController unitListController;
	
	/** The UnitList status dao. */
	@MockBean
	private UnitListDao unitListDao;
	
	/**
	 * Test UnitList test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void UnitListTest() {
		List<UnitListDataDTO> unitListData =new ArrayList<>(); 
		
		UnitListDataDTO unitList =new UnitListDataDTO();
		unitList.setMaxMark(20);
		unitList.setNoOfPeriod(20);
		unitList.setSubjectId(1);
		unitList.setSubjectName("Mathmatics");
		unitList.setUnitId(1);
		unitList.setUnitName("Number System");
		unitList.setUnitSerial(1);
		
		unitListData.add(unitList);
		int subjectId =1;
		
		Mockito.when(unitListDao.findBySubjectId(subjectId)).thenReturn(unitListData);
		assertEquals(1, ((List<UnitListDataDTO>)unitListController.findByClassId(subjectId).getBody()).size());
	}
}
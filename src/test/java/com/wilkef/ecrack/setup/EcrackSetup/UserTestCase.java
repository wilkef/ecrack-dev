/**
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.wilkef.ecrack.setup.controller.ForgotPasswordController;
import com.wilkef.ecrack.setup.controller.QuestionLevelController;
//import com.wilkef.ecrack.setup.controller.ResetPasswordController;
import com.wilkef.ecrack.setup.controller.UserProfileController;
import com.wilkef.ecrack.setup.controller.ValidationController;
import com.wilkef.ecrack.setup.dao.ForgotPasswordDao;
import com.wilkef.ecrack.setup.dao.QuestionLevelDao;
import com.wilkef.ecrack.setup.dao.ResetPasswordDao;
import com.wilkef.ecrack.setup.dao.UserProfileDao;
import com.wilkef.ecrack.setup.dao.ValidationDao;
//import com.wilkef.ecrack.setup.dto.ForgotPasswordDataDTO;
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;
import com.wilkef.ecrack.setup.dto.ResetPasswordDataDTO;
import com.wilkef.ecrack.setup.dto.UserProfileDTO;
import com.wilkef.ecrack.setup.dto.ValidationDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestCase {

	/** The UserTest status controller. */
	@Autowired
	private QuestionLevelController questionLevelController;

	/** The UserTest status dao. */
	@MockBean
	private QuestionLevelDao questionDao;

	/**
	 * Test UserTest test.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void questionLevelTest() {
		List<QuestionLevelDataDTO> listQuestionLevel = new ArrayList<QuestionLevelDataDTO>();

		QuestionLevelDataDTO questionLevel = new QuestionLevelDataDTO();
		questionLevel.setDifficultyId(1);
		questionLevel.setDifficultyCode("Easy");
		listQuestionLevel.add(questionLevel);

		Mockito.when(questionDao.findQuestionLevel()).thenReturn(listQuestionLevel);
		assertEquals(1, ((List<QuestionLevelDataDTO>)questionLevelController.findDifficultyCode().getBody()).size());
	}


	/**
	 * This Test Method to Identify ResetPassword TestCase Method
	 */


	/** The ResetPassword status controller. */
//	@Autowired
//	private ResetPasswordController resetPwdController; 

	/** The ResetPassword status dao. */
	@MockBean
	private ResetPasswordDao resetPwdDao;

	/**
	 * Test ResetPassword test.
	 */
//	@Test
//	public void resetPwdTest() {
//		ResetPasswordDataDTO resetPwd = new ResetPasswordDataDTO();
//		resetPwd.setUserName("7008508931");
//		resetPwd.setNewPassword("Tanmay@12345");
//
//		Mockito.when(resetPwdDao.resetPassword(resetPwd)).thenReturn(1);
//		assertEquals(200, ((ResponseEntity<Object>)resetPwdController.resetPwd(resetPwd)).getStatusCodeValue());
//	}


	/**
	 * This Test Method to Identify ForgotPassword TestCase Method
	 */


	/** The ForgotPassword status controller. */
	@Autowired
	private ForgotPasswordController forgotPwdController;

	/** The ForgotPassword status dao. */
	@MockBean
	private ForgotPasswordDao forgotPwdDao;

	/**
	 * Test ForgotPassword test.
	 */
//	@Test
//	public void forgotPwd() {
//		ForgotPasswordDataDTO forgotPwdDto = new ForgotPasswordDataDTO();
//		forgotPwdDto.setUserName(7008508931l);
//		forgotPwdDto.setNewPassword("Satya@123");
//		forgotPwdDto.setConfirmPassword("Satya@123");
//
//		Mockito.when(forgotPwdDao.forgotPassword(forgotPwdDto)).thenReturn(1);
//		assertEquals(200, ((ResponseEntity<Object>)forgotPwdController.forgotPassword(forgotPwdDto)).getStatusCodeValue());
//
//	}


	/**
	 * This Test Method to Identify UserProfile TestCase Method
	 */

	/** The UserProfile status controller. */
	@Autowired
	private UserProfileController userProfileController;

	/** The UserProfile status dao. */
	@MockBean
	private UserProfileDao userProfileDao;

	/**
	 * Test UpdateProfile test.
	 */
//	@Test
//	public void updateProfile() {
//		List<UserProfileDTO> userProfileList = new ArrayList<>();
//
//		UserProfileDTO userProfile = new UserProfileDTO();
//		userProfile.setUpdateCount(1);
//
//		userProfileList.add(userProfile);
//
//		String input= "satya.patra@wilkef.com";
//
//		Mockito.when(userProfileDao.updateProfile(input)).thenReturn(userProfileList);
//		assertEquals(200, ((ResponseEntity<Object>)userProfileController.updateProfile(input)).getStatusCodeValue());
//
//	}

	@Autowired
	private ValidationController validationController ;

	@MockBean
	private ValidationDao validationDao;

	/**
	 * Test ValidMobileNo test.
	 */
	@Test
	public void validMobileNo() {
		List<ValidationDTO> validMobileList = new ArrayList<>();
		ValidationDTO validMobile = new ValidationDTO();
		validMobile.setP_isValidMobile(1);

		validMobileList.add(validMobile);
		String mobileNo = "7008508931";

		Mockito.when(validationDao.validateMobileNo(mobileNo)).thenReturn(validMobileList);
		assertEquals(200, ((ResponseEntity<Object>)validationController.validateMobileNo(mobileNo)).getStatusCodeValue());
	}

	
	/**
	 * Test VarifyOtp test.
	 */
	@Test
	public void varifyOtp() {
		String msg = "OTP Verified";

		String mobileNo = "7008508931";
		String otp = "897345";

		Mockito.when(validationDao.verifyOtp(otp, mobileNo)).thenReturn(msg);
		assertEquals(200, ((ResponseEntity<Object>)validationController.verifyOtp(otp, mobileNo)).getStatusCodeValue());
	}

	/**
	 * Test SendOtp test.
	 */
	@Test
	public void sendOtp() {
		List<ValidationDTO> saveOtpList = new ArrayList<>();
		ValidationDTO valid = new ValidationDTO();
		valid.setP_otp("234567");
		saveOtpList.add(valid);

		String mobileNo = "7008508931";

		Mockito.when(validationDao.saveOtp(mobileNo)).thenReturn(saveOtpList);
		assertEquals(200, ((ResponseEntity<Object>)validationController.sendOTP(mobileNo)).getStatusCodeValue());
	}
}


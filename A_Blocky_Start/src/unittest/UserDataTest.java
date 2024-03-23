package unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import mvc.ProgressionData;
import mvc.UserData;
import mvc.UserTypeEnum;

/**
 * Unit test for UserData.
 * @version 0.3
 * @since Mar 14, 2024
 * @author Eunhak Kim
 */
class UserDataTest {

	/**
	 * Test method for {@link mvc.UserData#UserData(mvc.UserTypeEnum, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUserData() {
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataUserType() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getUserType(), UserTypeEnum.STUDENT);
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataUsername() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getUsername(), "student");
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataPassword() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getPassword(), "pass1234");	
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataTotalScore() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getTotalScore(), 6);
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataTotalTimeSpent() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getTotalTimeSpent(), 70);
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataTotalAttempts() {
		UserData ud = UserData.importData("student");
		assertEquals(ud.getTotalAttempts(), 10);
	}
	
	/**
	 * Test method for {@link mvc.UserData#importData(java.lang.String)}.
	 */
	@Test
	void testImportDataProgression() {
		UserData ud = UserData.importData("student");
		int result = ud.getProgressionAtIndex(1).getTimeSpent();
		assertEquals(result, 20);
	}

	/**
	 * Test method for {@link mvc.UserData#exportUserData()}.
	 */
	@Test
	void testExportUserData() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
		ud.addTotalScore(6);
		ud.addTotalTimeSpent(70);
		ud.addTotalAttempts(10);
		
		String stage1 = "1,TRUE,1,3,20,2,/,Start,Forward,End";
		ProgressionData pd = ProgressionData.importData(stage1);
		ud.addProgressionData(pd);
		
		String stage2 = "2,TRUE,3,3,50,8,/,Start,Forward,Left,Forward,End";
		pd = ProgressionData.importData(stage2);
		ud.addProgressionData(pd);
		
		ud.exportUserData();

		String filename = UserData.toFilename("student");
//		FileReader fileIn = new FileReader(filename);
//		Scanner scnr = new Scanner(fileIn);
//		scnr.useDelimiter(","); // since this is a CSV file
	}

	/**
	 * Test method for {@link mvc.UserData#toFilename(String)}.
	 */
	@Test
	void testToFilename() {
		String filename = "./userdata/student_userdata.csv";
		assertEquals(UserData.toFilename("student"), filename);
	}

	/**
	 * Test method for {@link mvc.UserData#getUserType()}.
	 */
	@Test
	void testGetUserType() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getUsername()}.
	 */
	@Test
	void testGetUsername() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getTotalScore()}.
	 */
	@Test
	void testGetTotalScore() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getTotalTimeSpent()}.
	 */
	@Test
	void testGetTotalTimeSpent() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getTotalAttempts()}.
	 */
	@Test
	void testGetTotalAttempts() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getProgressionList()}.
	 */
	@Test
	void testGetProgressionList() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#getProgressionAtIndex(int)}.
	 */
	@Test
	void testGetProgressionAtIndex() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#addTotalScore(int)}.
	 */
	@Test
	void testAddTotalScore() {
		UserData ud = new UserData(UserTypeEnum.STUDENT, "student", "pass1234");
	}

	/**
	 * Test method for {@link mvc.UserData#addTotalTimeSpent(int)}.
	 */
	@Test
	void testAddTotalTimeSpent() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#addTotalAttempts(int)}.
	 */
	@Test
	void testAddTotalAttempts() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#updateTotalStats()}.
	 */
	@Test
	void testUpdateTotalStats() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#isStudent()}.
	 */
	@Test
	void testIsStudent() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#isTeacher()}.
	 */
	@Test
	void testIsTeacher() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link mvc.UserData#isDeveloper()}.
	 */
	@Test
	void testIsDeveloper() {
		fail("Not yet implemented"); // TODO
	}

}

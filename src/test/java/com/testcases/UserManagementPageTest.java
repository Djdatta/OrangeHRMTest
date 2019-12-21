package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UserManagement;
import com.util.TestUtil;

public class UserManagementPageTest extends TestBase{

	public String sheetname="users"; //sheetname in excel file
	HomePage homePage;
	LoginPage loginPage;
	UserManagement userManagement;
	
	public UserManagementPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		userManagement=new UserManagement();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	
		userManagement=homePage.mouseHoverOnAdmin();
		userManagement=homePage.clickOnAdminUsermanagement();
	}
	
	
/*	@Test
	public void verifyUserManagementPage() {
		userManagement.selectUnByName("teste1");
		
	}*/
	
	@DataProvider
	public Object[][] getRHRMTestData() {
		Object [][] data=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider="getRHRMTestData")
	public void addUser(String ur, String empname, String userName, String status, String pwd, String cPwd) {
		
		userManagement.clickAddUser();
		userManagement.addUser(ur, empname, userName, status, pwd, cPwd);
	}
	/*@Test
	public void addUser() {
		
		userManagement.clickAddUser();
		userManagement.addUser("ESS", "John Smith", "Datta", "Enabled", "Datta123", "Datta123");
	}*/
	@AfterMethod
	public void tearup() {
		driver.quit();
	
	}
}

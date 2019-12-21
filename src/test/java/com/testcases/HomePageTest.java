package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	/*
	 * @Test public void loginIn() {
	 * homePage=loginPage.login(prop.getProperty("userName"),
	 * prop.getProperty("password")); }
	 */
	@Test
	public void AdminPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnAdminUsermanagement();

	}
	@Test
	public void jobPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnJobTitleLink();

	}
	
	@Test
	public void organizationPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnOraganizationTab();

	}
	
	@Test
	public void qualificationPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.ClickOnQualificationTab();

	}
	@Test
	public void notificationPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnNationalizationTab();

	}
	@Test
	public void configurationPageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnConfigurationTab();

	}
	
	

	@Test(priority = 1)
	public void verifyHomepageTitle() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM", "Home Page Title Not Match..."); // if failed shows message 3rd
																							// parameter
	}

	@Test
	public void jobTitlePageTest() {
		homePage.mouseHoverOnAdmin();
		homePage.clickOnJobTitleLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

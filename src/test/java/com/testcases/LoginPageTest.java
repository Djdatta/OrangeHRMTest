package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	HomePage homePage;
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new  LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		
		String title=loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
		Reporter.log("Login Success..");
	}
	
	@Test
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	@Test
	public void validatImageTest() {
		boolean check=loginPage.validateImage();
		Assert.assertTrue(check);
	}
	@Test
	public void linkedInLinkTest() {
		loginPage.linkedInLinkTest();
	}
	@Test
	public void fbLinkTest() {
		loginPage.fbLinkTest();
	}
	@Test
	public void twitterLinkTest() {
		loginPage.twitterLinkTest();
	}
	
	@Test
	public void youtubeLinkTest() {
		loginPage.youtubeLinkTest();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

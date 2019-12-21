package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {

	
	//OR
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"divLogo\"]/img")
	WebElement imageTest;
	
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[1]/img")
	WebElement lnkdInLinkTest;
	
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[2]/img")
	WebElement 	fbLinkTest;
	
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[3]/img")
	WebElement twitterLinkTest;
	
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[4]/img")
	WebElement youtubeLinkTest;
	
	
	//--OR initialization...
	public LoginPage() {

		PageFactory.initElements(driver,this);
	}
	
	//Actions----
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateImage() {
		return imageTest.isDisplayed();
	}
	
	public void linkedInLinkTest() {
		 lnkdInLinkTest.click();
	}
	
	public void fbLinkTest() {
		fbLinkTest.click();
	}
	public void twitterLinkTest() {
		twitterLinkTest.click();
	}
	public void youtubeLinkTest() {
		youtubeLinkTest.click();
	}
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
}

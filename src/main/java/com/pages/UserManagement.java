package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.base.TestBase;

public class UserManagement extends TestBase{

	public UserManagement() {
		PageFactory.initElements(driver, this);
	}
	//OR
	
	@FindBy(xpath="//*[@id=\"ohrmList_chkSelectRecord_12\"]")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"btnAdd\"]")
	WebElement addBtn;
	
	@FindBy(xpath="	//*[@id=\"systemUser_userType\"]")
	WebElement userRole;
	
	@FindBy(xpath="//*[@id=\"systemUser_employeeName_empName\"]")
	WebElement empName;
	
	@FindBy(xpath="//*[@id=\"systemUser_userName\"]")
	WebElement systemUser;
	
	@FindBy(xpath="//*[@id=\"systemUser_status\"]")
	WebElement userStatus;
	
	@FindBy(xpath="//*[@id=\"systemUser_password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"systemUser_confirmPassword\"]")
	WebElement confirmPwd;
	
	@FindBy(xpath="//*[@id=\"btnSave\"]")
	WebElement submitBtn;
	
			

	public void clickAddUser() {
		
		addBtn.click();
	}
	
	public void addUser(String ur, String empname, String userName, String status, String pwd, String cPwd) {
		
		Select select=new Select(userRole);
		select.selectByVisibleText(ur);
		empName.sendKeys(empname);
		systemUser.sendKeys(userName);
		Select select1=new Select(userStatus);
		select1.selectByVisibleText(status);
		password.sendKeys(pwd);
		confirmPwd.sendKeys(cPwd);
		submitBtn.click();
	}
	
	public void selectUnByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")).click();
	}
	
	
	
}

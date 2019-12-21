package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {

	Actions action;

	public HomePage() {

		PageFactory.initElements(driver, this); // OR Initialization..
	}
	
	// OR..
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement admin;

	@FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
	WebElement adminUserMngt;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement adminUser;

	// Job

	@FindBy(xpath = "//*[@id=\"menu_admin_Job\"]")
	WebElement jobHeading;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewJobTitleList\"]")
	WebElement job_jobTitle;

	// Organizations

	@FindBy(xpath = "//*[@id=\"menu_admin_Organization\"]")
	WebElement orgHeading;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewOrganizationGeneralInformation\"]")
	WebElement org_genrealInfo;

	// Qualification
	@FindBy(xpath = "//*[@id=\"menu_admin_Qualifications\"]")
	WebElement qualiHeading;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewSkills\"]")
	WebElement qualSkill;

	// nationlaization
	@FindBy(xpath = "//*[@id=\"menu_admin_nationality\"]")
	WebElement natHeading;

	// Configuration
	@FindBy(xpath = "//*[@id=\"menu_admin_Configuration\"]")
	WebElement confHeading;

	@FindBy(xpath = "//*[@id=\"menu_admin_listMailConfiguration\"]")
	WebElement conf_emailConfig;

	// Actions..

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public UserManagement mouseHoverOnAdmin() {

		action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		return new UserManagement();
	}

	// User Management
	public UserManagement clickOnAdminUsermanagement() {

		action.moveToElement(adminUserMngt).build().perform();
		adminUser.click();
		return new UserManagement();

	}

	// Job
	public JobTitlesPage clickOnJobTitleLink() {

		action.moveToElement(jobHeading).build().perform();
		job_jobTitle.click();
		return new JobTitlesPage();
	}

	// Organizations

	public OrganizationPage clickOnOraganizationTab() {

		action.moveToElement(orgHeading).build().perform();
		org_genrealInfo.click();
		return new OrganizationPage();
	}
	// Qualification
	public QualificationPage ClickOnQualificationTab() {

		action.moveToElement(qualiHeading).build().perform();
		qualSkill.click();
		return new QualificationPage();
	}
	// Nationalization
	
	public NationalaitizPage clickOnNationalizationTab() {

		natHeading.click();
		return new NationalaitizPage();
	}
	// Configurations
	public Configurationspage clickOnConfigurationTab() {

		action.moveToElement(confHeading).build().perform();
		conf_emailConfig.click();
		return new Configurationspage();
	}

}

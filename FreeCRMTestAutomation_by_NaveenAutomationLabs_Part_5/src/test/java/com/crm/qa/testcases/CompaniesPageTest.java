package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CampaignsPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.pages.commons.LeftNavBar;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.TestUtilityOldKeep;

public class CompaniesPageTest extends TestBase {
	
	LoginPage     loginPage;
	HomePage      homePage;
	TestUtil      testUtil;
	
	CalendarPage  calendarPage;
	ContactsPage  contactsPage;
	CompaniesPage companiesPage;
	DealsPage     dealsPage;
	TasksPage     tasksPage;
	CasesPage     casesPage;
	CallsPage     callsPage;
	DocumentsPage documentsPage;
	EmailPage     emailPage;
	CampaignsPage campaignsPage;
	FormsPage     formsPage;
	
	public CompaniesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		Initialization();
		
		loginPage     = new LoginPage();
		homePage      = new HomePage();
		testUtil      = new TestUtil();
		
		calendarPage  = new CalendarPage();
		contactsPage  = new ContactsPage();
		companiesPage = new CompaniesPage();
		dealsPage     = new DealsPage();
		tasksPage     = new TasksPage();
		casesPage     = new CasesPage();
		callsPage     = new CallsPage();
		documentsPage = new DocumentsPage();
		emailPage     = new EmailPage();
		campaignsPage = new CampaignsPage();
		formsPage     = new FormsPage();
		leftNavBar    = new LeftNavBar();
		
		Thread.sleep(3000);
		homePage     = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		companiesPage = leftNavBar.clickOnCompaniesLink();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void verify_LandedOn_CompaniesPage_Test() throws IOException {
		Assert.assertTrue(companiesPage.verifyLandedOnCompaniesPage());
		TestUtilityOldKeep.getScreenshot(driver, "CompaniesPage_Screenshot");
	}
	@Test(priority=1)
	public void verify_LeftNavBar_CalendarLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.calendarLink);
		TestUtilityOldKeep.getScreenshot(driver, "CalendarLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.calendarLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CallsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.callsLink);
		TestUtilityOldKeep.getScreenshot(driver, "CallsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.callsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CampaignsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.campaignsLink);
		TestUtilityOldKeep.getScreenshot(driver, "CampaignsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.campaignsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CasesLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.casesLink);
		TestUtilityOldKeep.getScreenshot(driver, "CasesLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.casesLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CompaniesLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.companiesLink);
		TestUtilityOldKeep.getScreenshot(driver, "CompaniesLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.companiesLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_ContactsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.contactsLink);
		TestUtilityOldKeep.getScreenshot(driver, "ContactsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.contactsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_DealsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.dealsLink);
		TestUtilityOldKeep.getScreenshot(driver, "DealsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.dealsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_DocumentsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.documentsLink);
		TestUtilityOldKeep.getScreenshot(driver, "DocumentsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.documentsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_EmailLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.emailLink);
		TestUtilityOldKeep.getScreenshot(driver, "EmailLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.emailLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_FormsLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.formsLink);
		TestUtilityOldKeep.getScreenshot(driver, "FormsLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.formsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_TasksLink_VisibleFrom_CompaniesPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.tasksLink);
		TestUtilityOldKeep.getScreenshot(driver, "TasksLink_VisibleFrom_CompaniesPage");
		Assert.assertTrue(leftNavBar.tasksLink.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
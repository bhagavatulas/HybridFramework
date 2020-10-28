package com.crm.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import com.crm.qa.util.ExcelDataConfig;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.TestUtility;
import com.crm.qa.util.TestUtilityOldKeep;
import com.relevantcodes.extentreports.model.Log;

public class ContactsPageTest extends TestBase {
	
	LoginPage     loginPage;
	HomePage      homePage;
	TestUtil      testUtil;
	
	CalendarPage  calendarPage;
	ContactsPage  contactsPage;
	ContactsPage  contactsPageH;
	CompaniesPage companiesPage;
	DealsPage     dealsPage;
	TasksPage     tasksPage;
	CasesPage     casesPage;
	CallsPage     callsPage;
	DocumentsPage documentsPage;
	EmailPage     emailPage;
	CampaignsPage campaignsPage;
	FormsPage     formsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
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
		contactsPageH = new ContactsPage();
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
		
		homePage      = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage  = leftNavBar.clickOnContactsLink();
		contactsPageH = homePage.verifyLandOnContactsPageB();

		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void verify_LandedOn_ContactsPage_A_Test() throws IOException {
		Assert.assertTrue(contactsPage.verifyLandedOnContactsPageA());
		TestUtilityOldKeep.getScreenshot(driver, "ContactsPage_Screenshot");
	}
	
	//We are using Data Provider here to Access Data from Excel Sheet
	@DataProvider
	public Object[][] getCRMContactsTestData() //To Access Sheet from Test Data Sheet
	{
		Object data [][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMContactsTestData")
	public void validateCreateNewContactExcelSheetTest(String fName, String lName, String eMail, String cName) throws IOException, InterruptedException {
		contactsPageH.createNewContact(fName, lName, eMail, cName);
	}
	
	@Test(priority=4)
	public void validateCreateNewContactHardCodeTest() throws IOException, InterruptedException {
		contactsPageH.createNewContact("Tom", "Hanks", "tom.hanks@gmail.com", "HanksComputers");
	}
	
	@Test(priority=1)
	public void verify_LeftNavBar_CalendarLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.calendarLink);
		TestUtilityOldKeep.getScreenshot(driver, "CalendarLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.calendarLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CallsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.callsLink);
		TestUtilityOldKeep.getScreenshot(driver, "CallsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.callsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CampaignsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.campaignsLink);
		TestUtilityOldKeep.getScreenshot(driver, "CampaignsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.campaignsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CasesLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.casesLink);
		TestUtilityOldKeep.getScreenshot(driver, "CasesLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.casesLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_CompaniesLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.companiesLink);
		TestUtilityOldKeep.getScreenshot(driver, "CompaniesLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.companiesLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_ContactsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.contactsLink);
		TestUtilityOldKeep.getScreenshot(driver, "ContactsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.contactsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_DealsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.dealsLink);
		TestUtilityOldKeep.getScreenshot(driver, "DealsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.dealsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_DocumentsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.documentsLink);
		TestUtilityOldKeep.getScreenshot(driver, "DocumentsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.documentsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_EmailLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.emailLink);
		TestUtilityOldKeep.getScreenshot(driver, "emailLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.emailLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_FormsLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.formsLink);
		TestUtilityOldKeep.getScreenshot(driver, "FormsLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.formsLink.isDisplayed());
	}
	
	@Test(priority=2)
	public void verify_LeftNavBar_TasksLink_VisibleFrom_ContactsPage_Test() throws IOException, InterruptedException {
		TestUtilityOldKeep.highLightElement(driver, leftNavBar.tasksLink);
		TestUtilityOldKeep.getScreenshot(driver, "TasksLink_VisibleFrom_ContactsPage");
		Assert.assertTrue(leftNavBar.tasksLink.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
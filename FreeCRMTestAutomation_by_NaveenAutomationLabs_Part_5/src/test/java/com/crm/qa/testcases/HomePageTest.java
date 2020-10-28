package com.crm.qa.testcases;

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

public class HomePageTest extends TestBase {
	
	LoginPage     loginPage;
	HomePage      homePage;
	TestUtil      testUtil;
	
	CalendarPage  calendarPage;
	ContactsPage  contactsPage;
	CompaniesPage companiesPage;
	CasesPage     casesPage;
	CallsPage     callsPage;
	DocumentsPage documentsPage;
	EmailPage     emailPage;
	CampaignsPage campaignsPage;
	FormsPage     formsPage;
	DealsPage     dealsPage;
	TasksPage     tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Initialization();
		testUtil     = new TestUtil();
		calendarPage = new CalendarPage();
		contactsPage = new ContactsPage();
		dealsPage    = new DealsPage();
		loginPage    = new LoginPage();
		Thread.sleep(3000);
		homePage     = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		leftNavBar   = new LeftNavBar();
	}
	
	@Test(priority=1)
	public void verifyLandedOnHomePageWithPageTitlePassTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals (homePageTitle, "Cogmento CRM", "Home page title not matched.");
	}
	
	@Test(priority=2)
	public void verifyLandedOnHomePageWithPageTitleFailTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		//Assert.assertEquals (homePageTitle, "Cogmento", "Home page title not matched.");
		Assert.assertNotEquals(homePageTitle, "Cogmento", "HomePageTitle not supposed to appears as \"Cogmento\"");
		//Assert.assertNotEquals(homePageTitle, "Cogmento CRM", "HomePageTitle not supposed to appears as \"Cogmento CRM\"");
	}
	
	@Test(priority=3)
	public void verifyLandedOnHomePageWithUserNamePassTest() {
		//testUtil.switchToFrame();
		homePage.verifyCorrectUserName();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=4)
	public void verifyLandedOnCalendarPageTest() throws InterruptedException {
		calendarPage = leftNavBar.clickOnCalendarLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnCallsPageTest() throws InterruptedException {
		callsPage = leftNavBar.clickOnCallsLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnCampaignsPageTest() throws InterruptedException {
		campaignsPage = leftNavBar.clickOnCampaignsLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnCasesPageTest() throws InterruptedException {
		casesPage = leftNavBar.clickOnCasesLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnCompaniesPageTest() throws InterruptedException {
		companiesPage = leftNavBar.clickOnCompaniesLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnContactsPageTest() throws InterruptedException {
		contactsPage = leftNavBar.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnDealsPageTest() throws InterruptedException {
		dealsPage = leftNavBar.clickOnDealsLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnDocumentsPageTest() throws InterruptedException {
		documentsPage = leftNavBar.clickOnDocumentsLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnEmailPageTest() throws InterruptedException {
		emailPage = leftNavBar.clickOnEmailLink();
	}
	
	@Test(priority=4)
	public void verifyLandedTasksPageTest() throws InterruptedException {
		tasksPage = leftNavBar.clickOnTasksLink();
	}
	
	@Test(priority=4)
	public void verifyLandedOnFormsPageTest() throws InterruptedException {
		formsPage = leftNavBar.clickOnFormsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
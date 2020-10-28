package com.crm.qa.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
import com.crm.qa.pages.TasksPage;

public class LeftNavBar extends TestBase{
	
	//WebDriver driver;
	
	// Page Factory - Object Repository
	
	// WebElement calendarLink = driver.findElement(By.xpath("//span[text()='Calendar']")
	@FindBy(xpath="//span[text()='Calendar']")
	public WebElement calendarLink;
	
	// WebElement contactsLink = driver.findElement(By.xpath("//span[text()='Contacts']")
	@FindBy(xpath="//span[text()='Contacts']")
	public WebElement contactsLink;
	
	// WebElement companiesLink = driver.findElement(By.xpath("//span[text()='Companies']")
	@FindBy(xpath="//span[text()='Companies']")
	public WebElement companiesLink;
	
	// WebElement dealsLink = driver.findElement(By.xpath("//span[text()='Deals']")
	@FindBy(xpath="//span[text()='Deals']")
	public WebElement dealsLink;
	
	// WebElement tasksLink = driver.findElement(By.xpath("//span[text()='Tasks']")
	@FindBy(xpath="//span[text()='Tasks']")
	public WebElement tasksLink;
	
	// WebElement casesLink = driver.findElement(By.xpath("//span[text()='Cases']")
	@FindBy(xpath="//span[text()='Cases']")
	public WebElement casesLink;
	
	// WebElement callsLink = driver.findElement(By.xpath("//span[text()='Calls']")
	@FindBy(xpath="//span[text()='Calls']")
	public WebElement callsLink;
	
	// WebElement documentsLink = driver.findElement(By.xpath("//span[text()='Documents']")
	@FindBy(xpath="//span[text()='Documents']")
	public WebElement documentsLink;
	
	// WebElement emailLink = driver.findElement(By.xpath("//span[text()='Email']")
	@FindBy(xpath="//span[text()='Email']")
	public WebElement emailLink;
	
	// WebElement campaignsLink = driver.findElement(By.xpath("//span[text()='Campaigns']")
	@FindBy(xpath="//span[text()='Campaigns']")
	public WebElement campaignsLink;
	
	// WebElement formsLink = driver.findElement(By.xpath("//span[text()='Forms']")
	@FindBy(xpath="//span[text()='Forms']")
	public WebElement formsLink;
	
	// Initializing the Page objects
	public LeftNavBar() {
		//PageFactory.initElements(driver,HomePage.class);
		// "this" is same as "HomePage.class"
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	
	public CalendarPage clickOnCalendarLink() throws InterruptedException {
		leftNavBar.calendarLink.click();
		Thread.sleep(3000);
		return new CalendarPage();
	}
	
	public CallsPage clickOnCallsLink() throws InterruptedException {
		leftNavBar.callsLink.click();
		Thread.sleep(3000);
		return new CallsPage();
	}
	
	public CampaignsPage clickOnCampaignsLink() throws InterruptedException {
		leftNavBar.campaignsLink.click();
		Thread.sleep(3000);
		return new CampaignsPage();
	}
	
	public CasesPage clickOnCasesLink() throws InterruptedException {
		leftNavBar.casesLink.click();
		Thread.sleep(3000);
		return new CasesPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() throws InterruptedException {
		leftNavBar.companiesLink.click();
		Thread.sleep(3000);
		return new CompaniesPage();
	}
	
	public ContactsPage clickOnContactsLink() throws InterruptedException {
		leftNavBar.contactsLink.click();
		Thread.sleep(3000);
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws InterruptedException {
		leftNavBar.dealsLink.click();
		Thread.sleep(3000);
		return new DealsPage();
	}
	
	public DocumentsPage clickOnDocumentsLink() throws InterruptedException {
		leftNavBar.documentsLink.click();
		Thread.sleep(3000);
		return new DocumentsPage();
	}
	
	public EmailPage clickOnEmailLink() throws InterruptedException {
		leftNavBar.emailLink.click();
		Thread.sleep(3000);
		return new EmailPage();
	}
	
	public FormsPage clickOnFormsLink() throws InterruptedException {
		leftNavBar.formsLink.click();
		Thread.sleep(3000);
		return new FormsPage();
	}
	
	public TasksPage clickOnTasksLink() throws InterruptedException {
		leftNavBar.tasksLink.click();
		Thread.sleep(3000);
		return new TasksPage();
	}
	
}
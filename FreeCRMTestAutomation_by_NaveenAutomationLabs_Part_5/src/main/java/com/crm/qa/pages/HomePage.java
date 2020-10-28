package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class HomePage extends TestBase {

	// Page Factory - Object Repository
	
	// WebElement usernameLabel = driver.findElement(By.xpath("//span[text()='satyasai bhagavatula']")
	@FindBy(xpath="//span[text()='satyasai bhagavatula']") WebElement usernameLabel;
	
	
	// WebElement calendarLink = driver.findElement(By.xpath("//span[text()='Calendar']")
	@FindBy(xpath="//span[text()='Calendar']") WebElement calendarLink;
	
	// WebElement contactsLink = driver.findElement(By.xpath("//span[text()='Contacts']")
	@FindBy(xpath="//span[text()='Contacts']") WebElement contactsLink;
	
	// WebElement companiesLink = driver.findElement(By.xpath("//span[text()='Companies']")
	@FindBy(xpath="//span[text()='Companies']") WebElement companiesLink;
	
	// WebElement dealsLink = driver.findElement(By.xpath("//span[text()='Deals']")
	@FindBy(xpath="//span[text()='Deals']") WebElement dealsLink;
	
	// WebElement tasksLink = driver.findElement(By.xpath("//span[text()='Tasks']")
	@FindBy(xpath="//span[text()='Tasks']") WebElement tasksLink;
	
	// WebElement casesLink = driver.findElement(By.xpath("//span[text()='Cases']")
	@FindBy(xpath="//span[text()='Cases']") WebElement casesLink;
	
	// WebElement callsLink = driver.findElement(By.xpath("//span[text()='Calls']")
	@FindBy(xpath="//span[text()='Calls']") WebElement callsLink;
	
	// WebElement documentsLink = driver.findElement(By.xpath("//span[text()='Documents']")
	@FindBy(xpath="//span[text()='Documents']") WebElement documentsLink;
	
	// WebElement emailLink = driver.findElement(By.xpath("//span[text()='Email']")
	@FindBy(xpath="//span[text()='Email']") WebElement emailLink;
	
	// WebElement campaignsLink = driver.findElement(By.xpath("//span[text()='Campaigns']")
	@FindBy(xpath="//span[text()='Campaigns']") WebElement campaignsLink;
	
	// WebElement formsLink = driver.findElement(By.xpath("//span[text()='Forms']")
	@FindBy(xpath="//span[text()='Forms']") WebElement formsLink;
	
	
	// Initializing the Page objects
	public HomePage() {	
		//PageFactory.initElements(driver,HomePage.class);
		// "this" is same as "HomePage.class"
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		TestUtilityOldKeep.highLightElement(driver, usernameLabel);
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage verifyLandOnContactsPageB() {
		this.contactsLink.click();
		return new ContactsPage();
	}
	
}
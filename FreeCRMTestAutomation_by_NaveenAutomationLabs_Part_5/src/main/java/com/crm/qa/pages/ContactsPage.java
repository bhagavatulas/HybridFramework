package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class ContactsPage extends TestBase {
	
	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement contactsPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsPageLabel;
		
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement NewContactCreateButton = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]");
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")
	WebElement NewContactCreateButton;
	
	//WebElement NewContactFirstNameTextBox = driver.findElement(By.xpath("//input[@name='first_name']"));
	@FindBy(xpath="//input[@name='first_name']")
	WebElement NewContactFirstNameTextBox;
	
	//WebElement NewContactFirstNameAsteriskSymbol = driver.findElement(By.xpath("//div/div/label[text()='First Name']//parent::div/div/div/i[@class='asterisk icon']"));
	@FindBy(xpath="//div/div/label[text()='First Name']//parent::div/div/div/i[@class='asterisk icon']")
	WebElement NewContactFirstNameAsteriskSymbol;
	
	//WebElement NewContactLastNameTextBox = driver.findElement(By.xpath("//input[@name='last_name']"));
	@FindBy(xpath="//input[@name='last_name']")
	WebElement NewContactLastNameTextBox;
	
	//WebElement NewContactLastNameAsteriskSymbol = driver.findElement(By.xpath("//div/div/label[text()='Last Name']//parent::div/div/div/i[@class='asterisk icon']"));
	@FindBy(xpath="//div/div/label[text()='Last Name']//parent::div/div/div/i[@class='asterisk icon']")
	WebElement NewContactLastNameAsteriskSymbol;
	
	//WebElement NewContactMiddleNameTextBox = driver.findElement(By.xpath("//input[@name='middle_name']"));
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement NewContactMiddleNameTextBox;
	
	//WebElement NewContactAccessIcon = driver.findElement(By.xpath("//i[@class='unlock icon']"));
	@FindBy(xpath="//i[@class='unlock icon']")
	WebElement NewContactAcessIcon;
	
	//WebElement NewContactEmailTextBox = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement NewContactEmailTextBox;
	
	//WebElement NewContactEmailType = driver.findElement(By.xpath("//input[@placeholder='Personal email, Business, Alt...']"));
	@FindBy(xpath="//input[@placeholder='Personal email, Business, Alt...']")
	WebElement NewContactEmailType;
	
	// xpath built using ChroPath, which is Google Chrome extension
	//WebElement NewContactCompanyTextBox = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement NewContactCompanyTextBox;
	
	//WebElement NewContactSave_Button = driver.findElement(By.xpath("//button[@class='ui linkedin button']"));
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement NewContactSaveButton;
	
	//button[@class='ui button']
	//WebElement NewContactCompany_TextBox = driver.findElement(By.xpath("//button[@class='ui button']"));
	@FindBy(xpath="//button[@class='ui button']")
	WebElement NewContactCancel_Button;
	
	// Initializing the Page objects
	public ContactsPage() {	
		//PageFactory.initElements(driver,ContactsPage.class);
		// "this" is same as "ContactsPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnContactsPageA() {
		TestUtilityOldKeep.highLightElement(driver, contactsPageLabel);	
		return contactsPageLabel.isDisplayed();
	}
	
	public void createNewContact(String fName, String lName, String eMail, String cName) throws InterruptedException {
		
		NewContactCreateButton.click();
		Thread.sleep(3000);
		
		NewContactFirstNameTextBox.clear();
		NewContactFirstNameTextBox.sendKeys(fName);
		Thread.sleep(3000);
		
		NewContactLastNameTextBox.clear();
		NewContactLastNameTextBox.sendKeys(lName);
		Thread.sleep(3000);
		
		NewContactEmailTextBox.clear();
		NewContactEmailTextBox.sendKeys(eMail);
		Thread.sleep(3000);
		
		NewContactCompanyTextBox.clear();
		NewContactCompanyTextBox.sendKeys(cName);
		Thread.sleep(3000);
		
		NewContactSaveButton.click();
		Thread.sleep(3000);
	}
}

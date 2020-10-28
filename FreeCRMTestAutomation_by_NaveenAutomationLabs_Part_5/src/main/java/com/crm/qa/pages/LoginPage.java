package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository
	
	// WebElement username = driver.findElement(By.name("email")
	@FindBy(name="email") WebElement username;
	
	// WebElement password = driver.findElement(By.name("password")
	@FindBy(name="password") WebElement password;
	
	// WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Login']")
	@FindBy(xpath="//div[text()='Login']") WebElement loginBtn;
	
	// WebElement signupBtn = driver.findElement(By.xpath("//a[text()='Sign Up']")
	@FindBy(xpath="//a[text()='Sign Up']") WebElement signupBtn;
	
	// Initializing the Page objects
	public LoginPage() {	
		//PageFactory.initElements(driver,LoginPage.class);
		// "this" is same as "LoginPage.class"
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class EmailPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement emailPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement emailPageLabel;
		
	// Initializing the Page objects
	public EmailPage() {	
		//PageFactory.initElements(driver,EmailPage.class);
		// "this" is same as "EmailPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnEmailPage() {
		TestUtilityOldKeep.highLightElement(driver, emailPageLabel);	
		return emailPageLabel.isDisplayed();
	}
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class CallsPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement callsPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement callsPageLabel;
		
	// Initializing the Page objects
	public CallsPage() {	
		//PageFactory.initElements(driver,CallsPage.class);
		// "this" is same as "CallsPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnCallsPage() {
		TestUtilityOldKeep.highLightElement(driver, callsPageLabel);	
		return callsPageLabel.isDisplayed();
	}
}

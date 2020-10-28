package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class CasesPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement casesPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement casesPageLabel;
		
	// Initializing the Page objects
	public CasesPage() {	
		//PageFactory.initElements(driver,CasesPage.class);
		// "this" is same as "CasesPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnCasesPage() {
		TestUtilityOldKeep.highLightElement(driver, casesPageLabel);	
		return casesPageLabel.isDisplayed();
	}
}

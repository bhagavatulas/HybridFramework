package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class FormsPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement formsPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement formsPageLabel;
		
	// Initializing the Page objects
	public FormsPage() {	
		//PageFactory.initElements(driver,FormsPage.class);
		// "this" is same as "CalendarFormsPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnFormsPage() {
		TestUtilityOldKeep.highLightElement(driver, formsPageLabel);	
		return formsPageLabel.isDisplayed();
	}
}

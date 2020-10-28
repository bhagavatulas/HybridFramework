package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class CampaignsPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement campaignsPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement campaignsPageLabel;
		
	// Initializing the Page objects
	public CampaignsPage() {	
		//PageFactory.initElements(driver,CampaignsPage.class);
		// "this" is same as "CampaignsPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnCampaignsPage() {
		TestUtilityOldKeep.highLightElement(driver, campaignsPageLabel);	
		return campaignsPageLabel.isDisplayed();
	}
}

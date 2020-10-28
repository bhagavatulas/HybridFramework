package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class DocumentsPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement documentsPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement documentsPageLabel;
		
	// Initializing the Page objects
	public DocumentsPage() {	
		//PageFactory.initElements(driver,DocumentsPage.class);
		// "this" is same as "DocumentsPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnDocumentsPage() {
		TestUtilityOldKeep.highLightElement(driver, documentsPageLabel);	
		return documentsPageLabel.isDisplayed();
	}
}

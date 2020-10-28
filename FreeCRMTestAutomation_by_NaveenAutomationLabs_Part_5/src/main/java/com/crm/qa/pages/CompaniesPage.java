package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilityOldKeep;

public class CompaniesPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement companiesPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement companiesPageLabel;
		
	// Initializing the Page objects
	public CompaniesPage() {	
		//PageFactory.initElements(driver,CompaniesPage.class);
		// "this" is same as "CompaniesPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnCompaniesPage() {
		TestUtilityOldKeep.highLightElement(driver, companiesPageLabel);	
		return companiesPageLabel.isDisplayed();
	}
}

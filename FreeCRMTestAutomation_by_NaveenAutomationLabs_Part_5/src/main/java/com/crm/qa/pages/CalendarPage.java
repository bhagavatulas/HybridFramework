package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.commons.LeftNavBar;
import com.crm.qa.util.TestUtilityOldKeep;

public class CalendarPage extends TestBase {

	// Page Factory - Object Repository
	
	// xpath built using ChroPath, which is Google Chrome extension
	// WebElement calendarPageLabel = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]") WebElement calendarPageLabel;
		
	// Initializing the Page objects
	public CalendarPage() {	
		//PageFactory.initElements(driver,CalendarPage.class);
		// "this" is same as "CalendarPage.class"
		PageFactory.initElements(driver,this);
	}
		
	// Actions
		
	public boolean verifyLandedOnCalendarPage() {
		TestUtilityOldKeep.highLightElement(driver, calendarPageLabel);	
		return calendarPageLabel.isDisplayed();
	}
}

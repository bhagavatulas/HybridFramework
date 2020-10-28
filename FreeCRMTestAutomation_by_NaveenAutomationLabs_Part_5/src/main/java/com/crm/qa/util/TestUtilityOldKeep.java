package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class TestUtilityOldKeep extends TestBase
{	
	//1. 
	//These 2 variable we used in TestBase Class for Page Load and Implicit Wait.
	public static long Page_Load_TimeOut = 20;
	public static long Implicit_Wait = 30;
	
	//2. 
	//Switching to Frame Utility.
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	//3. 
	//Excel Sheet Path - Excel Utility.
	//Below Function is used for getting Data from Excel.
	//To be used with @DataProvider.
	//public static String TESTDATA_SHEET_PATH   = System.getProperty("user.dir") + "/src/main/java/com/crm/qa/testdata/FreeCRM_TestData.xlsx";
	public static String TESTDATA_SHEET_PATH   = "C:\\Users\\BlueHouse\\Documents\\selenium\\workspaces\\POM_PF_Cucumber_TestNG_New\\FreeCRMTestAutomation_by_NaveenAutomationLabs_Part_4\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
		
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public Object[][] passData() {
		
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\BlueHouse\\Documents\\selenium\\workspaces\\POM_PF_Cucumber_TestNG_New\\Maven_Java_POM_with_TestNG_by_MukeshOtwani\\src\\main\\java\\ExcelData\\TestData.xlsx");
		
		int rows = config.getRowCount(0);
		
		Object data[][] = new Object[rows][2];
		
		for (int i=0; i<rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		
		return data;
	}
	
	//4. 
	//Screenshot Utility.
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	//5. 
	//Explicit Wait for Click on any Element.
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	/*
	 * WebDriver Waits Examples (https://www.seleniumeasy.com/selenium-tutorials/webdriver-wait-examples)
     *
     * We can use WebDriverWait class in many different cases.
     * When ever we need to perform any operation on element,
     * we can use webdriver wait to check if the element is Present or visible or enabled or disabled or Clickable etc.
     * We will look into different examples for all the above scenarios:
     *
     * isElementPresent:
     * Below is the syntax to check for the element presence using WebDriverWait.
     * Here we need to pass locator and wait time as the parameters to the below method.
     * Here it is checking that an element is present on the DOM of a page or not.
     * That does not necessarily mean that the element is visible.
     * ExpectedConditions will return true once the element is found in the DOM.
     *		WebDriverWait wait = new WebDriverWait(driver, waitTime);
     *		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     * We should use presenceOfElementLocated when we don't care about the element visible or not,     
     * we just need to know if it's on the page.
     * 
     * We can also use the below syntax which is used to check if the element is present or not.
     * We can return true ONLY when the size of elements is greater than Zero.
     * That mean there exists atleast one element.
     *		WebElement element = driver.findElements(By.cssSelector(""));
     *		element.size()>0;
     *
     * isElementClickable:
     * Below is the syntax for checking an element is visible and enabled
     * such that we can click on the element.
     * We need to pass wait time and the locator as parameters.
     *		WebDriverWait wait = new WebDriverWait(driver, waitTime);
     *		wait.until(ExpectedConditions.elementToBeClickable(locator));
     *
     * isElementVisible
	 * Below is the syntax to check if the element is present on the DOM of a page and visible.
	 * Visibility means that the element is not just displayed but also should also has a height and width that is greater than 0.
	 * 		WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 * 		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 *
	 *  We can also use the below to check the element to be visible by WebElement.
	 *  	WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 *  	wait..until(ExpectedConditions.visibilityOf(element));
	 *  
	 *  We can also use the below to check all elements present on the web page are visible.
	 *  We need to pass list of WebElements.
	 *  	List<WebElement> linkElements = driver.findelements(By.cssSelector('#linkhello'));
	 *  	WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 *  	wait..until(ExpectedConditions.visibilityOfAllElements(linkElements));
	 *  
	 *  isElementInVisible
	 *  Below is the syntax which is used for checking that an element is either invisible or not present on the DOM.
	 *  	WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 *  	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)); 
	 *  
	 *  isElementEnabled
	 *  Below is the syntax which is used to check if the element is enabled or not
	 *  	WebElement element = driver.findElement(By.id(""));
	 *  	element.isEnabled();
	 *  
	 *  isElementDisplayed
	 *  Below is the syntax which is used to check if the element is displayed or not.
	 *  It returns false when the element is not present in DOM.
	 *  	WebElement element = driver.findElement(By.id(""));
	 *  	element.isDisplayed();
	 *  
	 *  Wait for invisibility of element:
	 *  Below is the syntax which is used to check for the Invisibility of element with text
	 *  	WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 *  	wait.until(ExpectedConditions.invisibilityOfElementWithText(by));
	 *  
	 *  Wait for invisibility of element with Text:
	 *  Below is the syntax which is used for checking that an element with text is either invisible or not present on the DOM.
	 *  	WebDriverWait wait = new WebDriverWait(driver, waitTime);
	 *  	wait.until(ExpectedConditions.invisibilityOfElementWithText(by, strText));
	 *  
	 */
	
	//6. 
	//Explicit Wait for Sending Data to any Element.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	//7. 
	//To Highlight the Element using Java Script.
	public static void highLightElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background: palegreen; border: 8px solid red:')", element);
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}
	
	//8. 
	//To Handle Frames.
	public void switchToFrame(int frame) 
	{
		try
		{
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} 
		catch (NoSuchFrameException e) 
		{
			System.out.println("Unable to locate frame with id " + frame + e.getStackTrace());
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to navigate to frame with id " + frame + e.getStackTrace());
		}
	}
	
	//9. 
	//Function to Handle Multiple Windows Or Switch Between Multiple Windows.
	public void switchWindow(WebDriver driver, String firstWindow, String secondWindow)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windows : windowHandles)
		{
			if(!windows.equals(firstWindow) && !windows.equals(secondWindow))
			{
				driver.switchTo().window(windows);
			}
		}
	}
	
	//10. 
	//To Scroll to Particular Element.
	public static void scrollSpecificElement(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//11. 
	//Handle Alert in web base Pop-Up.
	public static void handleWebBaseAlert()
	{
		String alertMsg=driver.switchTo().alert().getText();// To Capture Alert text
		System.out.println("Alert msg is:"+alertMsg);
		Alert alrt=driver.switchTo().alert();// In direct approach to handle alert
		alrt.accept();
					
		driver.switchTo().alert().accept();
					
		Assert.assertEquals(alertMsg, "Field cannot be empty");//Verify Alert Message	
	}
	
	//12. 
	//Element Display or Not.
	public static void displayElement()
	{
		boolean elementDisplayed=driver.findElement(By.xpath("")).isDisplayed();
		if(elementDisplayed)
		{
			System.out.println("Element is displayed");
		}
		else
		{
			System.out.println("Element is not displayed");
		}
	}
	
	//13. 
	//Element is Enable or Not.
	public static void enableElement()
	{
		boolean enable=driver.findElement(By.xpath("")).isEnabled();
		if(enable)
		{
			System.out.println("Element is enabled in page");
		}
		else
		{
			System.out.println("Element is not enabled in page");
		}
	}
	
	//14. 
	//To Select Value from Dropdown.
	public static void selectValueFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	//15. 
	//To Print all the Values from Dropdown and Select a Value from Dropdown.
	public static void selectDropDownValue(String xpathValue, String value)
	{
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		System.out.println(monthList.size());
		
		for(int i=0; i<monthList.size(); i++)
		{
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals(value))
			{
				monthList.get(i).click();
				break;
			}
		}
	}
	
	//16.
	//Function to Accept an Alert Pop-Up.
	public static void acceptAlertPopup() throws InterruptedException
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			System.out.println("Alert Accepted Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Something Went Wrong -- Please Check" +e.getMessage());
		}
	}
	
	//17.
	//Function to Dismiss an Alert Pop-Up.
	public static void dismissAlertPopup() throws InterruptedException
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println("Alert Dismissed Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Something Went Wrong -- Please Check" +e.getMessage());
		}
	}
	
	//18.
	//To Select Calendar Date Or Data Picker Using Java Script Executor.
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue)
	{
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);	
	}
	
	//19.
	//Function to Mouse Hover and Click Or Select an Element using Actions Class.
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	//20.
	//Function to Drag and Drop using Actions Class.
	public static void dragAndDrop(WebDriver driver, WebElement elementOne, WebElement elementTwo)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementOne, elementTwo).release().build().perform();
	}
	
	//21.
	//Function to Right Click using Actions Class.
	public static void rightClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	//22.
	//Function to Double Click using Actions Class.
	public static void doubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	//23.
	//To Click on Element Using Java Script.
	public static void clickElementByJS(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);	
    }
	
	//24.
	//To Refresh Browser Using Java Script.
	public static void refreshBrowserByJS(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
	
	//25.
	//To Get Title Using Java Script.
	public static String getTitleByJS(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
	
	//26.
	//To Scroll Down the Page Using Java Script.
	public static void scrollPageDown(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
	
	//27.
	//Extent Report - 1.
	public static String getSystemDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
			
	//28. 
	//Extent Report - 2.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		//We have generated Date now.
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//After execution, you could see a folder "ScreenshotsCaptured" Under Source folder
		String destination = System.getProperty("user.dir") + "/ScreenshotsCaptured/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	//29. 
	//Set Date For Log4J.
	public static void setDateForLog4j() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
}

	
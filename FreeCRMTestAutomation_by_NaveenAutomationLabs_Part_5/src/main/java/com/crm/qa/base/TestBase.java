package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.pages.commons.LeftNavBar;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static Properties            prop;
	public static WebDriver             driver;
	public static EventFiringWebDriver  e_driver;
	public static WebEventListener      eventListener;
	

	//Declare NavBar object variable
    public static LeftNavBar leftNavBar;

	static String filePath = System.getProperty("user.dir");
	
	public TestBase() {
		try {
    		prop = new Properties();
    		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
    	    FileInputStream fis = new FileInputStream(filePath + "/src/main/java/com/crm/qa/config/config.properties");
    		prop.load(fis);
    	}
		catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
		catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty
				("webdriver.chrome.driver", 
				 //"C:\\Users\\BlueHouse\\Documents\\selenium\\workspaces\\POM_PF_Cucumber_TestNG_New\\FreeCRMTestAutomation\\src\\main\\resources\\drivers\\chromedriver.exe");
				 filePath + "/src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("FF")) {
			System.setProperty
				("webdriver.gecko.driver", 
				//"C:\\Users\\BlueHouse\\Documents\\selenium\\workspaces\\POM_PF_Cucumber_TestNG_New\\FreeCRMTestAutomation\\src\\main\\resources\\drivers\\geckodriver.exe");
				filePath + "/src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			System.setProperty
				("webdriver.ie.driver", 
				//"C:\\Users\\BlueHouse\\Documents\\selenium\\workspaces\\POM_PF_Cucumber_TestNG_New\\FreeCRMTestAutomation\\src\\main\\resources\\drivers\\IEDriverServer.exe");
				filePath + "/src/main/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
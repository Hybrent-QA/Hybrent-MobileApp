package testCases;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.awt.List;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.mongodb.ReplicaSetStatus;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;
import pageObject.LoginPage;
import pageObject.Profile;
import pageObject.*;

public class TC_ReplenishBin extends ApplicationKeyword{

	@BeforeSuite
	public void setBrowser()
	{	
		try
		{		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
				String platform = "Android";
				if(platform.equalsIgnoreCase("ios")){
					desiredCapabilities.setCapability("deviceName", "iPhone 6");
					desiredCapabilities.setCapability("platformVersion", "11.0");
					desiredCapabilities.setCapability("platformName", "ios");
					desiredCapabilities.setCapability("app",
							"/Users/prabh/Documents/PortfolioManager.app");
				}else if (platform.equalsIgnoreCase("Android")){
					desiredCapabilities.setCapability("deviceName", "G");
					desiredCapabilities.setCapability("platformVersion", "7.0");
					desiredCapabilities.setCapability("platformName", "Android");
					desiredCapabilities.setCapability("noReset", false );
					//desiredCapabilities.setCapability("fullReset", true );
					desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\Acer\\AppData\\Roaming\\npm\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
					String build = System.getProperty("user.dir")+"/build/android-debug.apk";
					desiredCapabilities.setCapability("app",build);
					driver = new AndroidDriver(remoteUrl, desiredCapabilities);
					
				}
				
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
				
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	 @BeforeTest
	 public void startReport1(){
		 
		 extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ReplenishBin.html",true,DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
	 extent
	                .addSystemInfo("Host Name", "QA")
	                .addSystemInfo("Environment", "Mobile Automation")
	                .addSystemInfo("User Name", "Harikrishnan");
	                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }
	
	
	@Test
	public void Tc_Replenishbin_001()
	{	
		testStarts("Tc_Replenishbin_001" , "Verify that user gets redirected to Select Inventory screen on tapping Replenish Bin menu option.");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		Replenishbin.NavigateReplenishBin();
		Replenishbin.verifyPage();
		Replenishbin.ResetValidation();
		Replenishbin.ResetValidDetails();
		
		
	}
	
	@Test
	public void Tc_Replenishbin_002()
	{
		testStarts("Tc_Replenishbin_002" , "Verify that user has to tap on search field to view/add list of items.");
		
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		Replenishbin.NavigateReplenishBin();
		Replenishbin.AddtoItem();
		Replenishbin.VisibleAddtocart();
		Replenishbin.RecicleAddtocart();
		Replenishbin.VisibleRemove();
		Replenishbin.VerifyAdded();
		Replenishbin.ItemDetails();
		Replenishbin.VendorDetails();
	}
	
	@Test
	public void Tc_Replenishbin_003()
	{
		testStarts("Tc_Replenishbin_003" , "Verify that Clear and Replenish button appears the bottom.");
		
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		Replenishbin.NavigateReplenishBin();
		Replenishbin.AddtoItem();
		Replenishbin.VisibleAddtocart();
		Replenishbin.RecicleAddtocart();
		clickOn(OR.Close1);
		Replenishbin.clear();
	}
	@Test
	public void Tc_Replenishbin_004()
	{
		testStarts("Tc_Replenishbin_004" , "Verify that Clear and Replenish button appears the bottom.");
		
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		Replenishbin.NavigateReplenishBin();
		Replenishbin.AddtoItem();
		Replenishbin.VisibleAddtocart();
		Replenishbin.RecicleAddtocart();
		clickOn(OR.Close1);
		Replenishbin.Replenish();
	}
	@AfterTest
	public void endReport(){
 		closeBrowser();
		extent.flush();
	}	




}


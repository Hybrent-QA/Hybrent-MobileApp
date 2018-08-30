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

public class Testcases extends ApplicationKeyword{

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
		 
		 extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/WorklistReport14.html",true,DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
	 extent
	                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
	                .addSystemInfo("Environment", "Mobile Automation")
	                .addSystemInfo("User Name", "Harikrishnan");
	                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }
	
	
	@Test
	public void Tc_Shop_002()
	{
		
		testStarts("Tc_Shop_002" , "Verify that user can add item to cart by sliding it to left side");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		ShopPage.NavigateToShop();
		waitForElementToDisplay(OR.Shop_Firstitem, 5);
		if(isElementDisplayed(OR.Shop_Firstitem))
		{
			getText(OR.Shop_Firstitem);
//			getText(OR.Shop_FirstVendor);
//			getText(OR.Shop_FirstPrice);
//			getText(OR.Shop_FirstSku);
			org.openqa.selenium.Dimension size = driver.manage().window().getSize();
			WebElement seek_bar=driver.findElement(By.id("seek_bar"));
			// get start co-ordinate of seekbar
			int start=seek_bar.getLocation().getX();
			//Get width of seekbar
			int end=seek_bar.getSize().getWidth();
			//get location of seekbar vertically
			int y=seek_bar.getLocation().getY();

			    // Select till which position you want to move the seekbar
			    TouchAction action=new TouchAction(driver);

			   
			    //Move it 40%
			    int moveTo=(int)(end*0.4);
			    //action.press(start,y).moveTo(moveTo,y).release().perform();
		        
		        
			if(isElementDisplayed(OR.Shop_AddTOcart))
			{
				clickOn(OR.Shop_AddTOcart);
				waitforPaageload();
				if(driver.findElements(By.xpath("//button[contains(text(),'Continue')]")).size()!=0)
				{
					clickOn(OR.Shop_ContinueBtn);
					waitforPaageload();
					isElementDisplayed(OR.Shop_Decrement);
					isElementDisplayed(OR.Shop_Increament);
					String QTY = getText(OR.Shop_Qty);
					clickOn(OR.Shop_Increament);
					String After = getText(OR.Shop_Qty);
					waitforPaageload();
					if(!QTY.contains(After))
					{
						testLogPass("Before incrementing value is "+QTY+" after incrementing "+After);
					}
					clickOn(OR.Shop_Decrement);
					waitforPaageload();
					String Afterdecrementing= getText(OR.Shop_Qty);
					if(!Afterdecrementing.contains(After))
					{
						testLogPass("Before Decrementing value is "+After+" after incrementing "+Afterdecrementing);
					}
					swipeSlide(driver.findElement(By.xpath("//*[@id='title'])[1]")));
					waitforPaageload();
					if(isElementDisplayed(OR.Shop_Remove))
					{
						
					}
				}
			}
			
		}
		else
		{
			testLogFail("Item is not present");
		}
		
	}
	
	@Test
	public void Tc_Profile_001()
	{
		
		testStarts("Tc_Profile_001" , "Verify that page with heading \"Profile \" opens up when user tap on Profile button on menu bar.");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("AnkurMLTVEB", "goouser");
		Profile.NavigateProfile();
		Profile.VerifyPage();
		Profile.Changepassword("goouser", "goouser1");
		if(driver.findElements(By.xpath("//*[text()='OK']")).size()!=0)
		{
			clickOn(OR.OKBtn);
		}

		LoginPage.login("AnkurMLTVEB", "goouser1");
	}
	
	
	@Test
	public void Tc_Notification_001()
	{
		
		testStarts("Tc_Notification_001" , "Verify that unread notification count appear on \"Bell\" icon at right top side of application");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		Notification.navigateNotification();
		switchToWebView(driver);
		Notification.VerifyNotification();
		
	}
	
	@Test
	public void Tc_News_001()
	{
		
		testStarts("Tc_News_001" , "Verify that “News & Events” title appears at top of page");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		NewsEvent.NavigateNews();
		NewsEvent.NewsVerification();
				
	}
	
	@Test
	public void Tc_Logout_001()
	{
		
		testStarts("Tc_Logout_001" , "Verify that user gets logout of application if user taps on “Logout” button");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		clickOn(OR.HamberGun);
		WebElement Logout = driver.findElementByXPath("//*[starts-with(@class, 'menu-text') and text()='Logout']");
	//	Profile.click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Logout);
		Logout.click();
		testLogPass("clicked on Logout");
		LoginPage.login("admin", "goouser");
				
	}
	@Test
	public void Tc_Shop_003()
	{
		
		testStarts("Tc_Shop_003" , "Verify that (+ -) icon appear with every added item");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		ShopPage.NavigateToShop();
		ShopPage.VisibleAddtocart();
		ShopPage.DoNotaddtocart();
		ShopPage.Addtocart();
		//ShopPage.IncreamsnetDecrementVerify();
//		ShopPage.VisibleAddtocart();
		//ShopPage.RemoveBt();
		testLogPass("Item color is "+getAttributeValue(OR.Shop_Color, "class").replaceAll("-dot", ""));
		testLogPass("Tooltip of fav is  "+getAttributeValue(OR.Shop_Favorite, "uib-tooltip"));
		clickOn(OR.Shop_Favorite);
		
		if(getAttributeValue(OR.Shop_Favorite, "class").contains("fa fa-star"))
		{
			testLogPass("Item is in favarite");
		}
		clickOn(OR.Shop_Favorite);
		
		if(getAttributeValue(OR.Shop_Favorite, "class").contains(""))
		{
			testLogPass("Item is not favarite");
		}
		clickOn(OR.Shop_Favorite);
		
		if(getAttributeValue(OR.Shop_Favorite, "class").contains("fa fa-star"))
		{
			testLogPass("Item is in favarite");
		}

	}
	
	@Test
	public void Tc_Shop_004()
	{
		
		testStarts("Tc_Shop_004" , "Item Details > Verify that following info appear on \"Item Details\" section :");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		ShopPage.NavigateToShop();
		ShopPage.ItemDetails();
		ShopPage.VendorDetails();
		ShopPage.InventoryDetails();
	}
	
	@Test
	public void Tc_Shop_005()
	{
		
		testStarts("Tc_Shop_005" , "Vendors Details > Verify that all Vendors of correponding item, appear in \"Vendor Details\" section");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		ShopPage.NavigateToShop();
		ShopPage.VendorDetails();
		ShopPage.InventoryDetails();
	}
	@Test
	public void Tc_Shop_006()
	{
		
		testStarts("Tc_Shop_006" , "Verify that \"Vendor Info\" popup appear, when user taps on \"Vendor Name\"");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		ShopPage.NavigateToShop();
		ShopPage.vendorinfo();
		ShopPage.Customersupport();
		ShopPage.SalesRepresent();
		ShopPage.PriceHistory();
	}
	
	@AfterTest
	public void endReport(){
 		closeBrowser();
		extent.flush();
	}	




}

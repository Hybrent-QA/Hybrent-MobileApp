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
import org.openqa.selenium.support.ui.Select;
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
import pageObject.*;

public class TC_Cart extends ApplicationKeyword{

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
	public void Tc_Cart_001()
	{	
		testStarts("Tc_Cart_001" , "Verify that user gets redirected to Select Inventory screen on tapping Replenish Bin menu option.");
		switchToWebView(driver);
		typeIn(OR.Login_siteName, "qa1.test");
		clickOn(OR.Login_gobtn);
		LoginPage.login("admin", "goouser");
		waitforPaageload();
		if(driver.findElementsByXPath("(//*[@ng-href='#/app/hyb-cart'])[2]").size()!=0)
		{
			System.out.println(driver.findElementsByXPath("(//*[@ng-href='#/app/hyb-cart'])[2]").size());
			String getTextcount ="Count#xpath=(//*[@ng-href='#/app/hyb-cart'])[2]/i";
			testLogPass("Count of the item in the cart is "+getText(getTextcount));
			clickOn(OR.Cart);
			verifyElementText(OR.Cart_Title, "Cart");
			verifyElementText(OR.Cart_GeneratePo, "Generate PO");
			testLogPass(getText(OR.Cart_CartFor) + getText(OR.Cart_Selected_Facility));
			System.out.println(driver.findElements(By.xpath("//hyb-select//a[@ng-click='openModal();']")).size());
			clickOn(OR.Cart_Selected_Facility);
//			verifyElementText(OR.Cart_Title_Shipmentlocatopn, "Select Shipping Location");
//			waitforPaageload();
//			int sizeFacility= driver.findElements(By.xpath("//*[@class='item item-divider']")).size();
//			
//			for(int i=1;i<=sizeFacility;i++)
//			{
//				WebElement FacilityName = driver.findElement(By.xpath("(//*[@class='item item-divider'])["+i+"]"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FacilityName);
//				System.out.println(driver.findElements(By.xpath("(//*[@class='item item-divider'])["+i+"]/following-sibling::div")).size());
//				System.out.println(driver.findElements(By.xpath("(//*[@class='item item-divider'])["+i+"]/following-sibling::div[@ng-if='groupBy']")).size());
//				int sizeDepartment= driver.findElements(By.xpath("(//*[@class='item item-divider'])["+i+"]/following-sibling::div[@ng-if='groupBy']")).size();
//				for(int j=1;j<=sizeDepartment;j++)
//				{
//					WebElement DepartmentName = driver.findElement(By.xpath("(//*[@class='item item-divider'])["+j+"]"));
//					
//					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DepartmentName);
//					String  Btnselect = driver.findElement(By.xpath("(//*[@class='item item-divider'])["+i+"]/following-sibling::div[@ng-if='groupBy']/button")).getText();
//					testLogPass(FacilityName.getText() + " - "+DepartmentName.getText()+" Button name is  "+Btnselect);
//				}
//			}
			clickOn(OR.Close);
			verifyElement(OR.Cart_Vendors);
			Select select = new Select(driver.findElement(By.xpath("//select[@id='vendor']")));
			WebElement option = select.getFirstSelectedOption();
			String defaultItem = option.getText();
			testLogPass("selected value in vendor is "+defaultItem);
			if(isElementDisplayed(OR.Shop_Firstitem))
			{
				testLogPass("item name is "+getText(OR.Shop_Firstitem));
				testLogPass("vendorname name is "+getText(OR.Shop_Firstitem));
				getText(OR.Cart_Pricevendorname);
				verifyElement(OR.Cart_label_ReceiveonlySelectVendors);
				verifyElement(OR.Cart_label_Usermypo);
				verifyElement(OR.Cart_label_specialinstuction);
			}
			else
			{
				testLogPass("Item is empty");
			}
		}
		else
		{
			ShopPage.NavigateToShop();
			ShopPage.VisibleAddtocart();
			ShopPage.Addtocart();
		}
	}

	@AfterTest
	public void endReport(){
 		closeBrowser();
		extent.flush();
	}	




}


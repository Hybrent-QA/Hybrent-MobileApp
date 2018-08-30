package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.util.Set;

public class AppiumUtilities {

	static int TimeOutSeconds = 25;

	public ExtentReports extent;
	public static ExtentTest logger;
	public WebElement webElement;
	public static int elementLoadWaitTime = 10;
	 
	public void switchToWebView(AppiumDriver<?> driver) {
		try
		{
		Set contextNames = driver.getContextHandles();
		for (Object contextName : contextNames) {
			String cn = ((String) contextName);
			if (cn.contains("WEBVIEW")) {
				driver.context(cn);
				testLogPass(" Switch to WEBVIEW");
				break;
			}
		}
		}
		catch(Exception e)
		{
			testLogFail("Unable to Switch to WEBVIEW");
		}
		
	}
	public String getTextchild(AppiumDriver<WebElement> driver, String xpath)
	{
		
		WebElement element = driver.findElement(By.xpath(xpath));
		String text = element.getText();
	    	for (WebElement child : element.findElements(By.xpath("./*"))) {
	    		text = text.replaceFirst(child.getText(), "");
	    	}
	    	testLogPass("Got the child text ' "+text);
		return text;
	}
	
	public WebElement Clickon(AppiumDriver<WebElement> driver, String xpath, String Desc)
	{
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
			testLogPass("clicked on "+Desc);
			return element;
		
	}
	
	public static void switchToNative(AppiumDriver<WebElement> driver) {
		Set contextNames = driver.getContextHandles();
		for (Object contextName : contextNames) {
			String cn = ((String) contextName);
			if (cn.contains("NATIVE_APP")) {
				driver.context(cn);
			}
		}
	}

	public static void WaitForElement(AppiumDriver<?> driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void WaitSomeSeconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void swipeSlide(AppiumDriver<WebElement> driver,
			WebElement element) {
		WaitSomeSeconds(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int width = ((Long) js
				.executeScript("return window.innerWidth || document.body.clientWidth"))
				.intValue();

		js.executeScript(
				"arguments[0].style.cssText = \"position: absolute; left: -"
						+ width + "px;\";", element);

	}
	public  void testStarts(String TestCaseName, String Description)
	{
		try
		{
			logger = extent.startTest(TestCaseName, Description);
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the pass report "+e.toString());
		}
	}
	
    public void verticalSwipeByPercentages(AndroidDriver driver,double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
	

	public  void testLogInfo(String Description)
	{
		try
		{
			logger.log(LogStatus.INFO, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Info report "+e.toString());
		}

	}
	
	public  void testLogFail(String Description)
	{
		try
		{
			logger.log(LogStatus.FAIL, Description);
			Assert.assertFalse(true);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Info report "+e.toString());
		}

	}

	 
	    public static void sleep (Integer seconds) {
	        long secondsLong = (long) seconds;
	        try {
	            Thread.sleep(secondsLong);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	public void testLogPass(String Description)
	{
		try
		{
			logger.log(LogStatus.PASS, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Error report "+e.toString());
		}
	}
	
		
public void testend()
{
	extent.flush();
}

}

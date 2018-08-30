package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import io.appium.java_client.AppiumDriver;

public class Notification extends ApplicationKeyword{
	
	public static void navigateNotification()
	{
		waitForElementToDisplay(OR.Notification, 20);
		clickOn(OR.Notification);
	}
	
	public static void VerifyNotification()
	{
		if(driver.findElements(By.xpath("(//*[@class='item-content']/small)[1]")).size()!=0)
		{
			String one = driver.findElement(By.xpath("(//*[@class='item-content']//small)[1]")).getAttribute("innerHTML");
			testLogPass("Title of notification is "+one);
			String one1 = driver.findElement(By.xpath("//*[@nav-bar='active']//*[@ng-click='getNotifications();']/i")).getAttribute("innerHTML");
			testLogPass("Count of the notification is "+one1);
		//	verifyElementText(OR.Notification_TabtoMarkRead, "Tap to mark read");
			WebElement driv = driver.findElement(By.xpath("(//*[contains(text(),'Tap to mark read')])[1]"));
		//	swipeSlide(driv);
		}
	}  
}

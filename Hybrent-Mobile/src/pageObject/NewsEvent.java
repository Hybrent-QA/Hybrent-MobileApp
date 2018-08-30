package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import io.appium.java_client.AppiumDriver;

public class NewsEvent extends ApplicationKeyword{
	
	public static void NavigateNews()
	{
		waitForElementToDisplay(OR.HamberGun, 5);
		clickOn(OR.HamberGun);
		WebElement News = driver.findElementByXPath("//*[starts-with(@class, 'menu-text') and text()='News & Events']");
	//	Profile.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", News);
		News.click();
		testLogPass("clicked on news & Events");
		testLogPass("title is "+driver.getTitle());
	}
	
	public static void NewsVerification()
	{

//			if( driver.findElements(By.xpath("//*[starts-with(@class, 'news-sub-teaser')]")).size()!=0)
//			{
//			int size = driver.findElements(By.xpath("//*[starts-with(@class, 'news-sub-teaser')]")).size();
//			for(int i=1;i<=1;i++)
//			{
//				WebElement e = driver.findElement(By.xpath("(//*[starts-with(@class, 'news-sub-teaser')]//p)["+i+"]"));
//				testLogPass("News Title are  "+e.getAttribute("innerHTML"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
//				String Newspage ="News#xpath=(//*[starts-with(@class, 'news-sub-teaser')]//p)["+i+"]";
//				clickOn(Newspage);
//			
//				String Title	= driver.findElement(By.xpath("//*[@class='modal-backdrop active']//h1")).getText();
//				String Title1	= driver.findElement(By.xpath("//*[@class='modal-backdrop active']//h1")).getAttribute("innerHTML");
//				testLogPass("After entering in to the  "+Title);
//				WebElement element = driver.findElement(By.xpath("//*[@ng-click='closeModal()']"));
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();", element);
//				testLogPass("Clicked on close btn");
//			}
			
				WebElement e = driver.findElement(By.xpath("(//*[starts-with(@class,'profile-picture')])[1]"));
				  testLogPass("News Date are  "+e.getAttribute("innerHTML"));
			
			waitforPaageload();
			
				WebElement e1 = driver.findElement(By.xpath("(//*[@class='news-time ng-binding'])[1]"));
				  testLogPass("News Time are  "+e1.getAttribute("innerHTML"));
			
			waitforPaageload();
			}
			


	
}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Profile extends ApplicationKeyword
{
	
	public static void NavigateProfile()
	{
		waitForElementToDisplay(OR.HamberGun, 5);
		clickOn(OR.HamberGun);
		WebElement Profile = driver.findElementByClassName("ion-person");
	//	Profile.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Profile);
		Profile.click();
	}
	
	public static void VerifyPage()
	{
		waitForElementToDisplay(OR.Profile_Pic, 5);
		isElementDisplayed(OR.Profile_Pic);
		int size = driver.findElements(By.className("col")).size();
		for(int i=1;i<=size;i++)
		{
			String one = driver.findElement(By.xpath("//*[@class='col']")).getText();
			if(one.isEmpty())
			{
				
			}
			else
			{
				testLogPass("Userprofile values are "+one);
			}
		}
	}

	
	public static void Changepassword(String OldPassword, String NewPassword)
	{
		verifyElementText(OR.Profile_ChangePassword, "Change Password");
		clickOn(OR.Profile_ChangePassword);
		verifyElementText(OR.Profile_ChangePasswordTitle, "Change Password");
		verifyElement(OR.Close);
		verifyElementText(OR.Profile_OldPassword, "Old Password");
		verifyElementText(OR.Profile_NewPassword, "New Password");
		verifyElementText(OR.Profile_ConfirmPassword, "Confirm Password");
		verifyElement(OR.Profile_Updatebtn);
		typeIn(OR.Profile_OldPasswordInput, "dsdsdsdsddssd");
		typeIn(OR.Profile_ConfirmPasswordInput, NewPassword);
		typeIn(OR.Profile_NewPasswordInput, NewPassword);
		clickOn(OR.Profile_Updatebtn);
		verifyElementText(OR.Profile_Passwordvalidation, "Please provide correct old password");
		if(driver.findElements(By.xpath("//*[text()='OK']")).size()!=0)
		{
			clickOn(OR.OKBtn);
		}
		typeIn(OR.Profile_OldPasswordInput, OldPassword);
		typeIn(OR.Profile_ConfirmPasswordInput, "dsddd");
		typeIn(OR.Profile_NewPasswordInput, NewPassword);
		clickOn(OR.Profile_Updatebtn);
		verifyElementText(OR.Profile_Passwordvalidation2, "All fields are required and of minimum 6 characters in length.");
		if(driver.findElements(By.xpath("//*[text()='OK']")).size()!=0)
		{
			clickOn(OR.OKBtn);
		}
		typeIn(OR.Profile_OldPasswordInput, OldPassword);
		typeIn(OR.Profile_ConfirmPasswordInput, "dsdsdsddsdsd");
		typeIn(OR.Profile_NewPasswordInput, NewPassword);
		clickOn(OR.Profile_Updatebtn);
	//	verifyElementText(OR.Profile_Passwordvalidation2, "New password and confirm password must be same.");
		if(driver.findElements(By.xpath("//*[text()='OK']")).size()!=0)
		{
			clickOn(OR.OKBtn);
		}
		typeIn(OR.Profile_OldPasswordInput, OldPassword);
		typeIn(OR.Profile_ConfirmPasswordInput, NewPassword);
		typeIn(OR.Profile_NewPasswordInput, NewPassword);
		clickOn(OR.Profile_Updatebtn);
	}
}

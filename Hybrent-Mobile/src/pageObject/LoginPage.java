package pageObject;

import org.openqa.selenium.interactions.ClickAction;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class LoginPage extends ApplicationKeyword{
	
	public static void login(String Username, String password)
	{
		waitForElementToDisplay(OR.Login_link, 6);
		if(isElementDisplayed(OR.Login_link))
		{
			clickOn(OR.Login_link);
		}
		typeIn(OR.Login_Username, Username);
		typeIn(OR.Login_password, password);
		keyboardhide();
		clickOn(OR.Login_Submit);
	}
	 

}

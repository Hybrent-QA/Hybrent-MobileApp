package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ShopPage extends ApplicationKeyword {
	public void LoginHybrebtLink()
	{
		waitForElement(OR.Login_LoginWithHybrent);
		if(isElementDisplayed(OR.Login_LoginWithHybrent))
		{
			clickOn(OR.Login_LoginWithHybrent);
		}
		else
		{
			testLogFail("Unable to click on Login with Hybrent");
		}
	}
	
	public static void NavigateToShop()
	{
		waitForElementToDisplay(OR.HamberGun, 6);
		if(isElementDisplayed(OR.HamberGun))
		{	
			clickOn(OR.HamberGun);
			clickOn(OR.Shop);
			
		}
		else
		{
			testLogFail("Unabble to click hambergun menu");
		}
	}
	public static void VisibleAddtocart()
	{
		waitforPaageload();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(By.xpath("(//*[@collection-repeat='item in searchResult.items']//*[starts-with(@class, 'item-options')])[1]"));
		System.out.println(e.getAttribute("class"));
		js.executeScript("arguments[0].className = 'item-options'", e);
		WebElement e1 = driver.findElement(By.xpath("(//*[@class='item-content'])[1]"));
		js.executeScript("arguments[0].style = 'transform: translate3d(-103px, 0px, 0px);'", e1);
	}
	
	public static void Addtocart()
	{
		waitforPaageload();
		if(isElementDisplayed(OR.Shop_AddTOcart))
		{
			verifyElement(OR.Shop_DonotAddtoCart);
			clickOn(OR.Shop_AddTOcart);
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[contains(text(),'This item is not under contract or a preference item from your distributor, It may cost more.')]")).size()!=0)
			{
				testLogPass("Cotactpric validation "+getText(OR.Shop_Validation_contractprice));
				clickOn(OR.Continue);
			}
			WebElement ele =driver.findElement(By.xpath("(//*[@collection-repeat='item in searchResult.items']//*[starts-with(@class, 'item-options')])[1]"));
			String s = ele.getAttribute("class");
			if(s.contains("invisible"))
			{
				System.out.println("Remove is invisible");
			}
			else
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement e = driver.findElement(By.xpath("(//*[@collection-repeat='item in searchResult.items']//*[starts-with(@class, 'item-options')])[1]"));
				System.out.println(e.getAttribute("class"));
				js.executeScript("arguments[0].className = 'item-options invisible'", e);
			}
		}
	}
	public static void DoNotaddtocart()
	{
		waitforPaageload();
		if(isElementDisplayed(OR.Shop_DonotAddtoCart))
		{
			clickOn(OR.Shop_DonotAddtoCart);
		}
	}
	public static void IncreamsnetDecrementVerify()
	{
		waitforPaageload();
		String BeforeIncrement = getText(OR.Shop_Qty);
		clickOn(OR.Shop_Increament);
		String AfterIncrement = getText(OR.Shop_Qty);
		testLogPass(BeforeIncrement+" Before increment value After increment value is "+AfterIncrement);
		clickOn(OR.Shop_Decrement);
		String AfterDecrement = getText(OR.Shop_Qty);
		testLogPass(AfterIncrement+" After increment value "+AfterDecrement);
	}
	
	public static void RemoveBt()
	{
		waitforPaageload();
		verifyElement(OR.Shop_Remove);
		clickOn(OR.Shop_Remove);
		
		waitforPaageload();
		if(driver.findElements(By.xpath("(//strong)[1]")).size()!=0)
		{
			testLogFail("Itesm is not remove");
		}else
		{
			testLogPass("Itesm is remove");
		}
	}
	
	public static void ItemDetails()
	{
		
		waitforPaageload();
		if(driver.findElements(By.xpath("//*[starts-with(@class, 'item')]")).size()!=0)
		{
			clickOn(OR.Shop_Firstitem);
			waitforPaageload();
			int size = driver.findElements(By.xpath("//*[@class='input-label']")).size();
			String ItemList = null, ItemListSub = null;
			for(int i=1;i<=20;i++)
			{
			if(driver.findElements(By.xpath("(//*[@class='input-label'])["+i+"]")).size()!=0)
			{
				WebElement Element = driver.findElement(By.xpath("(//*[@class='input-label'])["+i+"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
				ItemList = Element.getText();
				
			}
			if(driver.findElements(By.xpath("(//*[starts-with(@class, 'item')]//*[starts-with(@class, 'input-data')])["+i+"]")).size()!=0)
			{
				WebElement Element = driver.findElement(By.xpath("(//*[starts-with(@class, 'item')]//*[starts-with(@class, 'input-data')])["+i+"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
				ItemListSub =Element.getText();
				
			}
			testLogPass(ItemList +" - "+ItemListSub);
			}
		}
	}
		public static void VendorDetails()
		{
			
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[starts-with(@class, 'item')]")).size()!=0)
			{
				clickOn(OR.Shop_Firstitem);
				clickOn(OR.Shop_VendorDetails);
				waitforPaageload();
				int size = driver.findElements(By.xpath("(//*[@class='card current-itemVendor']//*[@class='input-label'])")).size();
				String ItemList = null, ItemListSub = null;
				for(int i=1;i<=size;i++)
				{
				if(driver.findElements(By.xpath("(//*[@class='card current-itemVendor']//*[@class='input-label'])["+i+"]")).size()!=0)
				{
					WebElement Element = driver.findElement(By.xpath("(//*[@class='card current-itemVendor']//*[@class='input-label'])["+i+"]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
					ItemList = Element.getText();
					
				}
				if(driver.findElements(By.xpath("(//*[@class='card current-itemVendor']//*[starts-with(@class, 'input-data')])["+i+"]")).size()!=0)
				{
					WebElement Element = driver.findElement(By.xpath("(//*[@class='card current-itemVendor']//*[starts-with(@class, 'input-data')])["+i+"]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
					ItemListSub =Element.getText();
					
				}
				testLogPass(ItemList +" - "+ItemListSub);
				}
				
			}
	}
		
		public static void InventoryDetails()
		{
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[contains(text(),'There is no inventory for this product yet.')]")).size()!=0)
			{
				String one = driver.findElement(By.xpath("//*[contains(text(),'There is no inventory for this product yet.')]")).getText();
				testLogPass(one);
			}
		}
		

		public static void PriceChangeDetails()
		{
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[contains(text(),'There is no price change for this product yet.')]")).size()!=0)
			{
				String one = driver.findElement(By.xpath("//*[contains(text(),'There is no price change for this product yet.')]")).getText();
				testLogPass(one);
			}
		}
		
		public static void PriceChangeHistoryDetails()
		{
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[contains(text(),'There is no purchase history for this product yet.')]")).size()!=0)
			{
				String one = driver.findElement(By.xpath("//*[contains(text(),'There is no purchase history for this product yet.')]")).getText();
				testLogPass(one);
			}
			else
			{
				waitforPaageload();
			String one = driver.findElement(By.xpath("//*[@class='modal-bot-head ng-binding']")).getText();
			testLogPass(one);
			
			}
			
		}
		
		public static void vendorinfo()
		{
			clickOn(OR.Shop_FirstVendor);
			waitforPaageload();
			verifyElement(OR.Shop_CustomerSupport);
			verifyElement(OR.Shop_SalesRepresentative);
			verifyElement(OR.Shop_PurchaseHistory);
			int size = driver.findElements(By.xpath("(//*[@delegate-handle='vendorModalContent']//*[@class='input-label'])")).size();
			String ItemList = null, ItemListSub = null;
			for(int i=1;i<=size;i++)
			{
			if(driver.findElements(By.xpath("(//*[@delegate-handle='vendorModalContent']//*[@class='input-label'])["+i+"]")).size()!=0)
			{
				WebElement Element = driver.findElement(By.xpath("(//*[@delegate-handle='vendorModalContent']//*[@class='input-label'])["+i+"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
				ItemList = Element.getText();
				
			}
			if(driver.findElements(By.xpath("(//*[@delegate-handle='vendorModalContent']//*[starts-with(@class, 'input-data')])["+i+"]")).size()!=0)
			{
				WebElement Element = driver.findElement(By.xpath("(//*[@delegate-handle='vendorModalContent']//*[starts-with(@class, 'input-data')])["+i+"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
				ItemListSub = Element.getText();
			}
			testLogPass(ItemList +" - "+ItemListSub);
			
			}
			
		}
		
		public static void Customersupport()
		{
			clickOn(OR.Shop_CustomerSupport);
			if(driver.findElements(By.xpath("//*[contains(text(),'No customer support information added.')]")).size()!=0)
			{
				String validation = driver.findElement(By.xpath("//*[contains(text(),'No customer support information added.')]")).getText();
				testLogPass(validation);
			}
		}
		
		public static void SalesRepresent()
		{
			clickOn(OR.Shop_SalesRepresentative);
			if(driver.findElements(By.xpath("//*[contains(text(),'No sales representative information added.')]")).size()!=0)
			{
				String validation = driver.findElement(By.xpath("//*[contains(text(),'No sales representative information added.')]")).getText();
				testLogPass(validation);
			}
		}
		public static void PriceHistory()
		{
			clickOn(OR.Shop_PurchaseHistory);
			if(driver.findElements(By.xpath("//*[contains(text(),'No sales representative information added.')]")).size()!=0)
			{
				String validation = driver.findElement(By.xpath("//*[contains(text(),'No sales representative information added.')]")).getText();
				testLogPass(validation);
			}
			if(driver.findElements(By.xpath("(//*[@class='item purshase-item'])[1]")).size()!=0)
			{
				clickOn(OR.Shop_ItemPriceHistory);
				testLogPass("Item name "+getText(OR.Shop_ItemPriceHistory));
				testLogPass("Item Date "+getText(OR.Shop_Item_Date));
				testLogPass("Item status "+getText(OR.Shop_Item_status));
			}
		}
			
}


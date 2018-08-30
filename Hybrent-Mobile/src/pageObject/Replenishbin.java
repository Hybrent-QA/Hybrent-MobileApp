package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import io.appium.java_client.AppiumDriver;

public class Replenishbin extends ApplicationKeyword{
	
	public static void NavigateReplenishBin()
	{
		waitForElementToDisplay(OR.HamberGun, 5);
		clickOn(OR.HamberGun);
		WebElement ReplenishBin = driver.findElementByXPath("//*[starts-with(@class, 'menu-text') and text()='Replenish Bin']");
	//	Profile.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ReplenishBin);
		ReplenishBin.click();
		testLogPass("clicked on ReplenishBin");
		testLogPass("title is "+driver.getTitle());
	}
	
	public static void verifyPage()
	{
		verifyElement(OR.Replenishbin_Facility);
		verifyElement(OR.Replenishbin_inventory);
		verifyElement(OR.Replenishbin_Department);
		verifyElement(OR.Replenishbin_Facility_Label);
		verifyElement(OR.Replenishbin_Inventory_Label);
		verifyElement(OR.Replenishbin_Department_Label);
		getDropDownText(OR.Replenishbin_Facility, 1);
		getDropDownText(OR.Replenishbin_inventory, 1);
		getDropDownText(OR.Replenishbin_Department, 1);
		verifyElement(OR.Close);
		verifyElement(OR.Next);
		verifyElement(OR.Reset);
		
	}

	public static void ResetValidation()
	{
		verifyElement(OR.Reset);
		clickOn(OR.Reset);
		getDropDownText(OR.Replenishbin_Facility, 1);
		getDropDownText(OR.Replenishbin_inventory, 1);
		getDropDownText(OR.Replenishbin_Department, 1);
		switchToNative(driver);
	}
	
	public static void ResetValidDetails()
	{
		selectFromDropdown(OR.Replenishbin_Facility, 1);
		selectFromDropdown(OR.Replenishbin_inventory, 1);
		selectFromDropdown(OR.Replenishbin_Department, 1);
		clickOn(OR.Next);
		verifyElement(OR.Search);
		verifyElement(OR.Scan);
		verifyElementText(OR.Replenishbin_Validation, "You have not added any item for replenishment.");
	}
	public static void Search()
	{
		clickOn(OR.Next);
		clickOn(OR.Shop_search);
		verifyElement(OR.Shop_search);
		verifyElement(OR.Shop_searchBtn);
		verifyElement(OR.Scan);
		getAttributeValue(OR.Shop_search, "placeholder");
		getText(OR.Shop_Firstitem);
		getText(OR.Shop_FirstVendor);
		getText(OR.Shop_FirstPrice);
		getText(OR.Shop_First_Sku);
		
		
	}
	
	public static void AddtoItem()
	{
		clickOn(OR.Next);
		clickOn(OR.Shop_search);
		
	}
	
	public static void VisibleAddtocart()
	{
		waitforPaageload();
		String xpath="//*[starts-with(@class, 'item-options')]";
		WebElement SearchItem = driver.findElement(By.xpath("//*[@collection-repeat='item in searchResult.items']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int size = driver.findElements(By.xpath("//*[starts-with(@class, 'item-options')]")).size();
		System.out.println(size);
		if(size!=0)
		{
		for(int i=1;i<=size;i++)
		{
			WebElement e = SearchItem.findElement(By.xpath("("+xpath+")[1]"));
			System.out.println(e.getAttribute("class"));
			js.executeScript("arguments[0].className = 'item-options'", e);
			System.out.println(e.getAttribute("class"));
			String attr = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div")).getAttribute("class");
			System.out.println(attr);
			String Style = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div")).getAttribute("style");
			if(Style.isEmpty())
			{
				WebElement Style1 = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div"));
				js.executeScript("arguments[0].style='transform: translate3d(-52px, 0px, 0px);'", Style1);
				System.out.println(Style1.getAttribute("style"));
				break;
			}
		}
		}else
		{
			System.out.println("Item is in add to item");
		}

	}
	
	public static void RecicleAddtocart()
	{
		waitforPaageload();
		if(isElementDisplayed(OR.Replenishbin_addToReplenishment))
		{
			clickOn(OR.Replenishbin_addToReplenishment);
			waitforPaageload();
		}
		
	}
	
	public static void verifyHalffull()
	{
		verifyElement(OR.Replenishbin_full);
		verifyElement(OR.Replenishbin_half);
		clickOn(OR.Replenishbin_full);
		String getParlevel= "Parlevel#xpath=//*[@ng-click='changeQty(item.replenish_bin_item, 'half')']/following-sibling::span//stron";
		testLogPass("par level "+getText(getParlevel));
		clickOn(OR.Replenishbin_half);
		String getParlevel1 = "Parlevel#xpath=//*[@ng-click='changeQty(item.replenish_bin_item, 'half')']/following-sibling::span//stron";
		testLogPass("par level "+getText(getParlevel1));
	}
	
	public static void Remove()
	{
		waitforPaageload();
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
	
	public static void VisibleRemove()
	{
		waitforPaageload();
		String xpath="//*[starts-with(@class, 'item-options')]";
		WebElement SearchItem = driver.findElement(By.xpath("//*[@collection-repeat='item in searchResult.items']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int size = driver.findElements(By.xpath("//*[starts-with(@class, 'item-options')]")).size();
		System.out.println(size);
		if(size!=0)
		{
		for(int i=1;i<=size;i++)
		{
			WebElement e = SearchItem.findElement(By.xpath("("+xpath+")[1]"));
			System.out.println(e.getAttribute("class"));
			js.executeScript("arguments[0].className = 'item-options'", e);
			System.out.println(e.getAttribute("class"));
			String attr = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div")).getAttribute("class");
			System.out.println(attr);
			String Style = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div")).getAttribute("style");
			if(Style.isEmpty())
			{
				WebElement Style1 = driver.findElement(By.xpath("//*[@class='item-options']/following-sibling::div"));
				js.executeScript("arguments[0].style='transform: translate3d(-82px, 0px, 0px);'", Style1);
				System.out.println(Style1.getAttribute("style"));
				break;
			}
		}
		}else
		{
			System.out.println("Item is in add to item");
		}
	}
	
	public static void VerifyAdded()
	{
		String ItemName = getText(OR.Shop_Firstitem);
		clickOn(OR.Close1);
		String ItemName1 = getText(OR.Shop_Firstitem);
		if(ItemName.contains(ItemName1))
		{
			testLogPass(ItemName1 +" Added item are same "+ItemName);
		}
		else
		{
			testLogFail(ItemName1 +" Added item are same "+ItemName);
		}
		testLogPass("Vendorname "+getText(OR.Replenishbin_FirstVendor));
		testLogPass("Price "+getText(OR.Replenishbin_FirstPrice));
//		testLogPass("Sku "+getText(OR.Shop_FirstSku));
//		testLogPass("Status "+getText(OR.Shop_Color));
		verifyElement(OR.Replenishbin_full1);
		//verifyElement(OR.Replenishbin_half1);
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
		clickOn(OR.Close);
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
		
		public static void clear()
		{
			verifyElement(OR.Clear);
			clickOn(OR.Clear);
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[text()='Are you sure you want to clear Replenish bin ?']")).size()!=0)
			{
				verifyElementText(OR.Replenishbin_validation1, "Are you sure you want to clear Replenish bin ?");
				verifyElement(OR.Replenishbin_Cancel);
				verifyElement(OR.Replenishbin_OK);
				clickOn(OR.Replenishbin_Cancel);
			}
			clickOn(OR.Clear);
			waitforPaageload();
			if(driver.findElements(By.xpath("//*[text()='Are you sure you want to clear Replenish bin ?']")).size()!=0)
			{
				clickOn(OR.Replenishbin_OK);
				verifyElementText(OR.Replenishbin_validation2, "Items successfully cleared from Replenish bin.");
				clickOn(OR.Replenishbin_OK);
			}
			
		}
		
		public static void Replenish()
		{
			clickOn(OR.createPO);
			testLogPass("page title "+driver.getTitle());
			clickOn(OR.Replenishbin_Filters);
			selectFromDropdown(OR.Replenishbin_type, "Replenishment");
			clickOn(OR.Replenishbin_Apply);
			waitforPaageload();
			String one = driver.findElement(By.xpath("(//h2)[1]")).getText();
			System.out.println(one);
			
			
		}
}

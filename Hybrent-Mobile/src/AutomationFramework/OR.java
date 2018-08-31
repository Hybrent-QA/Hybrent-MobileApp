package AutomationFramework;

import org.openqa.selenium.By;

public class OR {

	// Login Page
	public static String Login_link="LinkLogin#partiallinktext=Login with Hybrent";
	public static String Login_siteName="SiteName#findelementbyid=siteName";
	public static String Login_gobtn="gobtn#xpath=//button[@id='go-btn']";
	public static String Login_LoginWithHybrent="LoginWithHybrent#findElementsbypartiallinktext=Login with Hybrent";
	public static String Login_Username="Username#findElementbyxpath=//*[@ng-model='model.userName']";
	public static String Login_password="password#findElementbyxpath=//*[@ng-model='model.password']";
	public static String Login_Submit="Submit#findElementbyxpath=//*[@type='submit']";
	
	// commone
	public static String HamberGun ="Hambergun#xpath=//*[@nav-bar='active']//*[@ng-click='myGoBack()']/following-sibling::div//button";
	public static String Close ="Close#xpath=//*[@ng-click='closeModal();']";
	public static String Close1 ="Close#xpath=//*[text()='Close']";
	public static String OKBtn ="OK#xpath=//*[text()='OK']";
	public static String Continue ="Continue#xpath=//button[text()='Continue']";
	public static String Reset ="ResetSearch#xpath=//*[@ng-click='resetSearchFilters()']";
	public static String Next ="Next#xpath=//*[text()='Next']";
	public static String Clear ="Clear#xpath=//*[text()='Clear']";
	public static String createPO ="createPO#xpath=//*[@ng-click=\"createPO()\"]";
	public static String Search ="Search#xpath=//*[@placeholder='search']";
	public static String Scan ="Scan#xpath=//*[@ng-click='startScan()']";
	public static String Btn_NO ="NO#xpath=//button[text()='No']";
	public static String Btn_Yes ="Yes#xpath=//button[text()='Yes']";
	
	
	// Shop
	
	public static String Shop_VendorDetails ="VendorDetails#xpath=//*[contains(text(),'Vendor Details')]";
	public static String Shop ="ShoMenu#xpath=//*[contains(text(),'Shop')]";
	public static String Shop_search ="Search#xpath=//*[@ng-model='searchForm.search']";
	public static String Shop_searchBtn ="SearchBtn#xpath=//*[@ng-model='search()']";
	public static String Shop_Firstitem = "Itemname#xpath=(//*[@id='title'])[1]";
	public static String Shop_FirstVendor = "Vendorname#xpath=(//vendor)[1]";
	public static String Shop_Color = "Color#xpath=(//*[@ng-click=;init()'])[1]";
	public static String Shop_Favorite = "Favorite#xpath=(//*[@uib-tooltip='Favorite'])[1]";
	public static String Shop_FirstPrice = "Price#xpath=(//*[@ng-if='item']//p/span)[1]";
	public static String Shop_FirstSku = "Sku#xpath=(//*[@ng-if='item']/span)[1]";
	public static String Shop_First_Sku = "Sku#xpath=(//*[@class='item-note ng-binding'])[1]";
	public static String Shop_AddTOcart = "AddTOcart#xpath=//*[@ng-click='addItemToCart(item)']";
	public static String Shop_ContinueBtn = "Continue#xpath=//button[contains(text(),'Continue')]";
	public static String Shop_DonotAddtoCart = "DoNotAddToCart#xpath=//button[contains(text(),'Do not add to cart')]";
	public static String Shop_Validation_contractprice = "Validationt#xpath=//*[contains(text(),'This item is not under contract or a preference item from your distributor, It may cost more.')]";
	public static String Shop_Decrement = "decrementQty#xpath=//*[@ng-click='decrementQty(item.item_vendor_id)']";
	public static String Shop_Remove = "Remove#xpath=//*[@ng-click='removeFromCart(item.cart_item.id)']";
	public static String Shop_Increament ="incrementQty#xpath=//*[@ng-click=\"incrementQty(item.item_vendor_id)\"]";
	//public static String Shop_Remove = "Removebtn#xpath=//button[start-with(@ng-click,'removeFromCart')]";
	public static String Shop_Qty = "Qty#xpath=(//strong)[1]";
	public static String Shop_CustomerSupport = "CustomerSupport#xpath=//*[@ng-bind-html='title' and text()='Customer Support']";
	public static String Shop_SalesRepresentative = "SalesRepresentative#xpath=//*[@ng-bind-html='title' and text()='Sales Representative']";
	public static String Shop_PurchaseHistory = "PurchaseHistory#xpath=//*[@ng-bind-html='title' and text()='Purchase History']";
	public static String Shop_ItemPriceHistory = "Items1#xpath=(//*[@class='item purshase-item'])[1]";
	public static String Shop_Item_Date = "Date#xpath=(//*[@class='item purshase-item']/p)[1]";
	public static String Shop_Item_status = "Status#xpath=(//*[@class='item purshase-item']//*[starts-with(@class, 'item-note')])[1]";
	
	// Replenishbin
	public static String Replenishbin_Facility = "Facility#id=facility";
	public static String Replenishbin_Department = "Department#id=department";
	public static String Replenishbin_inventory = "inventory#id=inventory";
	public static String Replenishbin_Facility_Label = "Facility_Label#xpath=//*[text()='Facility']";
	public static String Replenishbin_Department_Label = "Department_Label#xpath=//*[text()='Department']";
	public static String Replenishbin_Inventory_Label = "Inventory_Label#xpath=//*[text()='Inventory']";	
	public static String Replenishbin_Validation = "Validation#xpath=//*[text()='You have not added any item for replenishment.']";
	public static String Replenishbin_full = "full#xpath=(//*[@ng-click=\"changeQty(item.replenish_bin_item, 'full')\"])[1]";
	public static String Replenishbin_half = "half#xpath=(//*[@ng-click=\"changeQty(item.replenish_bin_item, 'half')\"])[1]";
	public static String Replenishbin_full1 = "full#xpath=(//*[text()='Full'])[1]";
	public static String Replenishbin_half1 = "half#xpath=(//*[text()='Half'])[1]\";";
	public static String Replenishbin_addToReplenishment = "addToReplenishment#xpath=(//*[@ng-click='addToReplenishment(item.item_vendor_id)'])[1]";
	public static String Replenishbin_FirstVendor = "Vendorname#xpath=(//vendor/span)[1]";
	public static String Replenishbin_FirstPrice = "Price#xpath=(//*[@ng-if='item']//p)[1]";
	public static String Replenishbin_item = "item#xpath=//item";
	public static String Replenishbin_Cancel = "Cancel#xpath=//*[text()='Cancel']";
	public static String Replenishbin_OK = "OK#xpath=//*[text()='OK']";
	public static String Replenishbin_type = "type#xpath=//*[@id='type']";
	public static String Replenishbin_Apply = "Apply#xpath=//*[text()='Apply']";
	public static String Replenishbin_Filters = "Filters#xpath=//*[text()='Filters']";
	public static String Replenishbin_validation1 = "validation#xpath=//*[text()='Are you sure you want to clear Replenish bin ?']";
	public static String Replenishbin_validation2 = "Sucessvalidation#xpath=//*[text()='Items successfully cleared from Replenish bin.']";
	
	
	// Profile
	public static String Profile ="Profile#xpath=//*[contains(text(),'Profile')]";
	public static String Profile_Pic="ProfilePic#xpath=//*[@class='user-img']";
	public static String Profile_ChangePassword="Changepassword#xpath=//*[text()='Change Password']";
	public static String Profile_ChangePasswordTitle="Changepassword#xpath=//h1[text()='Change Password']";
	public static String Profile_OldPassword="Oldpassword#xpath=//*[text()='Old Password']";
	public static String Profile_ConfirmPassword="Confirmpassword#xpath=//*[text()='Confirm Password']";
	public static String Profile_NewPassword="Newpassword#xpath=//*[text()='New Password']";
	public static String Profile_Updatebtn="Updatepassword#xpath=//*[@ng-click='changePassword()']";
	public static String Profile_OldPasswordInput="InputOldpassword#findelementbyid=oldpassword";
	public static String Profile_ConfirmPasswordInput="InputConfirmpassword#findelementbyid=confirmpassword";
	public static String Profile_NewPasswordInput="InputNewpassword#findelementbyid=newpassword";
	public static String Profile_Passwordvalidation="validation#xpath=//*[contains(text(),'Please provide correct old password')]";
	public static String Profile_Passwordvalidation1="validation1#xpath=//*[contains(text(),'New password and confirm password must be same.')]";
	public static String Profile_Passwordvalidation2="validation1#xpath=//*[contains(text(),'All fields are required and of minimum 6 characters in length.')]";
	
	
	// Notification
	public static String Notification ="Notification#xpath=//*[@nav-bar='active']//*[@ng-click='getNotifications();']";
	public static String Notification_Count ="NotificationCount#xpath=//*[@nav-bar='active']//*[@ng-click='getNotifications();']/i";
	public static String Notification_Title ="NotificationTitle#xpath=(//*[@class='item-content']/small)[1]";
	public static String Notification_TabtoMarkRead ="TabtoMarkRead#xpath=(//*[contains(text(),'Tap to mark read')])[1]";
	public static String Notification_TabtoMarkRead1 ="TabtoMarkRead#xpath=//*[contains(text(),'Tap to mark read')]";

	// New Event
	public static String NewsEvent ="Notification#xpath=//*[starts-with(@class, 'menu-text') and text()='News & Events']";
	
	
	//Cart 
	public static String Cart ="Cart#xpath=(//*[@href=\"#/app/hyb-cart\"])[2]";
	public static String Cart_Title ="Title#xpath=//*[@nav-bar='active']//*[@class='title title-left header-item']";
	public static String Cart_CartFor ="CartFor#xpath=//*[contains(text(),'Cart For')]";
	public static String Cart_Selected_Facility ="Facility#xpath=//hyb-select//a[@ng-click='openModal();']";
	public static String Cart_GeneratePo ="GeneratePo#xpath=//button[contains(text(),'Generate PO')]";
	public static String Cart_Vendors ="Vendors#xpath=//*[contains(text(),'Vendors')]";
	public static String Cart_Increment ="Increment#xpath=//*[@ng-click='incrementQty(cartItem.item_vendor_id)']";
	public static String Cart_Decrement ="Decrement#xpath=//*[@ng-click='decrementQty(cartItem.item_vendor_id)']";
	public static String Cart_label_ReceiveonlySelectVendors ="Receiveonly#xpath=//p[text()='Receive Only']";
	public static String Cart_label_Usermypo ="UseMyPo#xpath=//p[text()='Use My PO #']";
	public static String Cart_label_specialinstuction ="SpecialInstruction#xpath=//p[text()='Special Instruction']";
	public static String Cart_Usermypo_toogle ="UseMyPo_toogle#xpath=//*[text()='Use My PO #']/following-sibling::label";
	public static String Cart_ReceiveOnly_toogle ="ReceiveOnly_toogle#xpath=//*[text()='Receive Only']/following-sibling::label";
	public static String Cart_SpecialInstruction_toogle ="SpecialInstruction_toogle#xpath=//*[text()='Special Instruction']/following-sibling::label";
	public static String Cart_Input_PO ="InputPo#xpath=//*[@placeholder='PO #']";
	public static String Cart_Input_SI ="InputPo#xpath=//*[@placeholder='Special Instruction']";
	public static String Cart_TitleSI ="TitleSI#xpath=//h1[text()='Special Instructions']";
	public static String Cart_Fist_SI ="Fist_SI#xpath=(//*[@class='item-content ng-binding'])[1]";
	public static String Cart_Fist_SI_Input ="InputSI#xpath=(//*[@id='specialInstructionSearchQuery'])[1]";
	
	public static String Cart_SelectVendors ="SelectVendors#xpath=//select[@id='vendor']";
	public static String Cart_Pricevendorname ="Pricevendorname#xpath=//li[@class='item item-divider']/b";
	public static String Cart_Facility_Select ="SelectBtn#xpath=//button[contains(text(),'Select')]";
	public static String Cart_Title_Shipmentlocatopn ="Title_Shipmentlocatopn#xpath=//h1[contains(text(),'Select Shipping Location')]";
}










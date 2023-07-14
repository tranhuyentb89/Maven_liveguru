package commons;

import org.openqa.selenium.WebDriver;

import pageObject.BE_LoginPageObject;
import pageObject.BE_ManageCustomerPageObject;
import pageObject.FE_AdvanceSearchPageObject;
import pageObject.FE_CheckoutCartPageObject;
import pageObject.FE_CompareWindowPageObject;
import pageObject.FE_HomePageObject;
import pageObject.FE_Landing_Cart_ProductPageObject;
import pageObject.FE_OrderPageObject;
import pageObject.FE_RegisterPageObject;
import pageObject.FE_ShoppingCartPageObject;
import pageObject.FE_WishListWindowPageObject;

public class PageFactoryManage {

	public static FE_Landing_Cart_ProductPageObject getLandingPage(WebDriver driver) {
		return new FE_Landing_Cart_ProductPageObject(driver);
	}
	
	public static FE_RegisterPageObject getRegisterPage(WebDriver driver) {
		return new FE_RegisterPageObject(driver);
	}

	public static FE_HomePageObject getHomePage(WebDriver driver) {
		return new FE_HomePageObject(driver);
	}

	public static FE_CompareWindowPageObject getCompareWindowPage(WebDriver driver) {
		return new FE_CompareWindowPageObject(driver);
	}

	public static FE_WishListWindowPageObject getWistListPage(WebDriver driver) {
		return new FE_WishListWindowPageObject(driver);
	}

	public static FE_ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new FE_ShoppingCartPageObject(driver);
	}

	public static FE_CheckoutCartPageObject getCheckoutCartPage(WebDriver driver) {
		return new FE_CheckoutCartPageObject(driver);
	}

	public static FE_OrderPageObject getOrderPage(WebDriver driver) {
		return new FE_OrderPageObject (driver);
	}

	public static FE_AdvanceSearchPageObject getAdvanceSearchPage(WebDriver driver) {
		return new FE_AdvanceSearchPageObject(driver);
	}

	public static BE_LoginPageObject getBE_LoginPage(WebDriver driver) {
		return new BE_LoginPageObject(driver);
	}

	public static BE_ManageCustomerPageObject getManageCustomerPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new BE_ManageCustomerPageObject(driver);
	}

}

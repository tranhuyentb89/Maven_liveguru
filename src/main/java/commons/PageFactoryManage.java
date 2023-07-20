package commons;

import org.openqa.selenium.WebDriver;

import pageObject.*;

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

    public static FE_ReviewPageObject getReviewPage(WebDriver driver) {
    	return new FE_ReviewPageObject(driver);
	}
}

package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_LandingPageUI;
import com.bankguru.frontend.FE_ShoppingCartUI;

import commons.AbstractPageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class FE_Landing_Cart_ProductPageObject extends AbstractPages {

	private WebDriver driver;

	public FE_Landing_Cart_ProductPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clicktoHeaderAccountLink() {
		clickToElement(driver, FE_LandingPageUI.HEADER_ACCOUNT_LINK);
	}

	public String getCostOfProductInDetail() {
		highlightElement(driver, FE_LandingPageUI.PRICE_IN_DETAIL);
		return getTextOfElement(driver, FE_LandingPageUI.PRICE_IN_DETAIL);
	}

	public void clickToApplyButton() {
		highlightElement(driver, FE_LandingPageUI.APPLY_BUTTON);
		clickToElement(driver, FE_LandingPageUI.APPLY_BUTTON);
	}

	public String getGranTotalAmount() {
		highlightElement(driver, FE_LandingPageUI.GRAND_TOTAL_AMOUNT);
		return getTextOfElement(driver, FE_LandingPageUI.GRAND_TOTAL_AMOUNT);
	}

	public void clickToEmptyCartLink() {
		highlightElement(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_BUTTON);
	}


	public Object getErrorMsgInCard() {
		return getTextOfElement(driver, FE_LandingPageUI.ERROR_MSG_ON_CARD);
	}

	public Object getEmptyMsgFromCart() {
		return getTextOfElement(driver, FE_LandingPageUI.EMPTY_CART_MSG);
	}

	public boolean isShopingCartTableUnDisplayed() {
		return isControlUndisplayed(driver, FE_LandingPageUI.SHOPING_CART_TABLE);
	}

	public void switchToCampareWindow(String windowTitle) {
		switchToWindowByTitle(driver, windowTitle);
	}

	public void closeWindow() {
		String parentWindow = driver.getWindowHandle();
		closeAllWindowWithoutParentWindows(driver, parentWindow);
	}

	public Object getMsgSuccessAfterSubmit() {
		return getTextOfElement(driver, FE_LandingPageUI.MSG_SUCCESS_AFTER_SUBMIT);
	}

	public void inputToQuantityBox(String string) {
		sendKeyToElement(driver, FE_ShoppingCartUI.QUANTITY_TEXTBOX, string);
	}

}

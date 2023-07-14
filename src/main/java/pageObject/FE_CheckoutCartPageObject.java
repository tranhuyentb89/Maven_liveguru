package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.frontend.FE_CheckOutCardPageUI;

import commons.AbstractPages;

public class FE_CheckoutCartPageObject extends AbstractPages {
	WebDriver driver;

	public FE_CheckoutCartPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isOrderCodeIsDisplayed(String orderCode) {
		return isControlDisplayed(driver, FE_CheckOutCardPageUI.ORDER_CODE + "[text()='" + orderCode + "']");
	}

	public String getOrderCode() {
		return getTextOfElement(driver, FE_CheckOutCardPageUI.ORDER_CODE);
	}

	public void clickToOrderCode(String orderCode) {
		clickToElement(driver, FE_CheckOutCardPageUI.ORDER_CODE + "[text()='" + orderCode + "']");
	}

}
